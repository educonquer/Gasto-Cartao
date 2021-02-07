package luan.melo.portal.transparencia.back.dao;

import luan.melo.portal.transparencia.back.domain.Cnae;

import java.util.List;

public interface CnaeDao {

    void save(Cnae cnae);

    void update(Cnae cnae);

    void delete(String codigoClasse);

    Cnae findById(String codigoClasse);

    List<Cnae> findAll();

}
