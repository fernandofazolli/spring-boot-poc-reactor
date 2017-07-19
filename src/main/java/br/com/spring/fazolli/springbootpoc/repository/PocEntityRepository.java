package br.com.spring.fazolli.springbootpoc.repository;

import br.com.spring.fazolli.springbootpoc.entity.PocEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

/**
 * Created by fernandof on 19/07/2017.
 */

public interface PocEntityRepository extends ReactiveCrudRepository<PocEntity, UUID> {
}
