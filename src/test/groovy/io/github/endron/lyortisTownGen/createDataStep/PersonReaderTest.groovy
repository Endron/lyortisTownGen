package io.github.endron.lyortisTownGen.createDataStep

import org.junit.Test

class PersonReaderTest {

    final PersonReader personReader = new PersonReader()

    @Test
    void "generate correct number of persons"() {
        final persons = []
        while (true) {
            final person = personReader.read()
            if (person) {
                persons << person
            } else {
                break
            }
        }

        assert persons.size() == personReader.NUMBER_OF_PERSONS
    }
}
