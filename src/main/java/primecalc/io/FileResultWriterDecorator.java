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

import java.io.PrintWriter;

/**
 * The {@code FileResultWriterDecorator} is used for decorating another
 * {@code ResultWriter} object to add functionality for writing to a file.
 * 
 * @author 	Tommi Helander <tommi.helander@iki.fi>
 * @since 	1.0
 */
public class FileResultWriterDecorator extends ResultWriter {
    /**
     * The {@code ResultWriter} object to that this decorator wraps.
     */
    ResultWriter wrappedResultWriter;
    
    /**
     * The {@code PrintWriter} used for output.
     */
    PrintWriter printWriter = null;

    /**
     * Create a new {@code FileResultWriterDecorator}.
     * 
     * @param wrappedResultWriter The {@code ResultWriter} to decorate
     * @param printWriter The {@code PrintWriter} for output.
     */
    public FileResultWriterDecorator(ResultWriter wrappedResultWriter,
                                     PrintWriter  printWriter) {
        this.wrappedResultWriter = wrappedResultWriter;
        this.printWriter  = printWriter;
    }

    /**
     * Close {@code FileResultWriterDecorator}. Ensures that the
     * {@code PrintWriter} is closed properly.
     */
    @Override
    public void close() {
        if (printWriter != null) printWriter.close();
    }

    @Override
    public void writeString(String str) {
        wrappedResultWriter.writeString(str);
        printWriter.println(str);
        printWriter.flush();
    }

}
