package luan.melo.portal.transparencia.back.service.impl;

import luan.melo.portal.transparencia.back.dao.TipoCartaoDao;
import luan.melo.portal.transparencia.back.domain.TipoCartao;
import luan.melo.portal.transparencia.back.service.TipoCartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class TipoCartaoServiceImpl implements TipoCartaoService {

    @Autowired
    TipoCartaoDao dao;

    @Override
    public void save(TipoCartao tipoCartao) {
        if(findById(tipoCartao.getId()) == null)
            dao.save(tipoCartao);
    }

    @Override
    public void update(TipoCartao tipoCartao) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    @Transactional(readOnly = true)
    public TipoCartao findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public List<TipoCartao> findAll() {
        return null;
    }
}
