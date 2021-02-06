package luan.melo.conquer.conquerprojectp2.service.impl;

import luan.melo.conquer.conquerprojectp2.dao.NaturezaJuridicaDao;
import luan.melo.conquer.conquerprojectp2.domain.NaturezaJuridica;
import luan.melo.conquer.conquerprojectp2.service.NaturezaJuridicaService;
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
