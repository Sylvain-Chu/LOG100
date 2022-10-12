package labo5;

import java.util.List;
import java.util.Vector;

/**
 * A polynomial represented as a vector.
 */
public class VectorPolynomial implements Polynomial{

    // The terms of the polynomial.
    private Vector<Term> terms = new Vector<Term>();

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
        Vector<Character> variables = new Vector<>();
        for (Term t : terms) {
            if (!variables.contains(t.getVariable())) {
                variables.add(t.getVariable());
            }
        }
        return variables;
    }

    @Override
    public List<Integer> getExponents() {
        Vector<Integer> exponents = new Vector<>();
        for (Term t : terms) {
            if (!exponents.contains(t.getExponent())) {
                exponents.add(t.getExponent());
            }
        }
        return exponents;
    }

    @Override
    public List<Term> getTerms(char variable, int exponent) {
        Vector<Term> terms = new Vector<>();
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
}
