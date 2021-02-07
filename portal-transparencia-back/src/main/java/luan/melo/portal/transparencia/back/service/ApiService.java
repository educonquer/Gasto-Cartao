package luan.melo.portal.transparencia.back.service;

import luan.melo.portal.transparencia.back.domain.Execucao;

import java.util.List;

public interface ApiService {

    void execute(Execucao execucao) throws Exception;

    List<Execucao> obterResultados();

    Execucao buscarPorId(Long id);
}
