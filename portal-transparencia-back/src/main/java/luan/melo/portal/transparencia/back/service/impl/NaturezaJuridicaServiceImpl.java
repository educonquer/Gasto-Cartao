package luan.melo.portal.transparencia.back.service.impl;

import luan.melo.portal.transparencia.back.dao.NaturezaJuridicaDao;
import luan.melo.portal.transparencia.back.domain.NaturezaJuridica;
import luan.melo.portal.transparencia.back.service.NaturezaJuridicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class NaturezaJuridicaServiceImpl implements NaturezaJuridicaService {

    @Autowired
    NaturezaJuridicaDao dao;

    @Override
    public void save(NaturezaJuridica naturezaJuridica) {
        if(findById(naturezaJuridica.getCodigo()) == null)
            dao.save(naturezaJuridica);
    }

    @Override
    public void update(NaturezaJuridica naturezaJuridica) {

    }

    @Override
    public void delete(String codigo) {

    }

    @Override
    public NaturezaJuridica findById(String codigo) {
        return dao.findById(codigo);
    }

    @Override
    public List<NaturezaJuridica> findAll() {
        return null;
    }
}
