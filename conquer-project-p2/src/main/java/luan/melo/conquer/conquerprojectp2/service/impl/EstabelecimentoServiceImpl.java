package luan.melo.conquer.conquerprojectp2.service.impl;

import luan.melo.conquer.conquerprojectp2.dao.EstabelecimentoDao;
import luan.melo.conquer.conquerprojectp2.domain.Estabelecimento;
import luan.melo.conquer.conquerprojectp2.service.CnaeService;
import luan.melo.conquer.conquerprojectp2.service.EstabelecimentoService;
import luan.melo.conquer.conquerprojectp2.service.MunicipioService;
import luan.melo.conquer.conquerprojectp2.service.NaturezaJuridicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class EstabelecimentoServiceImpl implements EstabelecimentoService {

    @Autowired
    EstabelecimentoDao dao;

    @Autowired
    CnaeService cnaeService;

    @Autowired
    MunicipioService municipioService;

    @Autowired
    NaturezaJuridicaService naturezaJuridicaService;

    @Override
    public void save(Estabelecimento estabelecimento) {
        if(findById(estabelecimento.getCodigoFormatado()) == null) {
            cnaeService.save(estabelecimento.getCnae());
            municipioService.save(estabelecimento.getMunicipio());
            naturezaJuridicaService.save(estabelecimento.getNaturezaJuridica());

            dao.save(estabelecimento);
        }
    }

    @Override
    public void update(Estabelecimento estabelecimento) {

    }

    @Override
    public void delete(String codigoFormatado) {

    }

    @Override
    public Estabelecimento findById(String codigoFormatado) {
        return dao.findById(codigoFormatado);
    }

    @Override
    public List<Estabelecimento> findAll() {
        return null;
    }
}
