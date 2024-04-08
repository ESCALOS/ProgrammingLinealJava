package com.nanoka.integrador1.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Material {
    private String name;
    private boolean isInteger;
    private Double profitability;
}
