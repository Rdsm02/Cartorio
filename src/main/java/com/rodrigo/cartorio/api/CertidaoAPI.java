package com.rodrigo.cartorio.api;

import com.rodrigo.cartorio.domain.Certidao;
import com.rodrigo.cartorio.exceptions.CertidaoAPIException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CertidaoAPI {

    private Logger LOGGER = LoggerFactory.getLogger(CertidaoAPI.class);

    private final RestTemplate restTemplate;
    private final String url;

    public CertidaoAPI(@Value("${cartorio.api.certidoes.url}") String url) {
        this.restTemplate = new RestTemplate();
        this.url = url;
    }

    public List<Certidao> getCertidoes() throws CertidaoAPIException {

        try {
            var headers = new HttpHeaders();
            headers.set("Content-Type", "application/json");

            var httpEntity = new HttpEntity<>(null, headers);

            var stoksList = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
                    new ParameterizedTypeReference<List<Certidao>>(){});
            var body = stoksList.getBody();

            return body;

        } catch (Exception e) {
            LOGGER.error("Erro ao obter lista de certidões da api.");
            throw new CertidaoAPIException(e);
        }

    }

}