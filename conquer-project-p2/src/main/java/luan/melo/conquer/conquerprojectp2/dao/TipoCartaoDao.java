package luan.melo.conquer.conquerprojectp2.dao;

import luan.melo.conquer.conquerprojectp2.domain.TipoCartao;

import java.util.List;

public interface TipoCartaoDao {

    void save(TipoCartao departamento);

    void update(TipoCartao departamento);

    void delete(Integer id);

    TipoCartao findById(Integer id);

    List<TipoCartao> findAll();

}
