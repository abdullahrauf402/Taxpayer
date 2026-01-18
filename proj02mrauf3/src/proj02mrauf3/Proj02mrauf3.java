package proj02mrauf3;

import java.util.Scanner;

public class Proj02mrauf3 {

    public static void main(String[] args) {
        Taxpayer t1 = new Taxpayer(10000.0, 73, true, true);
        System.out.println(t1);
        System.out.println(t1.calcExemp());
        System.out.println(t1.incomeTaxable());
        System.out.println(t1.amtTax());
        t1.reportTax();
        Taxpayer t2 = new Taxpayer(45000.0, 27, false, false);
        t1.higherTax(t2);
        double highertax = 0.0;
        Taxpayer hp = null;
        for (int i = 0; i < 5; i++) {
            Taxpayer t3 = TpSetup.setupTaxPayer();
            t3.reportTax();
            if (highertax < t3.amtTax()) {
                highertax = t3.amtTax();
                hp = t3;
            }

        }
        System.out.println("Highest taxpayer was: " + hp);
    }

    public class TpSetup {

        public static Taxpayer setupTaxPayer() {
            Scanner scan = new Scanner(System.in);
            double i;
            int a;
            boolean m = false;
            boolean v = false;
            System.out.print("Enter your age: ");
            a = scan.nextInt();
            while (a < 0) {
                System.out.println("Invalid age.");
                System.out.print("Enter your age: ");
                a = scan.nextInt();
            }

            System.out.print("Enter your income: $");
            i = scan.nextDouble();
            while (i < 0) {
                System.out.println("Invalid income.");
                System.out.print("Enter your income: $");
                i = scan.nextDouble();
            }
            if (a >= 18) {
                System.out.print("Are you married? yes/no: ");
                String married = scan.next();
                if (married.equals("yes")) {
                    m = true;
                } else {

                    m = false;
                }
                System.out.print("Are you a veteran? yes/no: ");
                String vet = scan.next();
                if (vet.equals("yes")) {
                    v = true;
                } else {
                    v = false;
                }

            }
            return new Taxpayer(i, a, m, v);
        }
    }
}
