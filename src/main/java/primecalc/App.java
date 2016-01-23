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

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main application class
 * 
 * @author 	Tommi Helander <tommi.helander@iki.fi>
 * @since 	1.0
 */
public class App {
    
    /**
     * Logger for {@code App} class.
     */
    final static Logger logger = LoggerFactory.getLogger(App.class);
    
    /**
     * Main method.
     * <p>
     * This is the entry point for the application.
     * 
     * @param args Arguments
     */
    public static void main( String[] args ) {
        
        // Create command line options for the application.
        Options options = createOptions();
        
        // Help formatter for printing application help
        HelpFormatter helpFormatter = new HelpFormatter();
        
        // Parser for command line options
        CommandLineParser clParser = new DefaultParser();
        
        // Runtime configuration for Shell
       ShellConfiguration shConfig = new ShellConfiguration();
        
        // Create a new Shell as a resource.
        try (Shell shell = new Shell()){

            // List of arguments parsed against the Options descriptor.
            CommandLine commandLine = clParser.parse(options, args);
            
            // Does the user want some help?
            if (commandLine.hasOption('h')) {
                helpFormatter.printHelp("primecalc", options);
                System.exit(0);
            }

            // Has the user specified an optional output file?
            if (commandLine.hasOption('o')) {
                String strOutputFile = commandLine.getOptionValue('o');
                shConfig.setOutputFile(strOutputFile);
            }

            shell.configure(shConfig);

            shell.run();
        }
        catch (ParseException e) {
             // Parsing of command line options failed. Let the user know it
             // and display help as well
            System.err.println("Failed when parsing options: "
                               + e.getMessage());
            helpFormatter.printHelp("primecalc", options);
        }
        catch (FileNotFoundException e) {
             // There was an error opening the optional output file for writing.
             // Display the cause of the error.
            System.err.println("Failed when opening file: " + e.getMessage());
        }
        catch (IOException e) {
            // There was some other unexpected exception when trying to open
            // output file. Let's terminate.
            logger.error(e.getMessage(), e);
            System.err.println("Oops! "
                    + "There was an unexpected error when opening file. "
                    + "Exiting...");
        }
        catch (Exception e) {
             // Some unhandled exception was thrown, let's log it, inform user
             // and terminate application
            logger.error(e.getMessage(), e);
            System.err.println("Oops! Some unexpected error happened. "
                    + "Exiting...");
        }
    }
    
    /**
     * Create command line options for the application.
     * 
     * @return {@code Options}
     */
    private static Options createOptions() {
        
        // Help option - displays 'usage' view.
        Option optHelp = Option.builder("h")
                .longOpt("help")
                .required(false)
                .desc("Show help")
                .build();
        
        // Output file option - defines an output file for results.
        Option optOutputFile = Option.builder("o")
                .longOpt("output-file")
                .hasArg()
                .required(false)
                .desc("Append results to a file")
                .build();

        Options options = new Options();
        options.addOption(optHelp);
        options.addOption(optOutputFile);
        
        return options;
    }
}
