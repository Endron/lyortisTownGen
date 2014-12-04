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

import static java.util.stream.Collectors.summingInt;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * This class will pick a random value from an enum.
 *
 * @param <T>
 *            the class from witch the values are going to be picked.
 */
public class RandomValuePicker<T extends Enum<?>> {

	private final Map<T, Integer> drawtable;
	private final Random random;

	public RandomValuePicker(final Map<T, Integer> drawtable, final long randomSeed) {
		this.drawtable = new TreeMap<>(drawtable);
		this.random = new Random(randomSeed);
	}

	/**
	 * Draws a new value from the enum using the pre defined drawtabel.
	 *
	 * @return the drawen value
	 */
	public T drawValue() {
		final int randomValue = random.nextInt(drawMax());
		int sum = 0;

		for (final Map.Entry<T, Integer> entry : drawtable.entrySet()) {
			if (entry.getValue() > randomValue - sum) {
				return entry.getKey();
			}

			sum = sum + entry.getValue();
		}

		return null;
	}

	private int drawMax() {
		return drawtable.values().stream().collect(summingInt(it -> it));
	}
}
