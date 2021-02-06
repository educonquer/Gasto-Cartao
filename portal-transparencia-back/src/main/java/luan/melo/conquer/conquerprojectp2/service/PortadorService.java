package luan.melo.conquer.conquerprojectp2.service;

import luan.melo.conquer.conquerprojectp2.domain.Portador;

import java.util.List;

public interface PortadorService {

    void save(Portador portador);

    void update(Portador portador);

    void delete(String codigoFormatado);

    Portador findById(String codigoFormatado);

    List<Portador> findAll();

}
