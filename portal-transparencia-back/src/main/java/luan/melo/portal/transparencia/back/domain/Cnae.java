package luan.melo.portal.transparencia.back.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@ApiModel
@Data
@Entity
@Table(name = "CNAE")
public class Cnae implements Serializable {

    @Id
    @Column(name = "codigo_classe")
    public String codigoClasse;

    @Column(name = "classe")
    public String classe;

    @Column(name = "codigo_divisao")
    public String codigoDivisao;

    @Column(name = "codigo_grupo")
    public String codigoGrupo;

    @Column(name = "codigo_secao")
    public String codigoSecao;

    @Column(name = "codigo_subclasse")
    public String codigoSubclasse;

    @Column(name = "divisao")
    public String divisao;

    @Column(name = "grupo")
    public String grupo;

    @Column(name = "secao")
    public String secao;

    @Column(name = "subclasse")
    public String subclasse;

//    @OneToMany(mappedBy = "cnae")
//    List<Estabelecimento> estabelecimentos;

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigoClasse == null) ? 0 : codigoClasse.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cnae that = (Cnae) o;
        return Objects.equals(codigoClasse, that.codigoClasse);
    }

    @Override
    public String toString(){
        return "[codigoClasse = " + codigoClasse +
                ", classe = " + classe +
                ", codigoDivisao = " + codigoDivisao +
                ", codigoGrupo = " + codigoGrupo +
                ", codigoSecao = " + codigoSecao +
                ", codigoSubclasse = " + codigoSubclasse +
                ", divisao = " + divisao +
                ", grupo = " + grupo +
                ", secao = " + secao +
                ", subclasse = " + subclasse + "]";
    }
}
