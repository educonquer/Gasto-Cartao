package luan.melo.conquer.conquerprojectp2.service.impl;

import luan.melo.conquer.conquerprojectp2.dao.OrgaoMaximoDao;
import luan.melo.conquer.conquerprojectp2.domain.OrgaoMaximo;
import luan.melo.conquer.conquerprojectp2.service.OrgaoMaximoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class OrgaoMaximoServiceImpl implements OrgaoMaximoService {

    @Autowired
    OrgaoMaximoDao dao;

    @Override
    public void save(OrgaoMaximo orgaoMaximo) {
        if(findById(orgaoMaximo.getCodigo()) == null)
            dao.save(orgaoMaximo);
    }

    @Override
    public void update(OrgaoMaximo orgaoMaximo) {

    }

    @Override
    public void delete(String codigo) {

    }

    @Override
    public OrgaoMaximo findById(String codigo) {
        return dao.findById(codigo);
    }

    @Override
    public List<OrgaoMaximo> findAll() {
        return null;
    }
}
