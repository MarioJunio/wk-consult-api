package br.com.wk.core.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "person")
public class PersonEntity implements Serializable {

    private String nome;

    private String cpf;

    @Id
    private String rg;

    @Column(name = "data_nasc", columnDefinition = "DATE")
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    private PersonGeneroEnum sexo;

    private String mae;

    private String pai;

    private String email;

    private String cep;

    private String endereco;

    private int numero;

    private String bairro;

    private String cidade;

    private String estado;

    @Column(name = "telefone_fixo")
    private String telefoneFixo;

    private String celular;

    private float altura;

    private int peso;

    @Column(name = "tipo_sanguineo")
    private String tipoSanguinio;
}
