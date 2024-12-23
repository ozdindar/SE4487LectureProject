package chapter2.immutability.goodexample.polynom;


/**
 * Polynom Example : 3x^4 + 2x -7
 *
 * Term  : 3x^4
 *
 */
class Term {
    final double coeff;
    final int degree;

    public Term(double coeff, int degree) {
        this.coeff = coeff;
        this.degree = degree;
    }

    Term(Term other)
    {
        coeff = other.coeff;
        degree = other.degree;
    }

    public double getCoeff() {
        return coeff;
    }

    public int getDegree() {
        return degree;
    }



    Term plus(Term  other)
    {
        return new Term(coeff + other.coeff, degree);
    }



}
