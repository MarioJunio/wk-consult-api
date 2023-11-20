package br.com.wk.core.usecases.impl;

import br.com.wk.core.dto.PersonPercentOverweight;
import br.com.wk.core.entities.PersonGeneroEnum;
import br.com.wk.core.usecases.IGetPercentOverweightByGender;
import br.com.wk.data.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class GetPersonPercentOverweightByGender implements IGetPercentOverweightByGender {

    private final PersonRepository personRepository;

    @Override
    public PersonPercentOverweight call() {
        final List<Float> gendersOverweight = personRepository.findOverweightGender();

        if (!CollectionUtils.isEmpty(gendersOverweight)) {
            return new PersonPercentOverweight(gendersOverweight.get(0), gendersOverweight.get(1));
        }

        return new PersonPercentOverweight();
    }
}
