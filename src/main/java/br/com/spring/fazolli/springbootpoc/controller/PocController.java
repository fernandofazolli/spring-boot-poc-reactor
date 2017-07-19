package br.com.spring.fazolli.springbootpoc.controller;

import br.com.spring.fazolli.springbootpoc.consumer.PocConsumer;
import br.com.spring.fazolli.springbootpoc.repository.PocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.bus.Event;
import reactor.bus.EventBus;

import static reactor.bus.selector.Selectors.$;


/**
 * Created by fernandof on 19/07/2017.
 */
@RestController
@RequestMapping(value = "poc-reactor")
public class PocController {

    private PocRepository repository;

    private EventBus eventBus;

    @Autowired
    public PocController(PocRepository repository, EventBus eventBus, PocConsumer consumer) {
        this.repository = repository;
        this.eventBus = eventBus;
        this.eventBus.on($("find_async"), consumer);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String find(@PathVariable("name") String name){

        return repository.find(name);
    }

    @RequestMapping(value = "/async/{name}", method = RequestMethod.GET)
    public void findAsync(@PathVariable("name") String name){
        eventBus.notify("find_async", Event.wrap(name));
    }

}
