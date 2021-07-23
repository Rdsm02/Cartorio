package com.rodrigo.cartorio.service;

import com.rodrigo.cartorio.domain.Certidao;

import java.util.List;
import java.util.Optional;

public interface CertidaoService {
    List<Certidao> getCertidoes();

    Optional<Certidao> getCertidaoPorId(Integer id);
}
