package luan.melo.conqueuer.front.services;

import luan.melo.conqueuer.front.domain.Execucao;

import java.io.IOException;
import java.util.List;

public interface ExecucaoService {

    void consultar(String mesExtratoInical, String mesExtratoFim);

    List<Execucao> buscarTodos() throws IOException;

    Execucao buscarPorId(Long id) throws Exception;
}
