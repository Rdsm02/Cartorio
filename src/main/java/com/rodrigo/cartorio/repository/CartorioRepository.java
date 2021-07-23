package com.rodrigo.cartorio.repository;

import com.rodrigo.cartorio.domain.Cartorio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartorioRepository extends JpaRepository<Cartorio, Integer> {
}
