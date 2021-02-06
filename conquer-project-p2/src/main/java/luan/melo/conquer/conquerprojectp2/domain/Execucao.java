package luan.melo.conquer.conquerprojectp2.domain;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@ApiModel
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EXECUCAO")
public class Execucao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_execucao")
    private String idExecucao;

    @Column(name = "data_pesquisa")
    private String dataPesquisa;

    @Column(name = "local_arquivo")
    private String localArquivo;

    @Column(name = "nome_arquivo")
    private String nomeArquivo;

    @Column(name = "mes_extrato_inicio")
    private String mesExtratoInicio;

    @Column(name = "mes_extrato_final")
    private String mesExtratoFinal;

    @Column(name = "status")
    private String status;

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gasto that = (Gasto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public String toString(){
        return "id = " + id;
    }
}
