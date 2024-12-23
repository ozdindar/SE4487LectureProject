package chapter2.immutability.badexample.polynom;


/**
 * Polynom Example : 3x^4 + 2x -7
 *
 * Term  : 3x^4
 *
 */
class Term {
    double coeff;
    int degree;

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

    public void setCoeff(double coeff) {
        this.coeff = coeff;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    Term plus(Term  other)
    {
        return new Term(coeff + other.coeff, degree);
    }

    Term multiply(Term other)
    {
        coeff *= other.coeff;
        degree += degree;
        return this;
    }

}
