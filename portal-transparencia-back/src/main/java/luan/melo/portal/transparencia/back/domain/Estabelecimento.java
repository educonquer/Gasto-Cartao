package luan.melo.portal.transparencia.back.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@ApiModel
@Data
@Entity
@Table(name = "ESTABELECIMENTO")
public class Estabelecimento implements Serializable {

    @Id
    @Column(name = "codigo_formatado", unique = true)
    public String codigoFormatado;

    @Column(name = "complemento_endereco")
    public String complementoEndereco;

    @Column(name = "data_abertura")
    public String dataAbertura;

    @Column(name = "descricao_logradouro")
    public String descricaoLogradouro;

    @Column(name = "endereco_eletronico")
    public String enderecoEletronico;

    @Column(name = "localidade_pessoa")
    public String localidadePessoa;

    @Column(name = "nome")
    public String nome;

    @Column(name = "nome_bairro")
    public String nomeBairro;

    @Column(name = "nome_fantasia_receita")
    public String nomeFantasiaReceita;

    @Column(name = "numero_cep")
    public String numeroCEP;

    @Column(name = "numero_endereco")
    public String numeroEndereco;

    @Column(name = "numero_inscricao_social")
    public String numeroInscricaoSocial;

    @Column(name = "numero_telefone")
    public String numeroTelefone;

    @Column(name = "razao_social_receita")
    public String razaoSocialReceita;

    @Column(name = "tipo_codigo")
    public String tipoCodigo;

    @Column(name = "tipo_pessoa")
    public String tipoPessoa;

    @ManyToOne()
    @JoinColumn(name = "cnae_codigo_classe_id_fk")
    public Cnae cnae;

    @ManyToOne()
    @JoinColumn(name = "municipio_codigo_ibge_fk")
    public Municipio municipio;

    @ManyToOne()
    @JoinColumn(name = "natureza_juridica_codigo_fk")
    public NaturezaJuridica naturezaJuridica;

//    @OneToMany(mappedBy = "estabelecimento")
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
        Estabelecimento that = (Estabelecimento) o;
        return Objects.equals(codigoFormatado, that.codigoFormatado);
    }

    @Override
    public String toString(){
        return "codigoFormatado = " + codigoFormatado;
    }
}
