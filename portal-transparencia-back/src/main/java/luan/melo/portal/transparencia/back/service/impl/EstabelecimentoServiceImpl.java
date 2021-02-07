package luan.melo.portal.transparencia.back.service.impl;

import luan.melo.portal.transparencia.back.dao.EstabelecimentoDao;
import luan.melo.portal.transparencia.back.domain.Estabelecimento;
import luan.melo.portal.transparencia.back.service.CnaeService;
import luan.melo.portal.transparencia.back.service.EstabelecimentoService;
import luan.melo.portal.transparencia.back.service.MunicipioService;
import luan.melo.portal.transparencia.back.service.NaturezaJuridicaService;
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
