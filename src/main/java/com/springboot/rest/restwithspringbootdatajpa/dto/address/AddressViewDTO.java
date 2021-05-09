package com.springboot.rest.restwithspringbootdatajpa.dto.address;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.springboot.rest.restwithspringbootdatajpa.dto.TrackedDTO;
import com.springboot.rest.restwithspringbootdatajpa.model.AddressEntity;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressViewDTO extends TrackedDTO {
    private String street;
    private String city;

    public AddressViewDTO(AddressEntity addressEntity) {
        super(addressEntity);
        this.street = addressEntity.getStreet();
        this.city = addressEntity.getCity();
    }
}
