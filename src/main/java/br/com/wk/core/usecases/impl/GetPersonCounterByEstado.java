package br.com.wk.core.usecases.impl;

import br.com.wk.core.dto.PersonCounterByEstadoDto;
import br.com.wk.core.usecases.IGetPersonCounterByEstado;
import br.com.wk.data.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetPersonCounterByEstado implements IGetPersonCounterByEstado {

    private final PersonRepository personRepository;

    @Override
    public List<PersonCounterByEstadoDto> call() {
        return personRepository.countByEstado();
    }
}
