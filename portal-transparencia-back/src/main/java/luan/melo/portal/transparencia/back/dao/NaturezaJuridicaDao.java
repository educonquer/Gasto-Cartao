package luan.melo.portal.transparencia.back.dao;

import luan.melo.portal.transparencia.back.domain.NaturezaJuridica;

import java.util.List;

public interface NaturezaJuridicaDao {

    void save(NaturezaJuridica naturezaJuridica);

    void update(NaturezaJuridica naturezaJuridica);

    void delete(String codigo);

    NaturezaJuridica findById(String codigo);

    List<NaturezaJuridica> findAll();

}
