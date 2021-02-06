package luan.melo.conquer.conquerprojectp2.service.impl;

import luan.melo.conquer.conquerprojectp2.dao.UnidadeGestoraDao;
import luan.melo.conquer.conquerprojectp2.domain.OrgaoVinculado;
import luan.melo.conquer.conquerprojectp2.domain.UnidadeGestora;
import luan.melo.conquer.conquerprojectp2.service.OrgaoVinculadoService;
import luan.melo.conquer.conquerprojectp2.service.UnidadeGestoraService;
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
