/**
 * Copyright (C) 2016 Tommi Helander
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package primecalc.logic;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import primecalc.Result;

/**
 * Tests for {@code PrimeNumberTester}.
 * 
 * @author 	Tommi Helander <tommi.helander@iki.fi>
 * @since 	1.0
 */
public class PrimeNumberCalculatorTest {
    
    private static PrimeNumberTester calc;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Algorithm algorithm = new TrialDivisionAlgorithm();
        calc = new PrimeNumberTester(algorithm);
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test constructor
     */
    @Test
    public void testPrimeNumberCalculator() {
        Algorithm algorithm = new TrialDivisionAlgorithm();
        PrimeNumberTester calc = new PrimeNumberTester(algorithm);
        assertTrue("Should not be null", calc != null);
    }
    
    /**
     * Test method test
     */
    @Test
    public void testTest() {
        Result result = calc.test(2147483647);
        assertTrue("Should be prime", result.isPrime());
    }
    
    /**
     * Test method test with bad input expecting exception
     */
    @Test(expected=IllegalArgumentException.class)
    public void testTestWithBadInput() {
        calc.test(-2147483648);
    }

}
