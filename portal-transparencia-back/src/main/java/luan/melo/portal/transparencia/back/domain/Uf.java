package luan.melo.portal.transparencia.back.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@ApiModel
@Data
@Entity
@Table(name = "UF")
public class Uf implements Serializable {

    @Id
    @Column(name = "sigla", unique = true)
    public String sigla;

    @Column(name = "nome", unique = true)
    public String nome;

//    @OneToMany(mappedBy = "uf")
//    List<Municipio> municipios;

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Uf that = (Uf) o;
        return Objects.equals(sigla, that.sigla);
    }

    @Override
    public String toString(){
        return "sigla = " + sigla;
    }
}
