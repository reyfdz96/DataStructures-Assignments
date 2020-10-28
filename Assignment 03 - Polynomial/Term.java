public class Term {
    private double coef;
    private int exp;

    public Term(double coef, int exp) {
        this.coef = coef;
        this.exp = exp;
    }

    public void set(double coef, int exp) {
        this.coef = coef;
        this.exp = exp;
    }

    public double getCoef() {
        return coef;
    }

    public int getExp() {
        return exp;
    }

}