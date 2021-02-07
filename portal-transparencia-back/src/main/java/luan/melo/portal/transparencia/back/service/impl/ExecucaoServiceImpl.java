package luan.melo.portal.transparencia.back.service.impl;

import luan.melo.portal.transparencia.back.dao.ExecucaoDao;
import luan.melo.portal.transparencia.back.domain.Execucao;
import luan.melo.portal.transparencia.back.service.ExecucaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional(readOnly = false)
public class ExecucaoServiceImpl implements ExecucaoService
{
    @Autowired
    ExecucaoDao dao;

    @Override
    public void save(Execucao execucao) {
        dao.save(execucao);
    }

    @Override
    public void update(Execucao execucao) {
        dao.update(execucao);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Execucao findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<Execucao> findAll() {
        return dao.findAll();
    }
}
