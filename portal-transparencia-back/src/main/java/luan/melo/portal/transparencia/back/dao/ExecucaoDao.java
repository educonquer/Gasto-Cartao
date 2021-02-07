package luan.melo.portal.transparencia.back.dao;

import luan.melo.portal.transparencia.back.domain.Execucao;

import java.util.List;

public interface ExecucaoDao {

    void save(Execucao execucao);

    void update(Execucao execucao);

    void delete(Long id);

    Execucao findById(Long id);

    List<Execucao> findAll();

}
