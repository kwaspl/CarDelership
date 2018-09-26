package com.example.dealership.commad.domain.admissions;

import com.example.dealership.commad.domain.admissions.repositories.CarEntityRepository;
import com.example.dealership.commad.domain.admissions.repositories.entites.Car;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest({
        "spring.datasource.driver-class-name=org.h2.Driver",
        "spring.datasource.url=jdbc:h2:mem:db;DB_CLOSE_DELAY=-1",
        "spring.datasource.username=sa",
        "spring.datasource.password=sa"
})
public class CarAdmissionsServiceImplITest {

    @Autowired
    private CarEntityRepository genericEntityRepository;

    @Test //--add-modules java.xml.bind
    public void givenGenericEntityRepository_whenSaveAndRetreiveEntity_thenOK() {
        //given
        final Car s = new Car();
        s.id = UUID.randomUUID().toString();

        //when
        final Car carSaved = genericEntityRepository.save(s);
        Optional<Car> foundEntity = genericEntityRepository.findById(carSaved.id);

        //then
        assertThat(foundEntity).isNotEmpty();
        assertThat(foundEntity.get().id).isEqualTo(s.id);
    }

    @SpringBootApplication
    public static class DummyStarter {
    }

}