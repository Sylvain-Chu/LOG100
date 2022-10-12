package labo5;

import java.util.List;
import java.util.Vector;

public class VectorPolynomial implements Polynomial{
    @Override
    public boolean addTerm(Term t) {
        return false;
    }

    @Override
    public boolean removeTerm(Term t) {
        return false;
    }

    @Override
    public int getTermCount() {
        return 0;
    }

    @Override
    public List<Character> getVariables() {
        return null;
    }

    @Override
    public List<Integer> getExponents() {
        return null;
    }

    @Override
    public List<Term> getTerms(char variable, int exponent) {
        return null;
    }

    @Override
    public List<Term> getAllTerms() {
        return null;
    }
}
