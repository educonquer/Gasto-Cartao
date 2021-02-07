package luan.melo.portal.transparencia.back.dao;

import luan.melo.portal.transparencia.back.domain.Municipio;

import java.util.List;

public interface MunicipioDao {

    void save(Municipio municipio);

    void update(Municipio municipio);

    void delete(String codigoIBGE);

    Municipio findById(String codigoIBGE);

    List<Municipio> findAll();

}
