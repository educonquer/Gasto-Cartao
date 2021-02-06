package luan.melo.conquer.conquerprojectp2.service;

import luan.melo.conquer.conquerprojectp2.domain.OrgaoVinculado;

import java.util.List;

public interface OrgaoVinculadoService {

    void save(OrgaoVinculado orgaoVinculado);

    void update(OrgaoVinculado orgaoVinculado);

    void delete(String cnpj);

    OrgaoVinculado findById(String cnpj);

    List<OrgaoVinculado> findAll();

}
