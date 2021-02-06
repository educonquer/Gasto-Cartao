package luan.melo.conquer.conquerprojectp2.dao;

import luan.melo.conquer.conquerprojectp2.domain.Uf;

import java.util.List;

public interface UfDao {

    void save(Uf uf);

    void update(Uf uf);

    void delete(String sigla);

    Uf findById(String sigla);

    List<Uf> findAll();

}
