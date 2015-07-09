package io.github.endron.lyortisTownGen.createDataStep

class PersonReaderTest {

    final PersonReader personReader = new PersonReader()

    void "generate correct number of persons"() {
        final persons = []
        for (final person = personReader.read(); person; ) {
            persons + person
        }

        assert persons.size() == personReader.NUMBER_OF_PERSONS
    }
}
