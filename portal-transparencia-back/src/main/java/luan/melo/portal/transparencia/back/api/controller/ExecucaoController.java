package luan.melo.portal.transparencia.back.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import luan.melo.portal.transparencia.back.domain.Execucao;
import luan.melo.portal.transparencia.back.service.ApiService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Api(tags = {"GastoController"})
@RestController
@RequestMapping(path = "/api")
public class ExecucaoController
{
    @Autowired
    ApiService apiService;

    SimpleDateFormat sdf;
    SimpleDateFormat sdfAno;
    SimpleDateFormat sdfMes;
    SimpleDateFormat sdfDia;

    public ExecucaoController()
    {
        sdf = new SimpleDateFormat("yyyyMMdd.HHmmss");
        sdfAno = new SimpleDateFormat("yyyy");
        sdfMes = new SimpleDateFormat("MM");
        sdfDia = new SimpleDateFormat("dd");
    }

    @ApiOperation(value = "Gastos por meio de cartão de pagamento")
        @RequestMapping(path = "/consultar", method = RequestMethod.GET)
    public Execucao get(@RequestParam("mesExtratoInicio") String mesExtratoInicio,
                        @RequestParam("mesExtratoFim") Optional<String> mesExtratoFim) throws Exception {
        Date date = new Date();
        String idExecucao = sdf.format(date) + "-" + RandomStringUtils.randomAlphanumeric(6);
        String ano = sdfAno.format(date);
        String mes = sdfMes.format(date);
        String dia = sdfDia.format(date);

        Execucao execution = Execucao
            .builder()
            .idExecucao(idExecucao)
            .localArquivo("gs://conquer-api-storage/report-files/" + ano + "/" + mes + "/" + dia + "/")
            .nomeArquivo(idExecucao + ".csv")
            .mesExtratoInicio(mesExtratoInicio)
            .mesExtratoFinal(mesExtratoFim.isPresent()? mesExtratoFim.get() : mesExtratoInicio)
            .status("OBTENDO DADOS")
            .build();

        System.out.println("teste");

        apiService.execute(execution);



        return execution;
    }

    @ApiOperation(value = "Gastos por meio de cartão de pagamento")
    @RequestMapping(path = "/execucoes", method = RequestMethod.GET)
    public List<Execucao> buscarTodasExec() {
        return apiService.obterResultados();
    }

    @RequestMapping(path = "/execucoes/{id}", method = RequestMethod.GET)
    public Execucao buscarPorId(@PathVariable("id") Long id){
        return apiService.buscarPorId(id);
    }
}
