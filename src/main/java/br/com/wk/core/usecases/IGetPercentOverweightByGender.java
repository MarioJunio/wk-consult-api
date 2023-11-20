package br.com.wk.core.usecases;

import br.com.wk.core.dto.PersonImcRangeByAge;
import br.com.wk.core.dto.PersonPercentOverweight;

import java.util.List;

public interface IGetPercentOverweightByGender {

    PersonPercentOverweight call();
}
