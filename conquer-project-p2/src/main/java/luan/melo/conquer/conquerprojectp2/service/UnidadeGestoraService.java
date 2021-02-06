package luan.melo.conquer.conquerprojectp2.service;

import luan.melo.conquer.conquerprojectp2.domain.UnidadeGestora;

import java.util.List;

public interface UnidadeGestoraService {

    void save(UnidadeGestora unidadeGestora);

    void update(UnidadeGestora unidadeGestora);

    void delete(String codigo);

    UnidadeGestora findById(String codigo);

    List<UnidadeGestora> findAll();

}
