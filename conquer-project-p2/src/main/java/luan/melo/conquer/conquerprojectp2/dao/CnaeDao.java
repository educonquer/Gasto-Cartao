package luan.melo.conquer.conquerprojectp2.dao;

import luan.melo.conquer.conquerprojectp2.domain.Cnae;

import java.util.List;

public interface CnaeDao {

    void save(Cnae cnae);

    void update(Cnae cnae);

    void delete(String codigoClasse);

    Cnae findById(String codigoClasse);

    List<Cnae> findAll();

}
