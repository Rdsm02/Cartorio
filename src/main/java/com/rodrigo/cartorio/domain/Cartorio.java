package com.rodrigo.cartorio.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Cartorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private String nome;

    @Getter @Setter
    private String endereco;

    @Getter @Setter
    @ManyToMany
    @JoinTable(
            name = "cartorio_certidao",
            joinColumns = @JoinColumn(name = "cartorio"),
            inverseJoinColumns = @JoinColumn(name = "certidao"))
    private Set<Certidao> certidoes;

    @Getter @Setter
    @Transient
    private String certidoesString;

}
