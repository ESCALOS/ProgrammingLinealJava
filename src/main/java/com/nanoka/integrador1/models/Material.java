package com.nanoka.integrador1.models;

import java.util.ArrayList;
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
    private Double humanResource;
    private ArrayList<Double> supplies;
}
