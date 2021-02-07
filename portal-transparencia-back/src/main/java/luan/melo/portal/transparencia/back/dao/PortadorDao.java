package luan.melo.portal.transparencia.back.dao;

import luan.melo.portal.transparencia.back.domain.Portador;

import java.util.List;

public interface PortadorDao {

    void save(Portador portador);

    void update(Portador portador);

    void delete(String codigoFormatado);

    Portador findById(String codigoFormatado);

    List<Portador> findAll();

}
