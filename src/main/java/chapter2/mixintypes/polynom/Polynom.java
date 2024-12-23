package chapter2.mixintypes.polynom;

import java.util.ArrayList;
import java.util.Collections;

class Polynom {
    ArrayList<Term>  terms;

    public Polynom(ArrayList<Term> terms) {
        this.terms = terms;
        Collections.sort(terms);
    }

    Polynom(Polynom other)
    {
        terms = (ArrayList<Term>) other.terms.clone();
    }

    @Override
    public String toString() {
        String st = "";

        for (int i = 0; i < terms.size() - 1; i++) {
            st += terms.get(i);
            if (terms.get(i+1).getCoeff()>0)
                 st += "+";
        }
        st += terms.get(terms.size()-1);
        return st;
    }

    public static void main(String[] args) {
        ArrayList terms = new ArrayList();
        terms.add(new Term(1,1));
        terms.add(new Term(-2,3));
        Polynom p1= new Polynom(terms);

        Polynom p2 = new Polynom(p1);

        System.out.println(p1);


    }

}
