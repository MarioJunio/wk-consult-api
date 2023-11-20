package br.com.wk.core.dto;

public record PersonImcRangeByAge(Integer startAge, Integer endAge, Float imc) {

    public PersonImcRangeByAge() {
        this(null, null, null);
    }
}
