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
package primecalc.io;

import primecalc.Result;

/**
 * The {@code ResultWriter} is used for printing the results for the user.
 * 
 * @author 	Tommi Helander <tommi.helander@iki.fi>
 * @since 	1.0
 */
public abstract class ResultWriter {
    /**
     * Write a {@code Result} object.
     * 
     * @param result String to be written
     */
    public void write(Result result) {
        StringBuilder sb = new StringBuilder();
        
        if (result.isPrime()) {
            sb.append(result.getValue());
            sb.append(" is prime.");
        }
        else {
            sb.append(result.getValue());
            sb.append(" is not prime. It is divisible by ");
            sb.append(result.getDivisibleBy());
            sb.append(".");
        }
        writeString(sb.toString());
    }
    
    /**
     * Close {@code ResultWriter}.
     * <p>
     * By default this method does nothing, but it should be overridden in
     * implementations using resources that need to be properly closed.
     */
    public void close() {}
    
    /**
     * Write a string to output.
     * 
     * @param message String to be written
     */
    protected abstract void writeString(String message);
}
