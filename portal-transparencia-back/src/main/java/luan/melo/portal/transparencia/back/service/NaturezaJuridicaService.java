package luan.melo.portal.transparencia.back.service;

import luan.melo.portal.transparencia.back.domain.NaturezaJuridica;

import java.util.List;

public interface NaturezaJuridicaService {

    void save(NaturezaJuridica naturezaJuridica);

    void update(NaturezaJuridica naturezaJuridica);

    void delete(String codigo);

    NaturezaJuridica findById(String codigo);

    List<NaturezaJuridica> findAll();

}
