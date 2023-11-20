package br.com.wk.core.dto;

public record PersonBloodTypeByAvgAge(String bloodType, Integer age) {

    public PersonBloodTypeByAvgAge() {
        this(null, null);
    }
}
