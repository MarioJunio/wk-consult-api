package br.com.wk.core.usecases;

import br.com.wk.core.dto.PersonCounterByEstadoDto;

import java.util.List;

public interface IGetPersonCounterByEstado {

    List<PersonCounterByEstadoDto> call();
}
