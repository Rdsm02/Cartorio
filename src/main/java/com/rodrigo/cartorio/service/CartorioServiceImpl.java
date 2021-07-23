package com.rodrigo.cartorio.service;

import com.rodrigo.cartorio.domain.Cartorio;
import com.rodrigo.cartorio.repository.CartorioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartorioServiceImpl implements CartorioService {

    private final CartorioRepository cartorioRepository;

    public CartorioServiceImpl(CartorioRepository cartorioRepository) {
        this.cartorioRepository = cartorioRepository;
    }

    @Override
    public void criarCartorio(Cartorio cartorio) {
        this.cartorioRepository.save(cartorio);
    }

    @Override
    public List<Cartorio> listarCartorios() {
        return this.cartorioRepository.findAll();
    }

    @Override
    public Optional<Cartorio> getCartorio(Integer id) {
        return this.cartorioRepository.findById(id);
    }

    @Override
    public void excluirCartorio(Integer id) {
        var cartorio = this.cartorioRepository.findById(id);
        this.cartorioRepository.delete(cartorio.get());
    }
}
