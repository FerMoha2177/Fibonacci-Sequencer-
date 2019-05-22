
import java.io.*;
import java.util.Scanner;
/**
 * FibDemo outputs the contents of each Fibonacci Sequence classes' stored array in a table
 * designed to look squarish and right-aligned. With the name of each array accompanying their
 * respected table with the computed time for each calculation in nanoseconds
 */

public class FibDemo {
    public static void main(String[] args) throws IOException {
        String infile =  args[0];
        String outfile = args[1] + ".txt";
        String in = args[0];
        String[] sequences = {"FibSequence","LoopFibSequence","FastFibSequence"};
        try {
            int inputVal = getValueFromFile(infile);
            LoopFibSequence loop = new LoopFibSequence(inputVal);
            FibSequence fib = new FibSequence(inputVal);
            FastFibSequence fast = new FastFibSequence(inputVal);
            long[] timeArray = {getTime(fib), getTime(fast), getTime(loop)};
            PrintWriter outStream = new PrintWriter(new File(outfile));
            tableFormatter( fib.getFibArray(),fast.getFastFibArray(),loop.getFibArray(),
                    outfile, outStream, timeArray,sequences);
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
        catch (UserInvalidInputException e) {
            System.out.println(e.getMessage());
        }
        catch(NegativeArraySizeException e){
            System.out.println(e.getMessage());
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }

    /**getValueFromFile(String) checks if the input from a File is proper input.
     *
     * @param infile
     * @return -1 if input is invalid.
     * @return the value from the file if valid.
     */
    public static int getValueFromFile(String infile) {
        File file = new File(infile + ".txt");
        int value = 0;
        Scanner sc = null;
        try {
            sc = new Scanner(file);
            BufferedReader br = new BufferedReader(new FileReader(file));
            if (file.length() == 0) {
                throw new UserInvalidInputException();
            }
            else{
                if (!sc.hasNextInt()) {
                    throw new UserInvalidInputException("NON-INTEGER, try again");
                } else{
                    value = sc.nextInt() - 1;
                    value = isProperInteger(value);
                }
            }
                sc.close();
            }
         catch (FileNotFoundException e) {
            System.out.println(e.getMessage() + "try again");
            return -1;}
         catch (UserInvalidInputException e) {
            System.out.println(e.getMessage());
            return -1;
        }
        finally {
            return value;
        }
    }

    /**Takes in the Fibonacci Sequences' arrays and formats them to output three tables
     * of fibonacci numbers with the calculated time in nanoseconds
     *
     * @param array         First Fibonacci Sequence array
     * @param array2        Second Fibonacci Sequence array
     * @param array3        Third Fibonacci Sequence array
     * @param file          File for output
     * @param outputStream  PrintWriter obj for output
     * @param timeArray     The array of the calculated times for each Fibonacci Sequence
     * @param seqs          A string array with Titles for each table
     */
    public static void tableFormatter(int[] array, int[] array2, int[] array3, String file, PrintWriter outputStream,
                                      long[]timeArray, String[]seqs)
    {
        int digits = 0;int biggest = 0;
        int[][] arrays = {array, array2, array3};
        try {
            outputStream = new PrintWriter(file);
            for (int i = 0; i < timeArray.length; i++) {
                for (int index = 0; index < array.length; index++) {
                    if ((index % getDimension(arrays[i]) == 0)) {
                        outputStream.println();
                        outputStream.println();
                    }
                    digits = digitCount(array[index]);
                    biggest = getLargestDigit(array);
                    while (digits < biggest) {
                        outputStream.print(" ");
                        digits++;
                    }
                    outputStream.print(array[index] + "\t");
                }
                outputStream.println();
                outputStream.println(seqs[i]+"'s Performance in nanoseconds:  "+timeArray[i]);
                outputStream.println();
            }
        } catch (IOException e) {
            outputStream.println("File Not found");
        } finally {
            outputStream.close();
        }
    }

    /**Calculates runtime in nanoseconds for LoopFibSequence's next()
     *
     * @param loop
     * @return calculated runtime in nanoseconds
     */
    public static long getTime(LoopFibSequence loop) {
        long start1 = System.nanoTime();
        loop.next();
        long end1 = System.nanoTime();
        return end1 - start1;
    }

    /**Calculates runtime in nanoseconds for FibSequence's next()
     *
     * @param fib
     * @return calculated runtime in nanoseconds
     */
    public static long getTime(FibSequence fib) {

        long start1 = System.nanoTime();
        fib.next();
        long end1 = System.nanoTime();
        return end1 - start1;

    }
    /**Calculates runtime in nanoseconds for FastFibSequence's next()
     *
     * @param fast
     * @return calculated runtime in nanoseconds
     */

    public static long getTime(FastFibSequence fast) {
        long start1 = System.nanoTime();
        fast.next();
        long end1 = System.nanoTime();
        return end1 - start1;
    }

    /**
     * Calculates the Dimensions for the outputted table
     * @param array
     * @return
     */
    public static int getDimension(int[] array) {
        return (int) Math.sqrt(array.length);
    }

    /**
     * Calculates the amount of digits in an integer, to be used for table foramtting
     * @param n
     * @return amount of digits in n
     */
    public static int digitCount(int n) {
        int digits = (int) (Math.log10(n) + 1);
        return digits;
    }
    /**
     * Loops from and array and returns the largest value
     * @param array
     * @return largest value in array
     */
    public static int getLargestDigit(int[] array) {
        int digit = 0;
        int temp = 0;

        for (int index = 0; index < array.length; index++) {
            digit = digitCount(array[index]);
            if (digit > temp) {
                temp = digit;
            }

        }
        return temp;
    }

    /**
     * Checks if given integer can be used as proper input from user
     * @param n
     * @return -1 if invalid integer
     * @return n if proper Integer
     */
    public static int isProperInteger(int n) {
        if (n < 1 || n >= 39) {
            try {
                throw new UserInvalidInputException("Invalid Input: " + n);
            } catch (UserInvalidInputException e) {
                System.out.println(e.getMessage());
                return -1;
            }
        }
        else{
            return n;
        }

    }
}