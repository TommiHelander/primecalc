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
 * The {@code TrialDivisionAlgorithm} class implements the {@code Algorithm}
 * interface to provide an algorithm that uses the trial division method for
 * testing for primality.
 * <p>
 * The trial division method checks if number n is a multiple of any integer
 * between 2 and the square root of n.
 * 
 * @author 	Tommi Helander <tommi.helander@iki.fi>
 * @since 	1.0
 */
public class TrialDivisionAlgorithm implements Algorithm {

    @Override
    public Result test(int intValue) throws IllegalArgumentException {
        if (!(intValue > 1)) {
            throw new IllegalArgumentException("Parameter must be greater than 1");
        }
        
        Result result = new Result();
        result.setValue(intValue);

        int intResult = isPrime(intValue);

        if (intResult == 0) {
            result.setPrime(true);
        }
        else {
            result.setPrime(false);
            result.setDivisibleBy(intResult);
        }
        
        return result;
    }
    
    /**
     * Test integer for primality.
     * 
     * @param intValue Integer to test for primality
     * @return int 0 if prime, first detected multiple if not
     */
    private int isPrime(int intValue) {

        if (intValue     == 2) return 0;
        if (intValue % 2 == 0) return 2;
        
        for (int i = 3; i <= Math.sqrt((double) intValue); i += 2) {
            if (intValue % i == 0) {
                return i;
            }
        }
        return 0;
    }

}
