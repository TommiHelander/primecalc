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

import primecalc.Result;

/**
 * The {@code PrimeNumberTester}  is used for testing whether an
 * integer is prime or composite.
 * <p>
 * An interchangeable object implementing the {@code Algorithm} interface is
 * used for performing the actual testing.
 * 
 * @author 	Tommi Helander <tommi.helander@iki.fi>
 * @since 	1.0
 */
public class PrimeNumberTester {
    
    /**
     * An algorithm to use for testing primality
     */
    private Algorithm algorithm;
    
    /**
     * Create a new {@code PrimeNumberTester}.
     * 
     * @param algorithm The {@code Algorithm} to use for testing primality
     */
    public PrimeNumberTester(Algorithm algorithm) {
        this.algorithm = algorithm;
    }
    
    /**
     * Test whether an integer is prime number or composite.
     * <p>
     * Will delegate testing to an {@code Algorithm}.
     * 
     * @param intValue The integer value to test
     * @return A {@code Result} object
     */
    public Result test(int intValue) throws IllegalArgumentException {
        return algorithm.test(intValue);
    }
}
