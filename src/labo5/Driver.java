package labo5;

public class Driver {
    public static void main(String[] args) {
        Term t0 = new Term(3d, 'x', 2); // 3x^2
        Term t1 = new Term(4d, 'x', 1); // 4x
        Term t2 = new Term(8d, ' ', 0); // 8
        Term t3 = new Term(2d, 'y', 3); // -2y^3
        Term t4 = new Term(7d, 'z', 2); // 7z^2
        Term t5 = new Term(4d, 'z', 5); // 4z^5
        Term t6 = new Term(-3d, 'y', 3); // -3x^3
        Term t7 = new Term(9d, 'x', 2); // 9x^2
        Term t8 = new Term(5d, 'y', 3); // 5y^3
        Term t9 = new Term(-3d, ' ', 0); // -3

        LLPolynomial p = new LLPolynomial();

        p.addTerm(t0);
        p.addTerm(t1);
        p.addTerm(t2);
        p.addTerm(t3);
        p.addTerm(t4);
        p.addTerm(t5);
        p.addTerm(t6);
        p.addTerm(t7);
        p.addTerm(t8);
        p.addTerm(t9);

        System.out.println("Polynome : " + p);

        System.out.println("Polynome Simplify : " + PolynomialToolbox.simplify(p));
        //System.out.println("Polynome sul : " + PolynomialToolbox.sum(p, p));

        p.sort();
        System.out.println("Polynome sort: " + PolynomialToolbox.simplify(p));

    }
}
