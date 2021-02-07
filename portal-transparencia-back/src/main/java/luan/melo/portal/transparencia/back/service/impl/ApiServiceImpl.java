package luan.melo.portal.transparencia.back.service.impl;

import com.opencsv.CSVWriter;
import luan.melo.portal.transparencia.back.api.retrofit.GastoCartaoApi;
import luan.melo.portal.transparencia.back.domain.Execucao;
import luan.melo.portal.transparencia.back.domain.Gasto;
import luan.melo.portal.transparencia.back.file.storage.gcloud.impl.GCloudStorageImpl;
import luan.melo.portal.transparencia.back.service.ApiService;
import luan.melo.portal.transparencia.back.service.ExecucaoService;
import luan.melo.portal.transparencia.back.service.GastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.File;
import java.io.FileWriter;
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
        List<String> filtro = getFiltro(execucao.getMesExtratoInicio(), execucao.getMesExtratoFinal());
        for(String aux : filtro){

            List<Gasto> gastosMounth = gastoService.findByExtractMounth(aux);
            if(gastosMounth == null || gastosMounth.isEmpty())
            {
                gastosMounth = obterDadosApi(aux);
                todosGastosFiltro.addAll(gastosMounth);
            }
            else{
                todosGastosFiltro.addAll(gastosMounth);
            }
        }
        createAndUploadCSV(execucao, todosGastosFiltro);
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

            Call<List<Gasto>> call = cartoesApi.get(data, "[colocar-chave-api-portal]");
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

    private void createAndUploadCSV(Execucao execucao, List<Gasto> todosGastosFiltro) throws Exception {
        File file = File.createTempFile("tmp", "teste");
        execucao.setStatus("FINALIZADO");

        CSVWriter writer = new CSVWriter(new FileWriter(file.getAbsoluteFile()));
        writer.writeNext(getColumns());
        for (Gasto gasto : todosGastosFiltro) {
            writer.writeNext(getValues(gasto));
        }

        writer.flush();
        writer.close();

        GCloudStorageImpl storage = new GCloudStorageImpl();
        storage.upload(execucao, file);

        execucaoService.update(execucao);
    }

    public String[] getColumns()
    {
        return new String[]{
                "ID",
                "DATA_TRANSACAO",
                "MES_TRANSACAO",
                "VALOR_TRANSACAO",
                "ESATABELECIMENTO_CODIGO_FORMATADO",
                "ESATABELECIMENTO_COMPLEMENTO_ENDERECO",
                "ESATABELECIMENTO_DATA_ABERTURA",
                "ESATABELECIMENTO_DESCRICAO_LOGRADOURO",
                "ESATABELECIMENTO_ENDERECO_ELETRONICO",
                "ESATABELECIMENTO_LOCALIDADE_PESSOA",
                "ESATABELECIMENTO_NOME",
                "ESATABELECIMENTO_NOME_BAIRRO",
                "ESATABELECIMENTO_NOME_FANTASIA_RECEITA",
                "ESATABELECIMENTO_NUMERO_CEP",
                "ESATABELECIMENTO_NUMERO_ENDERECO",
                "ESATABELECIMENTO_NUMERO_INSCRICAO_SOCIAL",
                "ESATABELECIMENTO_NUMERO_TELEFONE",
                "ESATABELECIMENTO_RAZAO_SOCIAL_RECEITA",
                "ESATABELECIMENTO_TIPO_CODIGO",
                "ESATABELECIMENTO_TIPO_PESSOA",
                "ESATABELECIMENTO_CNAE_CODIGO_CLASSE",
                "ESATABELECIMENTO_CNAE_CLASSE",
                "ESATABELECIMENTO_CNAE_CODIGO_DIVISAO",
                "ESATABELECIMENTO_CNAE_CODIGO_GRUPO",
                "ESATABELECIMENTO_CNAE_CODIGO_SECAO",
                "ESATABELECIMENTO_CNAE_CODIGO_SUBCLASSE",
                "ESATABELECIMENTO_CNAE_DIVISAO",
                "ESATABELECIMENTO_CNAE_GRUPO",
                "ESATABELECIMENTO_CNAE_SECAO",
                "ESATABELECIMENTO_CNAE_SUBCLASSE",
                "ESATABELECIMENTO_MUNICIPIO_CODIGO_IBGE",
                "ESATABELECIMENTO_MUNICIPIO_NOME_IBGE",
                "ESATABELECIMENTO_MUNICIPIO_PAIS",
                "ESATABELECIMENTO_MUNICIPIO_UF_SIGLA",
                "ESATABELECIMENTO_MUNICIPIO_UF_NOME",
                "ESATABELECIMENTO_NATUREZA_JURIDICA_CODIGO",
                "ESATABELECIMENTO_NATUREZA_JURIDICA_CODIGO_TIPO",
                "ESATABELECIMENTO_NATUREZA_JURIDICA_DESCRICAO",
                "ESATABELECIMENTO_NATUREZA_JURIDICA_DESCRICAO_TIPO",
                "PORTADOR_CODIGO_FORMATADO",
                "PORTADOR_NOME",
                "TIPO_CARTAO_ID",
                "TIPO_CARTAO_CODIGO",
                "TIPO_CARTAO_DESCRICAO",
                "UNIDADE_GESTORA_CODIGO",
                "UNIDADE_GESTORA_NOME",
                "UNIDADE_GESTORA_ORGAO_VINCULADO_CNPJ",
                "UNIDADE_GESTORA_ORGAO_VINCULADO_CODIGO_SIAFI",
                "UNIDADE_GESTORA_ORGAO_VINCULADO_DESCRICAO_PODER",
                "UNIDADE_GESTORA_ORGAO_VINCULADO_NOME",
                "UNIDADE_GESTORA_ORGAO_VINCULADO_SIGLA",
                "UNIDADE_GESTORA_ORGAO_VINCULADO_ORGAO_MAXIMO_CODIGO",
                "UNIDADE_GESTORA_ORGAO_VINCULADO_ORGAO_MAXIMO_NOME",
                "UNIDADE_GESTORA_ORGAO_VINCULADO_ORGAO_MAXIMO_SIGLA"
        };
    }

    public String[] getValues(Gasto gasto)
    {
        return new String[]{
                String.valueOf(gasto.getId()),
                gasto.getDataTransacao(),
                gasto.getMesExtrato(),
                gasto.getValorTransacao(),
                gasto.getEstabelecimento().getCodigoFormatado(),
                gasto.getEstabelecimento().getComplementoEndereco(),
                gasto.getEstabelecimento().getDataAbertura(),
                gasto.getEstabelecimento().getDescricaoLogradouro(),
                gasto.getEstabelecimento().getEnderecoEletronico(),
                gasto.getEstabelecimento().getLocalidadePessoa(),
                gasto.getEstabelecimento().getNome(),
                gasto.getEstabelecimento().getNomeBairro(),
                gasto.getEstabelecimento().getNomeFantasiaReceita(),
                gasto.getEstabelecimento().getNumeroCEP(),
                gasto.getEstabelecimento().getNumeroEndereco(),
                gasto.getEstabelecimento().getNumeroInscricaoSocial(),
                gasto.getEstabelecimento().getNumeroTelefone(),
                gasto.getEstabelecimento().getRazaoSocialReceita(),
                gasto.getEstabelecimento().getTipoCodigo(),
                gasto.getEstabelecimento().getTipoPessoa(),
                gasto.getEstabelecimento().getCnae().getCodigoClasse(),
                gasto.getEstabelecimento().getCnae().getClasse(),
                gasto.getEstabelecimento().getCnae().getCodigoDivisao(),
                gasto.getEstabelecimento().getCnae().getCodigoGrupo(),
                gasto.getEstabelecimento().getCnae().getCodigoSecao(),
                gasto.getEstabelecimento().getCnae().getCodigoSubclasse(),
                gasto.getEstabelecimento().getCnae().getDivisao(),
                gasto.getEstabelecimento().getCnae().getGrupo(),
                gasto.getEstabelecimento().getCnae().getSecao(),
                gasto.getEstabelecimento().getCnae().getSubclasse(),
                gasto.getEstabelecimento().getMunicipio().getCodigoIBGE(),
                gasto.getEstabelecimento().getMunicipio().getNomeIBGE(),
                gasto.getEstabelecimento().getMunicipio().getPais(),
                gasto.getEstabelecimento().getMunicipio().getUf().getSigla(),
                gasto.getEstabelecimento().getMunicipio().getUf().getNome(),
                gasto.getEstabelecimento().getNaturezaJuridica().getCodigo(),
                gasto.getEstabelecimento().getNaturezaJuridica().getCodigoTipo(),
                gasto.getEstabelecimento().getNaturezaJuridica().getDescricao(),
                gasto.getEstabelecimento().getNaturezaJuridica().getDescricaoTipo(),
                gasto.getPortador().getCodigoFormatado(),
                gasto.getPortador().getNome(),
                String.valueOf(gasto.getTipoCartao().getId()),
                gasto.getTipoCartao().getCodigo(),
                gasto.getTipoCartao().getDescricao(),
                gasto.getUnidadeGestora().getCodigo(),
                gasto.getUnidadeGestora().getNome(),
                gasto.getUnidadeGestora().getOrgaoVinculado().getCnpj(),
                gasto.getUnidadeGestora().getOrgaoVinculado().getCodigoSIAFI(),
                gasto.getUnidadeGestora().getOrgaoVinculado().getDescricaoPoder(),
                gasto.getUnidadeGestora().getOrgaoVinculado().getNome(),
                gasto.getUnidadeGestora().getOrgaoVinculado().getSigla(),
                gasto.getUnidadeGestora().getOrgaoVinculado().getOrgaoMaximo().getCodigo(),
                gasto.getUnidadeGestora().getOrgaoVinculado().getOrgaoMaximo().getNome(),
                gasto.getUnidadeGestora().getOrgaoVinculado().getOrgaoMaximo().getSigla()
        };
    }

    @Override
    public List<Execucao> obterResultados() {
        return execucaoService.findAll();
    }

    @Override
    public Execucao buscarPorId(Long id) {
        return execucaoService.findById(id);
    }





}
