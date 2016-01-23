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
 * Configuration class for a {@code Shell}.
 * 
 * @author 	Tommi Helander <tommi.helander@iki.fi>
 * @since 	1.0
 */
public class ShellConfiguration {
    
    /**
     * Optional output file.
     */
    private String strOutputFile = null;
    
    /**
     * Set output file.
     * 
     * @param strOutputFile Path to the output file
     */
    public void setOutputFile(String strOutputFile) {
        this.strOutputFile = strOutputFile;
    }
    
    /**
     * Get output file
     * 
     * @return Path to output file as {@code String}.
     */
    public String getOutputFile() {
        return this.strOutputFile;
    }
    
    /**
     * Check if output file is configured
     * 
     * @return boolean true if output file is configured, false if not
     */
    public boolean hasOutputFile() {
        return (strOutputFile != null);
    }
}
