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

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import primecalc.io.BasicResultWriter;
import primecalc.io.FileResultWriterDecorator;
import primecalc.io.ResultWriter;
import primecalc.logic.PrimeNumberTester;
import primecalc.logic.TrialDivisionAlgorithm;

/**
 * The {@code Shell} object contains configuration and the main loop for the
 * interactive shell of primecalc.
 *  
 * @author 	Tommi Helander <tommi.helander@iki.fi>
 * @since 	1.0
 */
public class Shell implements AutoCloseable {
    
    /**
     * String constant for prompt message
     */
    private final String PROMPT_MESSAGE = "Input number: ";
    
    /**
     * String constant for exit command.
     */
    private static final String COMMAND_EXIT = "exit";
    
    /**
     * Constant for minimum valid integer to test for primality
     */
    private static final int MIN_VALID_INT = 2;
    
    /**
     * Constant for maximum valid integer to test for primality
     */
    private static final int MAX_VALID_INT = Integer.MAX_VALUE;
    
    /**
     * The {@code ResultWriter} object used for writing the results.
     */
    private ResultWriter resultWriter;
    
    /**
     * The {@code PrimeNumberTester} for calculating prime numbers.
     */
    private PrimeNumberTester tester;
    
    /**
     * Create a new {@code Shell}
     * <p>
     * The constructor silently creates {@code ResultWriter}, {@code Prompt},
     * and a {@code PrimeNumberTester} for internal use.
     */
    public Shell() {
        resultWriter = new  BasicResultWriter();
        tester = new PrimeNumberTester(new TrialDivisionAlgorithm());
    }
    
    /**
     * Configure the {@code Shell} object.
     * 
     * @param shConfig A {@code ShellConfiguration} object
     * @throws FileNotFoundException The exception is thrown if the optional
     * output file cannot be opened for writing. Reasons for this are: the path
     * to the file does not exist, the file is actually a directory or the
     * current user does not have write permission to the file.
     * @throws IOException The exception is thrown if an unknown error happens.
     */
    public void configure(ShellConfiguration shConfig)
        throws IOException {
        
        if (shConfig.hasOutputFile()) {
            // This PrintWriter is used for creating a FileResultWriterDecorator.
            PrintWriter pwOut;
            pwOut = new PrintWriter(
                    new BufferedWriter(
                    new FileWriter(shConfig.getOutputFile(), true)));

            //Decorate resultWriter with a FileResultWriterDecorator
            resultWriter = new FileResultWriterDecorator(resultWriter, pwOut);
        }
    }
    
    /**
     * Run the {@code Shell}.
     * <p>
     * This method starts the main loop of the primecalc shell. The shell
     * prompts the user for an input integer and prints the result using a
     * {@code ResultWriter} object. The user can exit the prompt at any time
     * by typing 'exit' instead of an integer.
     */
    public void run() {
        // Let's greet our user with some hints on how to proceed.
        StringBuilder sbWelcome = new StringBuilder();
        sbWelcome.append("###################################################");
        sbWelcome.append("\n");
        sbWelcome.append("Welcome to primecalc!");
        sbWelcome.append("\n");
        sbWelcome.append("Please enter an integer value between ");
        sbWelcome.append(Integer.toString(MIN_VALID_INT));
        sbWelcome.append(" and ");
        sbWelcome.append(Integer.toString(MAX_VALID_INT));
        sbWelcome.append("\n");
        sbWelcome.append("to find out whether it's a prime number or not.");
        sbWelcome.append("\n");
        sbWelcome.append("Exit by typing 'exit' instead of a number.");
        sbWelcome.append("\n");
        sbWelcome.append("###################################################");
        System.out.println(sbWelcome.toString());
        
        try (Scanner scanner = new Scanner(System.in)) {
            runLoop(scanner);
        }

        System.out.println("Bye!");
    }
    
    /**
     * Run the main shell loop.
     * 
     * @param scanner The {@code Scanner} object to be used for input.
     */
    private void runLoop(Scanner scanner) {
        // Variable to store the result of each test
        Result result;
        
        boolean continueLoop = true;
        do {
            displayPrompt();
            String strValue = scanner.nextLine().trim();

            if (!strValue.equalsIgnoreCase(COMMAND_EXIT)) {
                try {
                    int intValue = Integer.parseInt(strValue);
                    if (intValue > 1) {
                        result = tester.test(intValue);
                        resultWriter.write(result);
                    }
                    else {
                        printInvalidInputMessage(strValue);
                    }
                } catch (NumberFormatException e) {
                    printInvalidInputMessage(strValue);
                }
            }
            else {continueLoop = false;}

        } while (continueLoop);
    }
    
    /**
     * Display prompt to indicate that the application accepts input.
     */
    private void displayPrompt() {
        System.out.print(PROMPT_MESSAGE);
    }
    
    /**
     * Display invalid input error message
     * 
     * @param strInput The invalid input
     */
    private void printInvalidInputMessage(String strInput) {
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid input: ");
        sb.append(strInput);
        sb.append(". Please enter an integer number in range 2 - ");
        sb.append(Integer.MAX_VALUE);
        sb.append(".");
        System.out.println(sb.toString());
    }
    
    /**
     * Close the {@code Shell}
     * <p>
     * Makes sure that the {@code ResultWriter} is closed properly.
     */
    @Override
    public void close() {
        if (resultWriter != null) resultWriter.close();
    }
}
