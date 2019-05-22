/**
 * Created by Ferris on 4/17/2017.
 * Class Description:
 * FibSequence calculates the amount of fibonacci numbers requested in a
 * recursive fashion stores them inside an array to be printed.
 */
public class FibSequence implements Sequence{
    /**
     * nTerm is the user requested "nth" Fibonacci number.
     *
     * fibArray stores the fibonacci numbers up to the nth term.
     */
    private int nTerm;
    private int[] fibArray;
    /**
     * Constructor:
     * Receives the nth term as argument and initializes fibArray to that amount
     * and initializes the first 2 values in fib array to 1.
     *
     * @param nTerm
     */
    public FibSequence(int nTerm)
    {
        this.nTerm = nTerm;
        fibArray = new int[nTerm + 1];
        fibArray[0] = 1;
        fibArray[1] = 1;
    }
    /**
     * Returns the fibArray instance field
     * @return fibArray
     */

    public int[] getFibArray() {return fibArray;}

    /**
     * Returns the "nth" term as requested by user.
     * @return nTerm
     */

    public int getnTerm() {return nTerm;}

    /**
     * The next() method receives values from getFibonacci() and stores them in fibArray
     * @return the nth term that is set by the user in the constructor
     */
    @Override
    public long next() {

        for (int index = 0; index < fibArray.length; index++)
        {
            fibArray[index] = getFibonacci(index + 1);
        }
        return getFibonacci(nTerm);
    }

    /**
     * getFibonacci() recursively computes Fibonacci numbers to the parameter 'n'  or nth term
     * @param n
     * @return an integer to be recursively  computed until it returns a value of 1
     */
    public  int getFibonacci(int n) {
        if (n <= 2) {
            return 1;
        }
        return getFibonacci(n - 1) + getFibonacci(n - 2);
    }

}
