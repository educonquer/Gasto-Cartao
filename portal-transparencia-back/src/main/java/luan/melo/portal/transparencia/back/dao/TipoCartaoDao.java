package luan.melo.portal.transparencia.back.dao;

import luan.melo.portal.transparencia.back.domain.TipoCartao;

import java.util.List;

public interface TipoCartaoDao {

    void save(TipoCartao departamento);

    void update(TipoCartao departamento);

    void delete(Integer id);

    TipoCartao findById(Integer id);

    List<TipoCartao> findAll();

}
