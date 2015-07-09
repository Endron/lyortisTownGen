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
package io.github.endron.lyortisTownGen;

import static io.github.endron.lyortisTownGen.RandomValuePickerTest.TestValues.VALUE_A;
import static io.github.endron.lyortisTownGen.RandomValuePickerTest.TestValues.VALUE_B;
import static io.github.endron.lyortisTownGen.RandomValuePickerTest.TestValues.VALUE_C;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static org.junit.Assert.assertTrue;

import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * Testcases for RandomValuePicker.
 */
public class RandomValuePickerTest {

	protected enum TestValues {
		VALUE_A, VALUE_B, VALUE_C
	}

	/**
	 * Testing if random chosen values are within expected boundris.
	 */
	@Test
	public void test() {
		final Map<TestValues, Integer> drawtabel = new EnumMap<>(TestValues.class);
		drawtabel.put(VALUE_A, 3);
		drawtabel.put(VALUE_B, 2);
		drawtabel.put(VALUE_C, 5);

		final RandomValuePicker<TestValues> picker = new RandomValuePicker<>(drawtabel, 5699L);

		final List<TestValues> drawResults = new LinkedList<>();
		for (int counter = 0; counter < 10_000; counter++) {
			drawResults.add(picker.drawValue());
		}

		final Map<TestValues, Long> sum = drawResults.stream().collect(groupingBy(identity(), counting()));

		assertTrue(sum.get(VALUE_A) > 3_000 * 0.95 && sum.get(VALUE_A) < 3_000 * 1.05);
		assertTrue(sum.get(VALUE_B) > 2_000 * 0.95 && sum.get(VALUE_B) < 2_000 * 1.05);
		assertTrue(sum.get(VALUE_C) > 5_000 * 0.95 && sum.get(VALUE_C) < 5_000 * 1.05);
	}
}
