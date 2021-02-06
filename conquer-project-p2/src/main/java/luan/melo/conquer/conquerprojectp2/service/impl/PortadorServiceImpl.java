package luan.melo.conquer.conquerprojectp2.service.impl;

import luan.melo.conquer.conquerprojectp2.dao.PortadorDao;
import luan.melo.conquer.conquerprojectp2.domain.Portador;
import luan.melo.conquer.conquerprojectp2.service.PortadorService;
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
