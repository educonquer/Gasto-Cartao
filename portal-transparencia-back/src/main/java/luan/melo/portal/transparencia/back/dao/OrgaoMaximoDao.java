package luan.melo.portal.transparencia.back.dao;

import luan.melo.portal.transparencia.back.domain.OrgaoMaximo;

import java.util.List;

public interface OrgaoMaximoDao {

    void save(OrgaoMaximo orgaoMaximo);

    void update(OrgaoMaximo orgaoMaximo);

    void delete(String codigo);

    OrgaoMaximo findById(String codigo);

    List<OrgaoMaximo> findAll();

}
