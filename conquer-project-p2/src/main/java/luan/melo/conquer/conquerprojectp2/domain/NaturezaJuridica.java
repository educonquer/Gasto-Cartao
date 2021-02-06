package luan.melo.conquer.conquerprojectp2.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@ApiModel
@Data
@Entity
@Table(name = "NATUREZA_JURIDICA")
public class NaturezaJuridica implements Serializable {

    @Id
    @Column(name = "codigo")
    public String codigo;

    @Column(name = "codigo_tipo")
    public String codigoTipo;

    @Column(name = "descricao")
    public String descricao;

    @Column(name = "descricao_tipo")
    public String descricaoTipo;

    @OneToMany(mappedBy = "naturezaJuridica")
    List<Estabelecimento> estabelecimentos;

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NaturezaJuridica that = (NaturezaJuridica) o;
        return Objects.equals(codigo, that.codigo);
    }

    @Override
    public String toString(){
        return "codigo = " + codigo;
    }
}
