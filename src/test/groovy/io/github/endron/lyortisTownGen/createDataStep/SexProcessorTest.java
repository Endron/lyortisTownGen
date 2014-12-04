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

import static org.junit.Assert.assertNotNull;
import io.github.endron.lyortisTownGen.createDataStep.SexProcessor;
import io.github.endron.lyortisTownGen.entities.Person;

import org.junit.Test;

/**
 * Testcases for {@link SexProcessor}.
 */
public class SexProcessorTest {

	private final SexProcessor processor = new SexProcessor();

	/**
	 * Checks if any value at all is set by the Processor.
	 * 
	 * @throws Exception
	 */
	@Test
	public void setsAnyValue() throws Exception {
		final Person person = processor.process(new Person());

		assertNotNull(person.getSex());
	}
}
