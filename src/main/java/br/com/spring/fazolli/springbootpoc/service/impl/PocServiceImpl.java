package br.com.spring.fazolli.springbootpoc.service.impl;

import br.com.spring.fazolli.springbootpoc.entity.PocEntity;
import br.com.spring.fazolli.springbootpoc.repository.PocEntityRepository;
import br.com.spring.fazolli.springbootpoc.service.PocService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * Created by fernandof on 19/07/2017.
 */
@Service
public class PocServiceImpl implements PocService{

    private PocEntityRepository repository;

    public PocServiceImpl(PocEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<PocEntity> find(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Flux<PocEntity> find() {
        return repository.findAll();
    }

    @Override
    public Mono<PocEntity> save(PocEntity entity) {
        return repository.save(entity);
    }

    @Override
    public Mono<Void> delete(UUID id) {
        return repository.deleteById(id);
    }

    @Override
    public Mono<PocEntity> update(PocEntity entity) {
        return repository.save(entity);
    }
}
