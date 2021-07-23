package com.rodrigo.cartorio.init;

import com.rodrigo.cartorio.api.CertidaoAPI;
import com.rodrigo.cartorio.repository.CertidaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {

    private Logger LOGGER = LoggerFactory.getLogger(Init.class);

    @Autowired
    private CertidaoAPI certidaoAPI;

    @Autowired
    private CertidaoRepository certidaoRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        LOGGER.info("Iniciação das principais chamadas da aplicação");

        try {
            certidaoRepository.saveAll(certidaoAPI.getCertidoes());
        } catch (Exception e) {
            LOGGER.error("Erro ao iniciar chamadas da aplicação. ", e);
        }

    }
}
