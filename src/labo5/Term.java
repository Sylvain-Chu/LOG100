package labo5;

/**
 * A term in a polynomial.
 */
public class Term {
    // The coefficient of the term.
    private double coefficient;

    // The variable of the term.
    private char variable;

    // The exponent of the term.
    private int exponent;

    /**
     * Get the Coefficient of the term.
     */
    public double getCoefficient() {
        return coefficient;
    }

    /**
     * Get the Variable of the term.
     */
    public char getVariable() {
        return variable;
    }

    /**
     * Get the exponent of the term.
     * @return The exponent of the term.
     */
    public int getExponent() {
        return exponent;
    }

    /**
     * Create a new term.
     * @param coefficient The coefficient of the term.
     * @param variable The variable of the term.
     * @param exponent The exponent of the term.
     */
    public Term(double coefficient, char variable, int exponent) throws ZeroCoefficientException {
        if (coefficient == 0){
            throw new ZeroCoefficientException();
        }
        this.coefficient = coefficient;
        this.variable = variable;
        this.exponent = exponent;
    }

    /**
     * Create a string representation of the term.
     * @return The string representation of the term.
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        if (exponent == 0) {
            s.append(coefficient);
        } else if (exponent == 1) {
            s.append(coefficient).append(variable);
        } else {
            s.append(coefficient).append(variable).append('^').append(exponent);
        }
        return s.toString();
    }
}
