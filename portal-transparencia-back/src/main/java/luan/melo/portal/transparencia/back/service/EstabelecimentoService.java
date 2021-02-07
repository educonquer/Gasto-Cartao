package luan.melo.portal.transparencia.back.service;

import luan.melo.portal.transparencia.back.domain.Estabelecimento;

import java.util.List;

public interface EstabelecimentoService {

    void save(Estabelecimento estabelecimento);

    void update(Estabelecimento estabelecimento);

    void delete(String codigoFormatado);

    Estabelecimento findById(String codigoFormatado);

    List<Estabelecimento> findAll();

}
