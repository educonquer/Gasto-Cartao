package luan.melo.portal.transparencia.back.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@ApiModel
@Data
@Entity
@Table(name = "GASTO")
public class Gasto implements Serializable {

    @Id
    @Column(name = "id", unique = true)
    public Integer id;

    @Column(name = "data_transacao")
    public String dataTransacao;

    @Column(name = "mes_extrato")
    public String mesExtrato;

    @Column(name = "valor_transacao")
    public String valorTransacao;

    @ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name = "estabelecimento_codigo_formatado_fk")
    public Estabelecimento estabelecimento;

    @ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name = "portador_codigo_formatado_fk")
    public Portador portador;

    @ManyToOne(cascade={CascadeType.REFRESH})
    @JoinColumn(name = "tipo_cartao_id_fk")
    public TipoCartao tipoCartao;

    @ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name = "estabelecimento_id_fk")
    public UnidadeGestora unidadeGestora;

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
