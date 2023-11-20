package br.com.wk.core.usecases.impl;

import br.com.wk.core.dto.PersonCounterByEstadoDto;
import br.com.wk.core.dto.PersonImcRangeByAge;
import br.com.wk.core.usecases.IGetPersonCounterByEstado;
import br.com.wk.core.usecases.IGetPersonImcByAgeRange;
import br.com.wk.data.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GetPersonImcByAgeRange implements IGetPersonImcByAgeRange {

    private final PersonRepository personRepository;

    @Override
    public List<PersonImcRangeByAge> call() {
        final int maxAge = personRepository.findMaxAge().orElse(0);

        final List<PersonImcRangeByAge> personImcRangeByAges = new ArrayList<>();

        for (int age = 0; age < maxAge; age += 10) {
            personImcRangeByAges.add(new PersonImcRangeByAge(age, age + 10, personRepository.avgImcByAgeRange(age, age + 10).orElse(0f)));
        }

        return personImcRangeByAges;
    }
}
