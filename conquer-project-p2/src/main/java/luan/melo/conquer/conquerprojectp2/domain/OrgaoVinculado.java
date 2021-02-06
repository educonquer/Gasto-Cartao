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
@Table(name = "ORGAO_VINCULADO")
public class OrgaoVinculado implements Serializable {

    @Id
    @Column(name = "cnpj", unique = true)
    public String cnpj;

    @Column(name = "codigo_siafi")
    public String codigoSIAFI;

    @Column(name = "descricao_poder")
    public String descricaoPoder;

    @Column(name = "nome")
    public String nome;

    @Column(name = "sigla")
    public String sigla;

    @ManyToOne()
    @JoinColumn(name = "orgao_maximo_codigo_fk")
    public OrgaoMaximo orgaoMaximo;

    @OneToMany(mappedBy = "orgaoVinculado")
    private List<UnidadeGestora> unidadesGestoras;

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrgaoVinculado that = (OrgaoVinculado) o;
        return Objects.equals(cnpj, that.cnpj);
    }

    @Override
    public String toString(){
        return "cnpj = " + cnpj;
    }
}
