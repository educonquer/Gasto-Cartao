package luan.melo.portal.transparencia.back.service;

import luan.melo.portal.transparencia.back.domain.OrgaoVinculado;

import java.util.List;

public interface OrgaoVinculadoService {

    void save(OrgaoVinculado orgaoVinculado);

    void update(OrgaoVinculado orgaoVinculado);

    void delete(String cnpj);

    OrgaoVinculado findById(String cnpj);

    List<OrgaoVinculado> findAll();

}
