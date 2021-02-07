package luan.melo.portal.transparencia.back.service.impl;

import luan.melo.portal.transparencia.back.dao.UnidadeGestoraDao;
import luan.melo.portal.transparencia.back.domain.UnidadeGestora;
import luan.melo.portal.transparencia.back.service.OrgaoVinculadoService;
import luan.melo.portal.transparencia.back.service.UnidadeGestoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class UnidadeGestoraServiceImpl implements UnidadeGestoraService {

    @Autowired
    UnidadeGestoraDao dao;

    @Autowired
    OrgaoVinculadoService orgaoVinculadoService;

    @Override
    public void save(UnidadeGestora unidadeGestora) {
        if(findById(unidadeGestora.getCodigo()) == null) {
            orgaoVinculadoService.save(unidadeGestora.getOrgaoVinculado());
            dao.save(unidadeGestora);
        }
    }

    @Override
    public void update(UnidadeGestora unidadeGestora) {

    }

    @Override
    public void delete(String codigo) {

    }

    @Override
    @Transactional(readOnly = true)
    public UnidadeGestora findById(String codigo) {
        return dao.findById(codigo);
    }

    @Override
    public List<UnidadeGestora> findAll() {
        return null;
    }
}
