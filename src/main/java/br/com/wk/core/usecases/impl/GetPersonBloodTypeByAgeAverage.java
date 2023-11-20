package br.com.wk.core.usecases.impl;

import br.com.wk.core.dto.PersonBloodTypeByAvgAge;
import br.com.wk.core.usecases.IGetPersonBloodTypeByAgeAverage;
import br.com.wk.data.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetPersonBloodTypeByAgeAverage implements IGetPersonBloodTypeByAgeAverage {

    private final PersonRepository personRepository;

    @Override
    public List<PersonBloodTypeByAvgAge> call() {
        return personRepository.findBloodTypeByAgeAverage();
    }
}
