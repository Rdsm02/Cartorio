package com.rodrigo.cartorio.service;

import com.rodrigo.cartorio.domain.Certidao;
import com.rodrigo.cartorio.repository.CertidaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertidaoServiceImpl implements CertidaoService {

    private final CertidaoRepository certidaoRepository;

    public CertidaoServiceImpl(CertidaoRepository certidaoRepository) {
        this.certidaoRepository = certidaoRepository;
    }

    @Override
    public List<Certidao> getCertidoes() {
        return this.certidaoRepository.findAll();
    }

    @Override
    public Optional<Certidao> getCertidaoPorId(Integer id) {
        return this.certidaoRepository.findById(id);
    }
}
