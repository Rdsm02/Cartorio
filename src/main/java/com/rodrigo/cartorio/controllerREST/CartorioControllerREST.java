package com.rodrigo.cartorio.controllerREST;

import com.rodrigo.cartorio.domain.Cartorio;
import com.rodrigo.cartorio.service.CartorioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/v1")
@Api(value = "Versão 1 da api de cartório")
public class CartorioControllerREST {

    @Autowired
    private CartorioService cartorioService;

    @ApiOperation(value = "Retorna uma lista de cartórios")
    @RequestMapping(value = "/cartorio", method = RequestMethod.GET)
    public ResponseEntity<List<Cartorio>> listarCartorios() {

        try {
            var cartorios = this.cartorioService.listarCartorios();
            return ResponseEntity.ok(cartorios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @ApiOperation(value = "Salva um cartório e retorna uma lista de cartórios")
    @RequestMapping(value = "/cartorio", method = RequestMethod.POST)
    public ResponseEntity<List<Cartorio>> criarCartorio(@RequestBody Cartorio cartorio) {

        if (cartorio.getNome() == null || cartorio.getNome().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        try {
            this.cartorioService.criarCartorio(cartorio);
            var cartorios = this.cartorioService.listarCartorios();
            return ResponseEntity.ok(cartorios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @ApiOperation(value = "Atualiza um cartório e retorna uma lista de cartórios")
    @RequestMapping(value = "/cartorio", method = RequestMethod.PUT)
    public ResponseEntity<List<Cartorio>> atualizarCartorio(@RequestBody Cartorio cartorio) {

        if (cartorio.getNome() == null || cartorio.getNome().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        try {
            this.cartorioService.criarCartorio(cartorio);
            var cartorios = this.cartorioService.listarCartorios();
            return ResponseEntity.ok(cartorios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @ApiOperation(value = "Exclui um cartório e retorna uma lista de cartórios")
    @RequestMapping(value = "/cartorio", method = RequestMethod.DELETE)
    public ResponseEntity<List<Cartorio>> excluirCartorio(@PathParam("id") Integer id) {

        try {
            this.cartorioService.excluirCartorio(id);
            var cartorios = this.cartorioService.listarCartorios();
            return ResponseEntity.ok(cartorios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
