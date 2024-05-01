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
public class HumanResource {
    private String name;
    private ArrayList<Double> quantities;
    private Double available;
}
