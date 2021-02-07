package luan.melo.portal.transparencia.front.services;

import luan.melo.portal.transparencia.front.domain.Execucao;
import luan.melo.portal.transparencia.front.domain.ExecucaoApi;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

@Service
public class ExecucaoServiceImpl implements ExecucaoService {

    Retrofit retrofit;
    ExecucaoApi execucaoApi;


    public  ExecucaoServiceImpl(){
        retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:9321/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        execucaoApi = retrofit.create(ExecucaoApi.class);
    }

    @Override
    public void consultar(String mesExtratoInical, String mesExtratoFim) {

    }

    @Override
    public List<Execucao> buscarTodos() throws IOException {
        Call<List<Execucao>> call = execucaoApi.listarTodasExecs();

        Response<List<Execucao>> rExec = call.execute();

        List<Execucao> exec = rExec.body();

        System.out.println(exec);

        return exec;
    }

    @Override
    public Execucao buscarPorId(Long id) throws Exception {
        Call<Execucao> call = execucaoApi.listarPorId(id);
        Response<Execucao> rExec = call.execute();
        Execucao exec = rExec.body();
        return exec;
    }
}
