package chapter2.immutability.goodexample.polynom;

import java.util.ArrayList;

class Polynom {
    ArrayList<Term>  terms;

    public Polynom(ArrayList<Term> terms) {
        this.terms = terms;
    }

    Polynom(Polynom other)
    {
        terms = (ArrayList<Term>) other.terms.clone();
    }

    public static void main(String[] args) {
        ArrayList terms = new ArrayList();
        terms.add(new Term(1,2));
        terms.add(new Term(-2,1));
        Polynom p1= new Polynom(terms);

        Polynom p2 = new Polynom(p1);

    }

}
