package chapter2.mixintypes.polynom;


/**
 * Polynom Example : 3x^4 + 2x -7
 *
 * Term  : 3x^4
 *
 */
class Term implements Comparable<Term>{
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

    @Override
    public String toString() {
        return coeff + "x^" + degree;
    }

    @Override
    public int compareTo(Term t) {
        return -Integer.valueOf(degree).compareTo(t.degree);
    }
}
