package luan.melo.conqueuer.front.web.controller;

import luan.melo.conqueuer.front.domain.Execucao;
import luan.melo.conqueuer.front.services.ExecucaoService;
import luan.melo.conqueuer.front.storage.gcloud.impl.GCloudStorageImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
@RequestMapping(path = "/execucao")
public class ExecucaoController {

    @Autowired
    ExecucaoService execucaoService;

    @RequestMapping(path="/cadastrar", method= RequestMethod.GET)
    public String paginaConsultar(Execucao execucao)
    {
        return "/execucao/cadastro";
    }

    @RequestMapping(path="/listar", method= RequestMethod.GET)
    public String obterTodosResultados(ModelMap model) throws IOException {
        model.addAttribute("execucao", execucaoService.buscarTodos());

        return "/execucao/lista";
    }

    @RequestMapping(path="/consultar", method= RequestMethod.POST)
    public String consultar(Execucao execucao)
    {
        return "redirect:/execucao/listar";
    }

    @RequestMapping(path= "/csv/{id}", method = RequestMethod.GET)
    public ResponseEntity<Resource> baixarDocumento(@PathVariable("id") Long id) throws Exception {

        System.out.println(id);

        Execucao execucao = execucaoService.buscarPorId(id);

        GCloudStorageImpl storage = new GCloudStorageImpl();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        System.out.println(execucao);

        byte[] file = storage.download(execucao.getLocalArquivo() + execucao.getNomeArquivo());
        ByteArrayResource resource = new ByteArrayResource(file);

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }


}
