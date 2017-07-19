package br.com.spring.fazolli.springbootpoc.controller;

import br.com.spring.fazolli.springbootpoc.entity.PocEntity;
import br.com.spring.fazolli.springbootpoc.service.PocService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;


/**
 * Created by fernandof on 19/07/2017.
 */
@RestController
@RequestMapping(value = "poc-reactor")
public class PocController {

    private PocService service;

    public PocController(PocService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<PocEntity> find(@PathVariable("id") UUID id){
         return service.find(id);
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<PocEntity> findAll(){
        return service.find();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<PocEntity> save(@RequestBody PocEntity entity){
        return service.save(entity);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String delete(@PathVariable("id") UUID id){
        Mono<Void> retorno = service.delete(id);
        retorno.block();
        return "Deletado com sucesso";
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<PocEntity> update(@RequestBody PocEntity entity){
        return service.update(entity);
    }
}
