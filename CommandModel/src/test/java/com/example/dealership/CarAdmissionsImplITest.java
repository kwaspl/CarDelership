package com.example.dealership;

import com.example.dealership.commad.datamodel.GenericEntity;
import com.example.dealership.commad.repo.GenericEntityRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarAdmissionsImplITest {

    @Autowired
    private GenericEntityRepository genericEntityRepository;

    @Test //--add-modules java.xml.bind
    public void givenGenericEntityRepository_whenSaveAndRetreiveEntity_thenOK() {
        GenericEntity genericEntity = genericEntityRepository.save(new GenericEntity("test"));

        Optional<GenericEntity> foundEntity = genericEntityRepository.findById(genericEntity.id);

        Assertions.assertThat(foundEntity).isNotNull();
    }

    @SpringBootApplication
    public static class DummyStarter {
    }

}