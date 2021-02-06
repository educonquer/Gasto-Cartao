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
@Table(name = "PORTADOR")
public class Portador implements Serializable {

    @Id
    @Column(name = "codigo_ormatado")
    public String codigoFormatado;

    @Column(name = "nome")
    public String nome;

//    @OneToMany(mappedBy = "portador")
//    private List<Gasto> gastos;

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigoFormatado == null) ? 0 : codigoFormatado.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Portador that = (Portador) o;
        return Objects.equals(codigoFormatado, that.codigoFormatado);
    }

    @Override
    public String toString(){
        return "codigoFormatado = " + codigoFormatado;
    }
}
