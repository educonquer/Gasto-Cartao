package luan.melo.conquer.conquerprojectp2.dao;

import luan.melo.conquer.conquerprojectp2.domain.Gasto;

import java.util.List;

public interface GastoDao {

    void save(Gasto gasto);

    void update(Gasto gasto);

    void delete(Integer id);

    Gasto findById(Integer id);

    List<Gasto> findAll();

    List<Gasto> findByMounth(String mes);
}
