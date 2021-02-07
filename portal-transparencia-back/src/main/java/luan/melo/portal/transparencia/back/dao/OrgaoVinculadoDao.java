package luan.melo.portal.transparencia.back.dao;

import luan.melo.portal.transparencia.back.domain.OrgaoVinculado;

import java.util.List;

public interface OrgaoVinculadoDao {

    void save(OrgaoVinculado departamento);

    void update(OrgaoVinculado departamento);

    void delete(String id);

    OrgaoVinculado findById(String id);

    List<OrgaoVinculado> findAll();

}
