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
 * Tests for {@code TrialDivisionAlgorithm}.
 * 
 * @author 	Tommi Helander <tommi.helander@iki.fi>
 * @since 	1.0
 */
public class TrialDivisionAlgorithmTest {

    private static int[] intArrPrimes;
    private static int[] intArrComposites;
    
    private static Algorithm algorithm;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        // Init 168 first primes (less than 1000) into an array for testing
        intArrPrimes = new int[]{
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59,
            61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127,
            131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193,
            197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269,
            271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349,
            353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431,
            433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503,
            509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599,
            601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673,
            677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761,
            769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857,
            859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947,
            953, 967, 971, 977, 983, 991, 997
        };
        
        // Composites up to 150 for testing
        intArrComposites = new int[] {
            4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22, 24, 25, 26,27, 28,
            30, 32, 33, 34, 35, 36, 38, 39, 40, 42, 44, 45, 46, 48, 49, 50, 51,
            52, 54, 55, 56, 57, 58, 60, 62, 63, 64, 65, 66, 68, 69, 70, 72, 74,
            75, 76, 77, 78, 80, 81, 82, 84, 85, 86, 87, 88, 90, 91, 92, 93, 94,
            95, 96, 98, 99, 100, 102, 104, 105, 106, 108, 110, 111, 112, 114,
            115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 128,
            129, 130, 132, 133, 134, 135, 136, 138, 140, 141, 142, 143, 144,
            145, 146, 147, 148, 150
        };
        
        // Create the algorithm
        algorithm = new TrialDivisionAlgorithm();
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test for test method using only prime numbers
     */
    @Test
    public void testTestWithPrimes() {
        for (int intPrime : intArrPrimes) {
            Result result = algorithm.test(intPrime);
            assertTrue(intPrime + " should be prime", result.isPrime());
            assertTrue("getDivisibleBy should return null",
                    (result.getDivisibleBy() == null));
            assertTrue("getValue should return " + intPrime,
                    (result.getValue() == intPrime));
        }
    }
    
    /**
     * Test for test method using only composite numbers
     */
    @Test
    public void testTestWithComposites() {
        for (int intComposite : intArrComposites) {
            Result result = algorithm.test(intComposite);
            assertFalse(intComposite + " should not be prime",
                    result.isPrime());
            assertTrue("getDivisibleBy should not return null",
                    (result.getDivisibleBy() != null));
            assertTrue("getValue should return " + intComposite,
                    (result.getValue() == intComposite));
        }
    }
    
    /**
     * Test for test method using bad input parameter expecting exception
     */
    @Test(expected=IllegalArgumentException.class)
    public void testCalculateWithInputTooSmall() {
        algorithm.test(1);
    }

}
