package io.github.endron.lyortisTownGen.createDataStep

import io.github.endron.lyortisTownGen.PersonRepository
import io.github.endron.lyortisTownGen.entities.Person
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CreateDataStepConfig {

    @Autowired
    StepBuilderFactory stepBuilderFactory

    @Autowired
    PersonReader personReader

    @Autowired
    SexProcessor sexProcessor

    @Autowired
    RaceProcessor raceProcessor

    @Autowired
    PersonRepository personRepository

    @Bean
    Step createDataStep() {
        stepBuilderFactory.get("createDataStep")
            .chunk(100)
            .reader(personReader)
            .processor({ Person it ->
                sexProcessor.process(it)
                raceProcessor.process(it)
            })
            .writer({ personRepository.save(it) })
            .build()
    }
}
