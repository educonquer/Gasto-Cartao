package luan.melo.portal.transparencia.back.service;

import luan.melo.portal.transparencia.back.domain.Uf;

import java.util.List;

public interface UfService {

    void save(Uf uf);

    void update(Uf uf);

    void delete(String sigla);

    Uf findById(String sigla);

    List<Uf> findAll();

}
