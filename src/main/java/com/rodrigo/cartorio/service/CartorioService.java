package com.rodrigo.cartorio.service;

import com.rodrigo.cartorio.domain.Cartorio;

import java.util.List;
import java.util.Optional;

public interface CartorioService {

    void criarCartorio(Cartorio cartorio);

    List<Cartorio> listarCartorios();

    Optional<Cartorio> getCartorio(Integer id);

    void excluirCartorio(Integer id);
}
