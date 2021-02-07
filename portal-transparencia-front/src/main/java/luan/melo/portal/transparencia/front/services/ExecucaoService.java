package luan.melo.portal.transparencia.front.services;

import luan.melo.portal.transparencia.front.domain.Execucao;

import java.io.IOException;
import java.util.List;

public interface ExecucaoService {

    void consultar(String mesExtratoInical, String mesExtratoFim);

    List<Execucao> buscarTodos() throws IOException;

    Execucao buscarPorId(Long id) throws Exception;
}
