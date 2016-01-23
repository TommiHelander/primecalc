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
package primecalc;

/**
 * THe {@code Result} object wraps the results of primality calculation.
 * 
 * @author 	Tommi Helander <tommi.helander@iki.fi>
 * @since 	1.0
 */
public class Result {
    
    /**
     * The value that was tested for primality.
     */
    private int intValue;
    
    /**
     * Primality of the value.
     */
    private boolean boolIsPrime;
    
    /**
     * Indicates the value's multiple if it was not prime.
     */
    private Integer intDivisibleBy;
    
    /**
     * Default constructor
     */
    public Result() {}

    /**
     * Get the tested value
     * @return {@code int}
     */
    public int getValue() {
        return intValue;
    }
    
    /**
     * Set the tested value.
     * 
     * @param intValue The {@code int} that was tested
     */
    public void setValue(int intValue) {
        this.intValue = intValue;
    }

    /**
     * Was the tested value prime or not?
     * 
     * @return true if prime, false if not prime
     */
    public boolean isPrime() {
        return boolIsPrime;
    }

    /**
     * Set primality of the tested value.
     * 
     * @param boolIsPrime {@code boolean} indicating primality
     */
    public void setPrime(boolean boolIsPrime) {
        this.boolIsPrime = boolIsPrime;
    }

    /**
     * Get the tested value's multiple.
     * <p>
     * Returns null if the value was prime.
     * 
     * @return {@code int}
     */
    public Integer getDivisibleBy() {
        return intDivisibleBy;
    }

    /**
     * Set the tested value's multiple
     * 
     * @param intDivisibleBy
     */
    public void setDivisibleBy(Integer intDivisibleBy) {
        this.intDivisibleBy = intDivisibleBy;
    }
}
