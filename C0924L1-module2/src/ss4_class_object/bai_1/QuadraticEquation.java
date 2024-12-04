package ss4_class_object.bai_1;

public class QuadraticEquation {
    private double a, b, c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getDiscriminant() {
        double delta = b * b - (4 * a * c);
        return delta >= 0 ? Math.sqrt(delta) : -1;
    }

    public double getRoot1() {
        if (a != 0 && getDiscriminant() >= 0) {
            return (-b + getDiscriminant()) / (2 * a);
        } else {
            return Double.NaN;
        }
    }

    public double getRoot2() {
        if (a != 0 && getDiscriminant() >= 0) {
            return (-b - getDiscriminant()) / (2 * a);
        } else {
            return Double.NaN;
        }
    }

    public String getResult() {
        if (a == 0) {
            if (b == 0) {
                return c == 0 ? "The equation has infinitely many solutions" : "The equation has no solution";
            }
            return "The equation has one solution: x = " + (-c / b);         }

        double delta = getDiscriminant();
        if (delta > 0) {
            return "The equation has two distinct roots: x1 = " + getRoot1() + ", x2 = " + getRoot2();
        } else if (delta == 0) {
            double root = -b / (2 * a);
            return "The equation has a double root: x1 = x2 = " + root;
        } else {
            return "The equation has no real roots (delta < 0)";
        }
    }
}
