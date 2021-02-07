package luan.melo.portal.transparencia.back.service;

import luan.melo.portal.transparencia.back.domain.TipoCartao;

import java.util.List;

public interface TipoCartaoService {

    void save(TipoCartao departamento);

    void update(TipoCartao departamento);

    void delete(Integer id);

    TipoCartao findById(Integer id);

    List<TipoCartao> findAll();

}
