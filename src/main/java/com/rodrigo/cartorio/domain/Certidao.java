package com.rodrigo.cartorio.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Certidao {

    @Id
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private String nome;

    @Getter @Setter
    @JsonIgnore
    @ManyToMany(mappedBy = "certidoes")
    Set<Cartorio> cartorios;
}
