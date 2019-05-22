/**
 * Created by Ferris on 4/17/2017.
 * Class Description:
 * FastFibSequence calculates the amount of fibonacci numbers requested in a
 * recursive fashion, however, it uses already calculated values to calculate remaining values
 * remaining values and stores them inside an array to be printed.
 */
public class FastFibSequence implements Sequence {
    /**
     * nTerm is the user requested "nth" Fibonacci number.
     *
     * fibArray stores the fibonacci numbers up to the nth term.
     */
    //fields
    private int nTerm;
    private int[] fastFibArray;


    //constructor
    /**
     * Constructor:
     * Receives the nth term as argument and initializes fibArray to that amount
     * and initializes the first 2 values in fib array to 1.
     *
     * @param nTerm
     */
    public FastFibSequence(int nTerm){
        this.nTerm = nTerm;
        fastFibArray = new int[nTerm + 1];
        fastFibArray[0] = 1;
        fastFibArray[1] = 1;

    }
    /**
     * Returns the fibArray instance field
     * @return fibArray
     */

    public int[] getFastFibArray() {
        return fastFibArray;
    }

    /**
     * Returns the "nth" term as requested by user.
     * @return nTerm
     */
    public int getnTerm() {
        return nTerm;
    }

    /**
     * The next() method receives values from getFibonacci() and stores them in fibArray
     * @return the nth term that is set by the user in the constructor
     */
    public long next() {

        for (int index = 0; index < fastFibArray.length; index++)
        {
            fastFibArray[index] = getFastFibonacci(index + 1);
        }
        return getFastFibonacci(nTerm);

    }
    /**
     * getFibonacci() recursively computes Fibonacci numbers to the parameter 'n'  or nth term
     *  an integer to be recursively  computed until it returns a value of 1, values are stored in fibArray
     * @param n
     * @return second to last element in fibArray[]
     *
     */

    public int  getFibonacci(int n)
    {
        final int BASE = 1;
        if(fastFibArray[n - BASE] > 0 ) {
            return fastFibArray[n - BASE];
        }if(n <= 2)
        {
            fastFibArray[n - BASE] = 1;
            return 1;
        }
        else{
            fastFibArray[n-1] = getFibonacci(n - BASE)+ getFibonacci(n - 2);
            return fastFibArray[n - BASE];
        }

    }

    /**
     * Uses already calculated values from getFibonacci
     * @param num
     * @return
     */
    public  int getFastFibonacci(int num) {

        int fibonacci = 0;
        for(int n = 1; n <= num; n++)
        {
            fibonacci = getFibonacci(n);
        }
        return fibonacci;
    }

}