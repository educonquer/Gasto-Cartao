package luan.melo.conquer.conquerprojectp2.service.impl;

import luan.melo.conquer.conquerprojectp2.dao.GastoDao;
import luan.melo.conquer.conquerprojectp2.domain.Gasto;
import luan.melo.conquer.conquerprojectp2.domain.TipoCartao;
import luan.melo.conquer.conquerprojectp2.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class GastoServiceImpl implements GastoService {

    @Autowired
    GastoDao dao;

    @Autowired
    EstabelecimentoService estabelecimentoService;

    @Autowired
    PortadorService portadorService;

    @Autowired
    TipoCartaoService tipoCartaoService;

    @Autowired
    UnidadeGestoraService unidadeGestoraService;

    @Override
    public void save(Gasto gasto) {
        if(this.findById(gasto.getId()) == null) {
            estabelecimentoService.save(gasto.getEstabelecimento());
            portadorService.save(gasto.getPortador());
            tipoCartaoService.save(gasto.getTipoCartao());
            unidadeGestoraService.save(gasto.getUnidadeGestora());

            dao.save(gasto);
        }
    }

    @Override
    public void update(Gasto gasto) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Gasto findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public List<Gasto> findAll() {
        return null;
    }

    @Override
    public List<Gasto> findByExtractMounth(String mes) {
//        return dao.createQuery("SELECT * FROM Gasto g WHERE g.mesExtrato = " + mes);
//        return dao.createQuery("from gasto gasto0_ left outer join estabelecimento estabeleci1_ on gasto0_.estabelecimento_codigo_formatado_fk=estabeleci1_.codigo_formatado left outer join cnae cnae2_ on estabeleci1_.cnae_codigo_classe_id_fk=cnae2_.codigo_classe left outer join municipio municipio3_ on estabeleci1_.municipio_codigo_ibge_fk=municipio3_.codigo_ibge left outer join natureza_juridica naturezaju4_ on estabeleci1_.natureza_juridica_codigo_fk=naturezaju4_.codigo left outer join portador portador5_ on gasto0_.portador_codigo_formatado_fk=portador5_.codigo_ormatado left outer join tipo_cartao tipocartao6_ on gasto0_.tipo_cartao_id_fk=tipocartao6_.id left outer join unidade_gestora unidadeges7_ on gasto0_.estabelecimento_id_fk=unidadeges7_.codigo left outer join orgao_vinculado orgaovincu8_ on unidadeges7_.orgao_vinculado_cnpj_fk=orgaovincu8_.cnpj where gasto0_.mes_extrato=" + mes);
        return dao.findByMounth(mes);
    }
}
