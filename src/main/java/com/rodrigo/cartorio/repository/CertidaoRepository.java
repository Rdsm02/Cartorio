package com.rodrigo.cartorio.repository;

import com.rodrigo.cartorio.domain.Certidao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertidaoRepository extends JpaRepository<Certidao, Integer> {
}
