package labo5;

import java.util.List;
import java.util.LinkedList;

/**
 * A polynomial represented as a linked list.
 */
public class LLPolynomial implements Polynomial{

    // The terms of the polynomial.
    private LinkedList<Term> terms = new LinkedList<Term>();

    @Override
    public boolean addTerm(Term t) {
        return terms.add(t);
    }

    @Override
    public boolean removeTerm(Term t) {
        return terms.remove(t);
    }

    @Override
    public int getTermCount() {
        return terms.size();
    }

    @Override
    public List<Character> getVariables() {
        LinkedList<Character> variables = new LinkedList<Character>();
        for (Term t : terms) {
            if (!variables.contains(t.getVariable())) {
                variables.add(t.getVariable());
            }
        }
        return variables;
    }

    @Override
    public List<Integer> getExponents() {
        LinkedList<Integer> exponents = new LinkedList<>();
        for (Term t : terms) {
            if (!exponents.contains(t.getExponent())) {
                exponents.add(t.getExponent());
            }
        }
        return exponents;
    }

    @Override
    public List<Term> getTerms(char variable, int exponent) {
        LinkedList<Term> terms = new LinkedList<>();
        for (Term t : this.terms) {
            if (t.getVariable() == variable && t.getExponent() == exponent) {
                terms.add(t);
            }
        }
        return terms;
    }

    @Override
    public List<Term> getAllTerms() {
        return terms;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Term t : terms) {
            if (t.getCoefficient() < 0) {
                s.append(t);
            }else {
                if (s.length() > 0) {
                    s.append('+');
                }
                s.append(t);
            }
        }
        return s.toString();
    }

    /**
     * Sort the terms of the polynomial by the variables and the exponents.
     */
    public void sort() {
        terms.sort(new TermComparator());
    }
}
