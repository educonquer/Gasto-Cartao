package luan.melo.conquer.conquerprojectp2.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.google.gson.Gson;
import luan.melo.conquer.conquerprojectp2.api.retrofit.GastoCartaoApi;
import luan.melo.conquer.conquerprojectp2.dao.ExecucaoDao;
import luan.melo.conquer.conquerprojectp2.domain.Execucao;
import luan.melo.conquer.conquerprojectp2.domain.Gasto;
import luan.melo.conquer.conquerprojectp2.file.storage.gcloud.impl.GCloudStorageImpl;
import luan.melo.conquer.conquerprojectp2.service.ApiService;
import luan.melo.conquer.conquerprojectp2.service.ExecucaoService;
import luan.melo.conquer.conquerprojectp2.service.GastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ApiServiceImpl implements ApiService {

    @Autowired
    GastoService gastoService;

    @Autowired
    ExecucaoService execucaoService;

    Retrofit retrofit;

    GastoCartaoApi cartoesApi;

    SimpleDateFormat sdf;

    public ApiServiceImpl()
    {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://www.portaltransparencia.gov.br/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        cartoesApi = retrofit.create(GastoCartaoApi.class);
    }

    @Async
    public void execute(Execucao execucao) throws Exception {

        execucaoService.save(execucao);

        List<Gasto> todosGastosFiltro = new ArrayList<>();
//        List<String> filtro = getFiltro(execucao.getMesExtratoInicio(), execucao.getMesExtratoFinal());
//        for(String aux : filtro){
//
//            List<Gasto> gastosMounth = gastoService.findByExtractMounth(aux);
//            if(gastosMounth == null || gastosMounth.isEmpty())
//            {
//                gastosMounth = obterDadosApi(aux);
//                todosGastosFiltro.addAll(gastosMounth);
//            }
//            else{
//                todosGastosFiltro.addAll(gastosMounth);
//            }
//        }
        createAndUploadCSV(execucao, todosGastosFiltro);
        execucao.setStatus("FINALIZADO");
        execucaoService.update(execucao);
    }

    private void createAndUploadCSV(Execucao execucao, List<Gasto> todosGastosFiltro) throws Exception {
        File file = File.createTempFile("tmp", "teste");

        GCloudStorageImpl storage = new GCloudStorageImpl();
//		byte[] bytes = storage.download("gs://oystr-archive-test-sa/queue-files/2018/03/29/20180329.212059-rlirfi/amor.txt");
        storage.upload(execucao, file);


    }

    @Override
    public List<Execucao> obterResultados() {
        return execucaoService.findAll();
    }

    @Override
    public Execucao buscarPorId(Long id) {
        return execucaoService.findById(id);
    }

    private List<Gasto> obterDadosApi(String mes)
    {
        List<Gasto> todosGastos = new ArrayList<>();
        Integer i=1;
        while(true) {
            Map<String, String> data = new HashMap<>();
            data.put("mesExtratoInicio", mes);
            data.put("mesExtratoFim", mes);
            data.put("pagina", String.valueOf(i++));
            System.out.println(i);

            Call<List<Gasto>> call = cartoesApi.get(data, "eb6d7181ba9b39ecd792ed25bad3b1b6");
            System.out.println(call);
            try {
                Response<List<Gasto>> rGastos = call.execute();

                List<Gasto> gastos = rGastos.body();
                if(i == 10) break;
                if (gastos.isEmpty()) break;
                for (Gasto gasto : gastos) {
                    gastoService.save(gasto);
                }
                todosGastos.addAll(gastos);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return todosGastos;
    }

    private List<String> getFiltro(String mesExtratoInicio, String mesExtratoFim) throws ParseException {
        List<String> filtro = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
        Date dInicio = sdf.parse(mesExtratoInicio);
        Date dFim = sdf.parse(mesExtratoFim);

        final double MES_EM_MILISEGUNDOS = 30.0 * 24.0 * 60.0 * 60.0 * 1000.0;
        //final double MES_EM_MILISEGUNDOS = 2592000000.0;

        int numeroDeMeses = (int)((dFim.getTime() - dInicio.getTime())/MES_EM_MILISEGUNDOS);

        filtro.add(mesExtratoInicio);
        if(numeroDeMeses > 0);
        {
            for (int i=1; i<= numeroDeMeses; i++)
            {
                Calendar cal = Calendar.getInstance();
                cal.setTime(dInicio);
                cal.add(Calendar.MONTH, i);
                String d = sdf.format(cal.getTime());
                filtro.add(d);
            }
        }
        return filtro;
    }



}
