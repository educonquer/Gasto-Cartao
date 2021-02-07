package luan.melo.portal.transparencia.back.service;

import luan.melo.portal.transparencia.back.domain.Portador;

import java.util.List;

public interface PortadorService {

    void save(Portador portador);

    void update(Portador portador);

    void delete(String codigoFormatado);

    Portador findById(String codigoFormatado);

    List<Portador> findAll();

}
