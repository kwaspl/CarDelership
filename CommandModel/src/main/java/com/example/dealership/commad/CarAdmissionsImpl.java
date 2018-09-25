package com.example.dealership.commad;

import com.example.dealership.commad.datamodel.GenericEntity;
import com.example.dealership.commad.datamodel.NewCarDTO;
import com.example.dealership.commad.repo.GenericEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarAdmissionsImpl implements CarAdmissions {

    @Autowired
    GenericEntityRepository genericEntityRepository;

    @Override
    public String admitNewCar(NewCarDTO newCar) {
        final GenericEntity save = genericEntityRepository.save(new GenericEntity("test"));
        return save.id.toString();
    }
}
