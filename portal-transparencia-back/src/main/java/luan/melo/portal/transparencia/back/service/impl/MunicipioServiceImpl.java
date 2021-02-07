package luan.melo.portal.transparencia.back.service.impl;

import luan.melo.portal.transparencia.back.dao.MunicipioDao;
import luan.melo.portal.transparencia.back.domain.Municipio;
import luan.melo.portal.transparencia.back.service.MunicipioService;
import luan.melo.portal.transparencia.back.service.UfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class MunicipioServiceImpl implements MunicipioService {

    @Autowired
    MunicipioDao dao;

    @Autowired
    UfService ufService;

    @Override
    public void save(Municipio municipio) {
        if(findById(municipio.getCodigoIBGE()) == null)
        {
            ufService.save(municipio.getUf());
            dao.save(municipio);
        }
    }

    @Override
    public void update(Municipio municipio) {

    }

    @Override
    public void delete(String codigoIBGE) {

    }

    @Override
    @Transactional(readOnly = true)
    public Municipio findById(String codigoIBGE) {
        return dao.findById(codigoIBGE);
    }

    @Override
    public List<Municipio> findAll() {
        return null;
    }
}
