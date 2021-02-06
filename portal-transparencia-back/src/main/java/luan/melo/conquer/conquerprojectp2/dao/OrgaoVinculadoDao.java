package luan.melo.conquer.conquerprojectp2.dao;

import luan.melo.conquer.conquerprojectp2.domain.OrgaoVinculado;

import java.util.List;

public interface OrgaoVinculadoDao {

    void save(OrgaoVinculado departamento);

    void update(OrgaoVinculado departamento);

    void delete(String id);

    OrgaoVinculado findById(String id);

    List<OrgaoVinculado> findAll();

}
