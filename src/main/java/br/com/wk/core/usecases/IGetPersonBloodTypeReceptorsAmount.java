package br.com.wk.core.usecases;

import br.com.wk.core.dto.PersonBloodTypeReceptorsAmount;

import java.util.List;

public interface IGetPersonBloodTypeReceptorsAmount {

    List<PersonBloodTypeReceptorsAmount> call();
}
