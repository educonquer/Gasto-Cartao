package luan.melo.conquer.conquerprojectp2.service;

import luan.melo.conquer.conquerprojectp2.domain.Municipio;

import java.util.List;

public interface MunicipioService {

    void save(Municipio municipio);

    void update(Municipio municipio);

    void delete(String codigoIBGE);

    Municipio findById(String codigoIBGE);

    List<Municipio> findAll();

}
