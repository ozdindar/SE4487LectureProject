package chapter2.immutability.badexample.polynom;

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

    public Polynom() {
        terms = new ArrayList<>();
    }

    Polynom multipy( Term term)
    {
        Polynom p = new Polynom();
        for (int i = 0; i < terms.size(); i++) {
            Term t = new Term(terms.get(i));
            p.terms.add(t.multiply(term));
        }
        return p;
    }

    public static void main(String[] args) {
        ArrayList terms = new ArrayList();
        terms.add(new Term(1,2));
        terms.add(new Term(-2,1));
        Polynom p1= new Polynom(terms);

        Polynom p2 = new Polynom(p1);

        p2.terms.get(0).setCoeff(4);// !!! This changes the first polynom as well



    }

}
