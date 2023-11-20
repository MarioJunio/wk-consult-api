package br.com.wk.core.usecases;

import br.com.wk.core.dto.PersonBloodTypeByAvgAge;
import br.com.wk.core.dto.PersonImcRangeByAge;

import java.util.List;

public interface IGetPersonBloodTypeByAgeAverage {

    List<PersonBloodTypeByAvgAge> call();
}
