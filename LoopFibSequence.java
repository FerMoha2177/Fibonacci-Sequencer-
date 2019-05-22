package SOURCE

import javax.sound.midi.Sequence;

/**
 * Created by Ferris on 4/17/2017.
 * Class Description:
 * LoopFibSequence calculates the amount of fibonacci numbers requested in an
 * iterative fashion stores them inside an array to be printed.
 */
public class LoopFibSequence implements Sequence {

    /**
     * nTerm is the user requested "nth" Fibonacci number
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
    public LoopFibSequence(int nTerm) {
        this.nTerm = nTerm;
        fibArray = new int[nTerm + 1]; //have to add one or else ArrayOutOfBoundsException
        fibArray[0] = 1;
        fibArray[1] = 1;
    }

    /**
     * Returns the fibArray instance field
     * @return fibArray
     */
    public int[] getFibArray() {
        return fibArray;
    }

    /**
     * Returns the "nth" term as requested by user.
     * @return nTerm
     */
    public int getnTerm() {
        return nTerm;
    }

    /**
     *Calculates the fibonacci numbers up to the nth term and stores all values to fibArray
     * @return the last element in fibArray
     */
    @Override
    public long next() {

        if (nTerm < 2) {
            return nTerm;
        }
        for(int i = 2; i <= nTerm; i++) {
            fibArray[i] = fibArray[i-1] + fibArray[i-2];
        }
        return fibArray[nTerm];
    }

}



