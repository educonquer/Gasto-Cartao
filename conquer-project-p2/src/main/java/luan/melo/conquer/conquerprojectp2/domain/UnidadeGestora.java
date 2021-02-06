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
@Table(name = "UNIDADE_GESTORA")
public class UnidadeGestora implements Serializable {

    @Id
    @Column(name = "codigo", unique = true)
    public String codigo;

    @Column(name = "nome")
    public String nome;

    @ManyToOne()
    @JoinColumn(name = "orgao_vinculado_cnpj_fk")
    public OrgaoVinculado orgaoVinculado;

    @OneToMany(mappedBy = "unidadeGestora")
    private List<Gasto> gastos;

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
        UnidadeGestora that = (UnidadeGestora) o;
        return Objects.equals(codigo, that.codigo);
    }

    @Override
    public String toString(){
        return "codigo = " + codigo;
    }
}
