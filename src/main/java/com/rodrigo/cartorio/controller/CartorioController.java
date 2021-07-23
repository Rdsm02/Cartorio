package com.rodrigo.cartorio.controller;

import com.rodrigo.cartorio.domain.Cartorio;
import com.rodrigo.cartorio.domain.Certidao;
import com.rodrigo.cartorio.service.CartorioService;
import com.rodrigo.cartorio.service.CertidaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.HashSet;

@Controller
@RequestMapping("cartorio")
public class CartorioController {

    private Logger LOGGER = LoggerFactory.getLogger(CartorioController.class);

    @Autowired
    private CartorioService cartorioService;

    @Autowired
    private CertidaoService certidaoService;

    @GetMapping("/listarCartorios")
    public ModelAndView listarCartorios() {
        ModelAndView mv = new ModelAndView("paginas/listagem-cartorios");
        mv.addObject("cartorios", this.cartorioService.listarCartorios());
        return mv;
    }

    @GetMapping("/editarCartorio/{id}")
    public ModelAndView editarCartorio(@PathVariable("id") Integer id) {
        ModelAndView mv = new ModelAndView("paginas/editar-cartorio");
        mv.addObject("cartorio", this.cartorioService.getCartorio(id).get());
        mv.addObject("certidoes", this.certidaoService.getCertidoes());
        return mv;
    }

    @GetMapping("/excluirCartorio/{id}")
    public String excluirCartorio(@PathVariable("id") Integer id) {
        this.cartorioService.excluirCartorio(id);
        return "redirect:/cartorio/listarCartorios";
    }

    @GetMapping("/cadastrarCartorio")
    public ModelAndView cadastrarCartorio() {
        ModelAndView mv = new ModelAndView("paginas/cadastro-cartorios");
        mv.addObject("cartorio", new Cartorio());
        mv.addObject("certidoes", this.certidaoService.getCertidoes());
        return mv;
    }

    @PostMapping("/salvarCartorio")
    public String salvarClientes(Cartorio cartorio) {
        if (cartorio.getNome() != null && !cartorio.getNome().isEmpty()) {
            setCertidoes(cartorio);
            this.cartorioService.criarCartorio(cartorio);
        }
        return "redirect:/cartorio/listarCartorios";
    }

    private Cartorio setCertidoes(Cartorio cartorio) {
        var ids = cartorio.getCertidoesString();
        if (ids == null) {
            return cartorio;
        }

        var idsSet = new HashSet<Certidao>();

        Arrays.stream(ids.split(","))
                .map(Integer::valueOf)
                .forEach(s -> idsSet.add(this.certidaoService.getCertidaoPorId(s).get()));

        cartorio.setCertidoes(idsSet);
        return cartorio;
    }
}
