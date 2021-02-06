package luan.melo.conquer.conquerprojectp2.dao;

import luan.melo.conquer.conquerprojectp2.domain.OrgaoMaximo;

import java.util.List;

public interface OrgaoMaximoDao {

    void save(OrgaoMaximo orgaoMaximo);

    void update(OrgaoMaximo orgaoMaximo);

    void delete(String codigo);

    OrgaoMaximo findById(String codigo);

    List<OrgaoMaximo> findAll();

}
