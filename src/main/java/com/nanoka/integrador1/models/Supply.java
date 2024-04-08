package com.nanoka.integrador1.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Supply {
    private String name;
    private Double quantityMaterialA;
    private Double quantityMaterialB;
    private Double available;
}
