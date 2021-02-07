package luan.melo.portal.transparencia.back.dao;

import luan.melo.portal.transparencia.back.domain.Uf;

import java.util.List;

public interface UfDao {

    void save(Uf uf);

    void update(Uf uf);

    void delete(String sigla);

    Uf findById(String sigla);

    List<Uf> findAll();

}
