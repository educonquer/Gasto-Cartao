package luan.melo.portal.transparencia.back.service.impl;

import luan.melo.portal.transparencia.back.dao.PortadorDao;
import luan.melo.portal.transparencia.back.domain.Portador;
import luan.melo.portal.transparencia.back.service.PortadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class PortadorServiceImpl implements PortadorService {

    @Autowired
    PortadorDao dao;

    @Override
    public void save(Portador portador) {
        if(findById(portador.getCodigoFormatado()) == null)
            dao.save(portador);
    }

    @Override
    public void update(Portador portador) {

    }

    @Override
    public void delete(String codigoFormatado) {

    }

    @Override
    public Portador findById(String codigoFormatado) {
        return dao.findById(codigoFormatado);
    }

    @Override
    public List<Portador> findAll() {
        return null;
    }
}
