package luan.melo.portal.transparencia.back.service;

import luan.melo.portal.transparencia.back.domain.Gasto;

import java.util.List;

public interface GastoService {

    void save(Gasto departamento);

    void update(Gasto departamento);

    void delete(Integer id);

    Gasto findById(Integer id);

    List<Gasto> findAll();

    public List<Gasto> findByExtractMounth(String mes);
}
