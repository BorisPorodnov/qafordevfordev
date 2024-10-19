package net.proselyte.qafordevs.repository;

import net.proselyte.qafordevs.entity.DeveloperEntity;
import net.proselyte.qafordevs.entity.Status;
import net.proselyte.qafordevs.util.DataUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class DeveloperRepositoryTests {

    @Autowired
    private DeveloperRepository developerRepository;

    @BeforeEach
    public void setUp() {
        developerRepository.deleteAll();
    }

    @Test
    @DisplayName("Test save developer functionality")
    public void givenDeveloperObject_whenSave_then_developerIsCreated() {

        //given
        DeveloperEntity developerToSave = DeveloperEntity.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john.doe@mail.com")
                .specialty("Java")
                .status(Status.ACTIVE)
                .build();
        //when
        DeveloperEntity savedDeveloper = developerRepository.save(developerToSave);
        //Then
        assertThat(savedDeveloper).isNotNull();
        assertThat(savedDeveloper.getId()).isNotNull();
    }
}
