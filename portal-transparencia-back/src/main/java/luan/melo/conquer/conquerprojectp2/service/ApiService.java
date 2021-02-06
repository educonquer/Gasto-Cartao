package luan.melo.conquer.conquerprojectp2.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import luan.melo.conquer.conquerprojectp2.domain.Execucao;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface ApiService {

    void execute(Execucao execucao) throws Exception;

    List<Execucao> obterResultados();

    Execucao buscarPorId(Long id);
}
