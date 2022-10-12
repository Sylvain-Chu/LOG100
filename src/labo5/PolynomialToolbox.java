    package labo5;

    import java.util.List;

    /**
     * A polynomial represented as a linked list.
     */
    public class PolynomialToolbox {

        /**
         * Simplify a polynomial by adding all terms with the same variable and exponent.
         * @param poly The polynomial to simplify.
         * @return The simplified polynomial.
         */
        public static Polynomial simplify(Polynomial poly) {
            List<Character> variables = poly.getVariables();
            List<Integer> exponents = poly.getExponents();

            Polynomial simplified = new LLPolynomial();
            for (char variable : variables) {
                for (int exponent : exponents) {
                    double coefficient = 0;
                    for (Term term : poly.getTerms(variable, exponent)) {
                        coefficient += term.getCoefficient();
                    }
                    if (coefficient != 0) {
                        simplified.addTerm(new Term(coefficient, variable, exponent));
                    }
                }
            }
            return simplified;
        }

        /**
         * Add two polynomials.
         * @param poly1 The first polynomial.
         * @param poly2 The second polynomial.
         * @return The sum of the two polynomials.
         */
        public static Polynomial sum(Polynomial poly1, Polynomial poly2) {
            List<Term> terms1 = poly1.getAllTerms();
            List<Term> terms2 = poly2.getAllTerms();

            Polynomial sumPolynom = new LLPolynomial();

            for (Term t : terms1) {
                sumPolynom.addTerm(t);
            }

            for (Term t : terms2) {
                sumPolynom.addTerm(t);
            }

            return simplify(sumPolynom);
        }

    }