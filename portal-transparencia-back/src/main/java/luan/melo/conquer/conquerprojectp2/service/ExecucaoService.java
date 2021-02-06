package luan.melo.conquer.conquerprojectp2.service;

import luan.melo.conquer.conquerprojectp2.domain.Execucao;

import java.util.List;

public interface ExecucaoService {

    void save(Execucao execucao);

    void update(Execucao execucao);

    void delete(Long id);

    Execucao findById(Long id);

    List<Execucao> findAll();
}
