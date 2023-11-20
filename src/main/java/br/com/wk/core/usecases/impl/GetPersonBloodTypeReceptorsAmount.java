package br.com.wk.core.usecases.impl;

import br.com.wk.core.dto.PersonBloodTypeReceptorsAmount;
import br.com.wk.core.usecases.IGetPersonBloodTypeReceptorsAmount;
import br.com.wk.data.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetPersonBloodTypeReceptorsAmount implements IGetPersonBloodTypeReceptorsAmount {

    private final PersonRepository personRepository;

    @Override
    public List<PersonBloodTypeReceptorsAmount> call() {
        return personRepository.findBloodTypeReceptorsAmount();
    }
}
