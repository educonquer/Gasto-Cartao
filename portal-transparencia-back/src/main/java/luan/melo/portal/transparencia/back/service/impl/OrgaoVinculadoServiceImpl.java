package luan.melo.portal.transparencia.back.service.impl;

import luan.melo.portal.transparencia.back.dao.OrgaoVinculadoDao;
import luan.melo.portal.transparencia.back.domain.OrgaoVinculado;
import luan.melo.portal.transparencia.back.service.OrgaoMaximoService;
import luan.melo.portal.transparencia.back.service.OrgaoVinculadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class OrgaoVinculadoServiceImpl implements OrgaoVinculadoService {

    @Autowired
    OrgaoVinculadoDao dao;

    @Autowired
    OrgaoMaximoService orgaoMaximoService;

    @Override
    public void save(OrgaoVinculado orgaoVinculado) {
        if(findById(orgaoVinculado.getCnpj()) == null)
        {
            orgaoMaximoService.save(orgaoVinculado.getOrgaoMaximo());
            dao.save(orgaoVinculado);
        }
    }

    @Override
    public void update(OrgaoVinculado orgaoVinculado) {

    }

    @Override
    public void delete(String cnpj) {

    }

    @Override
    public OrgaoVinculado findById(String cnpj) {
        return dao.findById(cnpj);
    }

    @Override
    public List<OrgaoVinculado> findAll() {
        return null;
    }
}
