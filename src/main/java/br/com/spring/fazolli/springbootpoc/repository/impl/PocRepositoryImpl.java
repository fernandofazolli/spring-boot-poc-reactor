package br.com.spring.fazolli.springbootpoc.repository.impl;

import br.com.spring.fazolli.springbootpoc.repository.PocRepository;
import org.springframework.stereotype.Service;

/**
 * Created by fernandof on 19/07/2017.
 */
@Service
public class PocRepositoryImpl implements PocRepository {
    @Override
    public String find(String pocId) {
        return String.format("{\"message repository\" : \" hello %s \" }", pocId);
    }
}
