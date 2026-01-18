package proj02mrauf3;

public class Taxpayer {

    private double income;
    private int age;
    private boolean married;
    private boolean vet;

    public Taxpayer() {
        income = 0.0;
        age = 0;
        married = false;
        vet = false;
    }

    public Taxpayer(double i, int a, boolean m, boolean v) {
        this();
        setIncome(i);
        setAge(a);
        setMarried(m);
        setVet(v);
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double i) {
        if (income >= 0) {
            income = i;
        } else {
            System.out.println("Try Again!");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int a) {
        if (age >= 0) {
            age = a;
        } else {
            System.out.println("Try Again!");
        }
    }

    public boolean getMarried() {
        return married;
    }

    public void setMarried(boolean m) {
        married = m;
    }

    public boolean getVet() {
        return vet;
    }

    public void setVet(boolean v) {
        vet = v;
    }

    public String toString() {
        String tp = "age: " + getAge() + ", income: $" + getIncome();
        if (married && vet) {
            tp = tp + " (married, veteran)";
        } else if (married) {
            tp = tp + " (married)";
        } else if (vet) {
            tp = tp + " (veteran)";
        }
        return tp;
    }

    public double calcExemp() {
        double exemption = 0.0;
        if (married) {
            exemption = exemption + 8000;

        } else {
            exemption = exemption + 5000;
        }
        if (vet && !married) {
            exemption = exemption + 3000;
        }
        if (age < 13 || age > 65) {
            exemption = exemption + 1000;
        }
        return exemption;
    }

    public double incomeTaxable() {
        double exemption = calcExemp();
        double it = income - exemption;
        if (it < 0) {
            return it = 0.0;
        }
        return it;
    }

    public double amtTax() {
        double it = incomeTaxable();
        if (it <= 10000) {
            return it = 0.0;
        } else if (it <= 35000) {
            return it = it * 0.15;
        } else if (it <= 85000) {
            return it = it * 0.25;
        } else if (it <= 175000) {
            return it = it * 0.28;
        } else if (it <= 375000) {
            return it = it * 0.33;
        } else {
            return it = it * 0.35;
        }

    }

    public void reportTax() {
        double exemption = calcExemp();
        double it = incomeTaxable();
        double at = amtTax();
        double finalIncome = income - at;
        System.out.println("taxpayer " + toString() + " had $" + it + " taxable which was taxed at " + (at / it * 100) + "% so paid $" + at + " leaving $" + finalIncome);
    }

    public Taxpayer higherTax(Taxpayer t2) {
        double tm1 = this.amtTax();
        double tm2 = t2.amtTax();
        if (tm1 > tm2) {
            return this;
        } else {
            return t2;
        }
    }

}
