package luan.melo.portal.transparencia.back.dao;

import luan.melo.portal.transparencia.back.domain.Gasto;

import java.util.List;

public interface GastoDao {

    void save(Gasto gasto);

    void update(Gasto gasto);

    void delete(Integer id);

    Gasto findById(Integer id);

    List<Gasto> findAll();

    List<Gasto> findByMounth(String mes);
}
