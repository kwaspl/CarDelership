package com.example.dealership.query.datamodel;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Document(collection = "cars")
public class CarQuickDescriptionDTO implements Serializable {
    @Id
    public String id;

    @NotBlank
    @Size(max = 140)
    public String make;

    public CarQuickDescriptionDTO() {
    }

    public CarQuickDescriptionDTO(String id, @NotBlank @Size(max = 140) String make) {
        this.id = id;
        this.make = make;
    }
}
