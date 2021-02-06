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
@Table(name = "MUNICIPIO")
public class Municipio implements Serializable {

    @Id
    @Column(name = "codigo_ibge")
    public String codigoIBGE;

    @Column(name = "nome_ibge")
    public String nomeIBGE;

    @Column(name = "pais")
    public String pais;

    @ManyToOne()
    @JoinColumn(name = "uf_sigla_fk")
    public Uf uf;

//    @OneToMany(mappedBy = "municipio")
//    List<Estabelecimento> estabelecimentos;

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigoIBGE == null) ? 0 : codigoIBGE.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Municipio that = (Municipio) o;
        return Objects.equals(codigoIBGE, that.codigoIBGE);
    }

    @Override
    public String toString(){
        return "codigoIBGE = " + codigoIBGE;
    }
}
