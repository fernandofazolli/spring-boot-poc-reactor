package br.com.spring.fazolli.springbootpoc.service;

import br.com.spring.fazolli.springbootpoc.entity.PocEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Created by fernandof on 19/07/2017.
 */
public interface PocService {
    Mono<PocEntity> find(UUID id);

    Flux<PocEntity> find();

    Mono<PocEntity> save(PocEntity entity);

    Mono<Void> delete(UUID id);

    Mono<PocEntity> update(PocEntity entity);
}
