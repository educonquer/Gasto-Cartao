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
@Table(name = "TIPO_CARTAO")
public class TipoCartao implements Serializable {

    @Id
    @Column(name = "id")
    public Integer id;

    @Column(name = "codigo")
    public String codigo;

    @Column(name = "descricao")
    public String descricao;

//    @OneToMany(mappedBy = "tipoCartao")
//    private List<Gasto> gastos;

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
        TipoCartao that = (TipoCartao) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public String toString(){
        return "id = " + id;
    }
}
