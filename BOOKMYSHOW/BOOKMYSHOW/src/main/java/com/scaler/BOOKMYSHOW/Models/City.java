package com.scaler.BOOKMYSHOW.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class City extends  BaseModel {

    private String city_name;
    private String city_zipcode;
    @OneToMany
    private List<Theater> theaters;

}
