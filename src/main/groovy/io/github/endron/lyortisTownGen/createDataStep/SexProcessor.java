/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 Tobias Kremer
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package io.github.endron.lyortisTownGen.createDataStep;

import static io.github.endron.lyortisTownGen.entities.Sex.FEMALE;
import static io.github.endron.lyortisTownGen.entities.Sex.MALE;
import io.github.endron.lyortisTownGen.RandomValuePicker;
import io.github.endron.lyortisTownGen.entities.Person;
import io.github.endron.lyortisTownGen.entities.Sex;

import java.util.EnumMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * Implementation of a processor setting the sex of a given person.
 */
@Component
public class SexProcessor implements ItemProcessor<Person, Person> {

	private final RandomValuePicker<Sex> picker;

	/**
	 * Constructor.
	 */
	public SexProcessor() {
		final Map<Sex, Integer> drawtable = new EnumMap<>(Sex.class);
		drawtable.put(FEMALE, 55);
		drawtable.put(MALE, 45);

		picker = new RandomValuePicker<>(drawtable, 165412L);
	}

	@Override
	public Person process(final Person item) throws Exception {
		item.setSex(picker.drawValue());

		return item;
	}
}
