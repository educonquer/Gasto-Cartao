package luan.melo.portal.transparencia.back.service;

import luan.melo.portal.transparencia.back.domain.UnidadeGestora;

import java.util.List;

public interface UnidadeGestoraService {

    void save(UnidadeGestora unidadeGestora);

    void update(UnidadeGestora unidadeGestora);

    void delete(String codigo);

    UnidadeGestora findById(String codigo);

    List<UnidadeGestora> findAll();

}
