package luan.melo.portal.transparencia.front.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Execucao {

    private Long id;

    private String idExecucao;

    private String dataPesquisa;

    private String localArquivo;

    private String nomeArquivo;

    private String mesExtratoInicio;

    private String mesExtratoFim;

    private String status;
}
