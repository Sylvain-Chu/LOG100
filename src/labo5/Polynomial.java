package labo5;

import java.util.List;

/**
 * A polynomial represented as a linked list.
 */
public interface Polynomial {

    /**
     * Adds a term to the polynomial.
     *
     * @param t the term to add
     * @return true if the term was added, false otherwise
     */
    public boolean addTerm(Term t);

    /**
     * Removes a term from the polynomial.
     *
     * @param t the term to remove
     * @return true if the term was removed, false otherwise
     */
    public boolean removeTerm(Term t);

    /**
     * Returns the number of terms in the polynomial.
     *
     * @return the number of terms in the polynomial
     */
    public int getTermCount();

    /**
     * Returns a list of all variables in the polynomial.
     *
     * @return a list of all variables in the polynomial
     */
    public List<Character> getVariables();

    /**
     * Returns a list of all exponents in the polynomial.
     *
     * @return a list of all exponents in the polynomial
     */
    public List<Integer> getExponents();

    /**
     * Returns a list of all terms in the polynomial with the given variable and
     * exponent.
     *
     * @param variable the variable of the terms to return
     * @param exponent the exponent of the terms to return
     * @return a list of all terms in the polynomial with the given variable and
     * exponent
     */
    public List<Term> getTerms(char variable, int exponent);

    /**
     * Returns a list of all terms in the polynomial.
     *
     * @return a list of all terms in the polynomial
     */
    public List<Term> getAllTerms();

}

