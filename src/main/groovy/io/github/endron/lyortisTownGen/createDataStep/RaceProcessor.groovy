package io.github.endron.lyortisTownGen.createDataStep

import io.github.endron.lyortisTownGen.RandomValuePicker
import io.github.endron.lyortisTownGen.entities.Person
import org.springframework.batch.item.ItemProcessor
import org.springframework.stereotype.Component

import static io.github.endron.lyortisTownGen.entities.Race.*

@Component
class RaceProcessor implements ItemProcessor<Person, Person> {

    final RandomValuePicker randomValuePicker

    RaceProcessor() {
        final drawtable = [:]
        drawtable.put(HUMAN, 94)
        drawtable.put(ELF, 2)
        drawtable.put(DWARF, 3)
        drawtable.put(ORC, 1)

        randomValuePicker = new RandomValuePicker(drawtable, -35781575L)
    }

    @Override
    Person process(final Person item) throws Exception {
        item.setRace(randomValuePicker.drawValue())

        return item
    }
}
