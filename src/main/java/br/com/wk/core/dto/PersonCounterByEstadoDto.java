package br.com.wk.core.dto;

public record PersonCounterByEstadoDto(String estado, Long amount) {

    public PersonCounterByEstadoDto() {
        this(null, null);
    }
}
