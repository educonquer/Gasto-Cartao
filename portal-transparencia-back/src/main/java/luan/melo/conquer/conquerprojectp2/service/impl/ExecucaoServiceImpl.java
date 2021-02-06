package luan.melo.conquer.conquerprojectp2.service.impl;

import luan.melo.conquer.conquerprojectp2.api.retrofit.GastoCartaoApi;
import luan.melo.conquer.conquerprojectp2.dao.CnaeDao;
import luan.melo.conquer.conquerprojectp2.dao.ExecucaoDao;
import luan.melo.conquer.conquerprojectp2.domain.Cnae;
import luan.melo.conquer.conquerprojectp2.domain.Estabelecimento;
import luan.melo.conquer.conquerprojectp2.domain.Execucao;
import luan.melo.conquer.conquerprojectp2.domain.Gasto;
import luan.melo.conquer.conquerprojectp2.service.ExecucaoService;
import luan.melo.conquer.conquerprojectp2.service.GastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
