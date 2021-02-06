package luan.melo.conquer.conquerprojectp2.service;

import luan.melo.conquer.conquerprojectp2.domain.NaturezaJuridica;

import java.util.List;

public interface NaturezaJuridicaService {

    void save(NaturezaJuridica naturezaJuridica);

    void update(NaturezaJuridica naturezaJuridica);

    void delete(String codigo);

    NaturezaJuridica findById(String codigo);

    List<NaturezaJuridica> findAll();

}
