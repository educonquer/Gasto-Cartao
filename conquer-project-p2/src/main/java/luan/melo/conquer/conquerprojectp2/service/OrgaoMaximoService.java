package luan.melo.conquer.conquerprojectp2.service;

import luan.melo.conquer.conquerprojectp2.domain.OrgaoMaximo;

import java.util.List;

public interface OrgaoMaximoService {

    void save(OrgaoMaximo orgaoMaximo);

    void update(OrgaoMaximo orgaoMaximo);

    void delete(String codigo);

    OrgaoMaximo findById(String codigo);

    List<OrgaoMaximo> findAll();

}
