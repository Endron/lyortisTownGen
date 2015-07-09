package io.github.endron.lyortisTownGen.createDataStep

import io.github.endron.lyortisTownGen.entities.Person
import org.junit.Test

class RaceProcessorTest {

    final RaceProcessor processor = new RaceProcessor()

    @Test
    void "just make sure a value gets set"() {
        final person = new Person()
        processor.process(person)

        assert person.race != null
    }
}
