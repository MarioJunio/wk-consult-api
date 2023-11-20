package br.com.wk.core.dto;

import java.math.BigDecimal;

public record PersonPercentOverweight(Float femalePercent, Float malePercent) {

    public PersonPercentOverweight() {
        this(null, null);
    }
}
