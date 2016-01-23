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
 * An {@code Algorithm} contains implementation for testing whether a
 * number is prime or composite.
 * 
 * @author 	Tommi Helander <tommi.helander@iki.fi>
 * @since 	1.0
 */
public interface Algorithm {
    
    /**
     * Test whether an integer value is prime or composite.
     * 
     * @param intValue An integer value larger than 1 to test 
     * @return A {@code Result} object
     * @throws IllegalArgumentException If the input parameter is not greater than 1
     */
    Result test(int intValue) throws IllegalArgumentException;
}
