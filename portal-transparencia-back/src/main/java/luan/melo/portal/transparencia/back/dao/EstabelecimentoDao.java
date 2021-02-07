package luan.melo.portal.transparencia.back.dao;

import luan.melo.portal.transparencia.back.domain.Estabelecimento;

import java.util.List;

public interface EstabelecimentoDao {

    void save(Estabelecimento estabelecimento);

    void update(Estabelecimento estabelecimento);

    void delete(String codigoFormatado);

    Estabelecimento findById(String codigoFormatado);

    List<Estabelecimento> findAll();
}
