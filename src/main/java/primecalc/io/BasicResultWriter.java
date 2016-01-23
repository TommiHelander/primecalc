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

/**
 * The {@code BasicResultWriter} is used for printing results to
 * {@code System.out}.
 * 
 * @author 	Tommi Helander <tommi.helander@iki.fi>
 * @since 	1.0
 */
public class BasicResultWriter extends ResultWriter {

    /**
     * Create a new {@code BasicResultWriter}.
     */
    public BasicResultWriter() {}
    
    @Override
    protected void writeString(String message) {
        System.out.println(message);
    }
}
