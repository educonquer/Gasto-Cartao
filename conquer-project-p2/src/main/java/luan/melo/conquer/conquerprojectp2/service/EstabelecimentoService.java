package luan.melo.conquer.conquerprojectp2.service;

import luan.melo.conquer.conquerprojectp2.domain.Estabelecimento;

import java.util.List;

public interface EstabelecimentoService {

    void save(Estabelecimento estabelecimento);

    void update(Estabelecimento estabelecimento);

    void delete(String codigoFormatado);

    Estabelecimento findById(String codigoFormatado);

    List<Estabelecimento> findAll();

}
