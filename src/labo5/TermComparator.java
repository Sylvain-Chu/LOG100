package labo5;

import java.util.Comparator;

/**
 * A comparator for terms.
 */
public class TermComparator implements Comparator<Term> {

    /**
     * Compare two terms.
     * @param t1 The first term.
     * @param t2 The second term.
     * @return 0 if the terms are equal, -1 if t1 is smaller than t2, 1 if t1 is greater than t2.
     */
    @Override
    public int compare(Term t1, Term t2) {
        if (t1.getVariable() == t2.getVariable()) {
            return Integer.compare(t2.getExponent(), t1.getExponent());
        } else if (t1.getVariable() == ' ') {
            return 1;
        } else if (t2.getVariable() == ' ') {
            return -1;
        } else if (t1.getVariable() > t2.getVariable()) {
            return 1;
        } else {
            return -1;
        }
    }
}
