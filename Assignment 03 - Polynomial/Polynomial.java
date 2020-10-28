import java.util.ArrayList;

public class Polynomial {
    private ArrayList<Term> terms;
    private int degree;

    public Polynomial() {
        this.terms = new ArrayList<>();
        this.degree = -1;
    }

    public Polynomial(double coef, int exp) {
        Term term = new Term(coef, exp);
        this.terms = new ArrayList<>();
        this.terms.add(term);
        this.degree = exp;
    }

    public Polynomial(Polynomial that) {
        this.copy(that);
    }

    public String toString() {
        String output = "";

        for (Term term : this.terms) {
            double coef = term.getCoef();
            int exp = term.getExp();

            if (coef < 0) {
                output += " - " + Math.abs(coef) ;
            } else if (coef >= 0) {
                output += " + " + (coef == 1 && exp == 1 ? "" : coef);
            }

            if (exp >= 1 || exp < 0) {
                output += "x";

                if (exp != 1) {
                    output += "^" + term.getExp();
                }
            }
        }
        if (output.length() >= 3) {
            if (output.substring(0, 3).equals(" + "))
                output = output.substring(3);
            else
                output = output.substring(1);
        }
        return output;
    }

    public void copy(Polynomial that) {
        this.terms = new ArrayList<>();
        for (Term term : that.terms) {
            this.terms.add(new Term(term.getCoef(), term.getExp()));
        }
        this.degree = that.degree;
    }

    public Polynomial add(Polynomial that) {
        if (this.degree == -1)
            return new Polynomial(that);
        if (that.degree == -1)
            return new Polynomial(this);

        Polynomial sum = new Polynomial(this);

        for (Term term : that.terms) {
            sum.terms.add(new Term(term.getCoef(), term.getExp()));
        }

        sum.degree = this.degree >= that.degree ? this.degree : that.degree;

        return sum;
    }

    public Polynomial simplify() {
        if (degree == -1 || this.terms.size() <= 1) return this;

        ArrayList<Term> simplTerms = new ArrayList<>();
        int size = this.degree + 1;

        for (int i = 0; i < size; i++) {
            double sum = 0;

            for (Term term : this.terms) {
                if (term.getExp() == i) {
                    sum += term.getCoef();
                }
            }

            if (sum != 0)
                simplTerms.add(new Term(sum, i));
        }

        Polynomial simplified = new Polynomial();
        simplified.terms = simplTerms;
        simplified.degree = this.degree;

        simplified = simplified.sortByExp();

        return simplified;
    }

    public Polynomial sortByExp() {
        if (this.degree == -1) return this;

        ArrayList<Term> sortedTerms = new ArrayList<>();

        for (int i = this.degree; i >= 0; i--) {
            for (Term term : this.terms) {
                if (term.getExp() == i) {
                    sortedTerms.add(term);
                }
            }
        }

        Polynomial sorted = new Polynomial();
        sorted.terms = sortedTerms;
        sorted.degree = this.degree;

        return sorted;
    }

    public double evaluate(double x) {
        double sum = 0;

        for (Term term : this.terms) {
            sum += term.getCoef() * Math.pow(x, term.getExp());
        }

        return sum;
    }

}