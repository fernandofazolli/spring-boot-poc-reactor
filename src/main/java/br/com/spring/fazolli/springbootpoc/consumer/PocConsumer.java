package br.com.spring.fazolli.springbootpoc.consumer;

import br.com.spring.fazolli.springbootpoc.repository.impl.PocRepositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.bus.Event;
import reactor.fn.Consumer;


/**
 * Created by fernandof on 19/07/2017.
 */
@Service
public class PocConsumer implements Consumer<Event<String>> {

    private PocRepositoryImpl repository;

    @Autowired
    public PocConsumer(PocRepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    public void accept(Event<String> stringEvent) {
        System.out.println(repository.find(stringEvent.getData() + " consumer "));
    }
}
