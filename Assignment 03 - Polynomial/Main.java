import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nLET'S MAKE A POLYNOMIAL!");

        while (true) {
            Polynomial polynomial = new Polynomial();

            System.out.println("\nTo start, let's add a term:");

            polynomial = addPolynomial(polynomial);

            boolean choseNew = false;

            while (true) {
                System.out.print("\nWhat would you like to do with your polynomial?\n\n");
                System.out.print(polynomial);
                System.out.print("\n\n\t[S] Simplify" + "\n\t[E] Evaluate" +
                    "\n\t[A] Add Polynomial" + "\n\t[N] New Polynomial" + "\n\t[Q] Quit\n\n> ");
                String choice = scan.nextLine().toLowerCase();

                if (choice.equals("q")) {
                    System.out.println("Bye!");
                    break;
                } else if (choice.equals("n")) {
                    choseNew = true;
                    break;
                } else if (choice.equals("s")) {
                    polynomial = polynomial.simplify();
                } else if (choice.equals("a")) {
                    polynomial = addPolynomial(polynomial);
                } else if (choice.equals("e")) {
                    double x = 0;

                    while (true) {
                        System.out.print("\nEvaluate f(x) = " + polynomial + " for x = ");

                        try {
                            x = Double.parseDouble(scan.nextLine());
                        } catch (Exception e) {
                            continue;
                        }

                        break;
                    }

                    System.out.println("f(" + x + ") = " + polynomial.evaluate(x));


                }

            }

            if (!choseNew) break;


        }

        scan.close();

    }

    public static Polynomial addPolynomial(Polynomial that) {
        Polynomial polynomial = new Polynomial();
        Scanner scan = new Scanner(System.in);

        while (true) {
            double coef;
            int exp;

            try {
                System.out.print("\nEnter coeficient: ");
                coef = Double.parseDouble(scan.nextLine());
                System.out.print("Enter exponent: ");
                exp = Integer.parseInt(scan.nextLine());
            } catch (Exception e) {
                continue;
            }

            polynomial = polynomial.add(new Polynomial(coef, exp));


            System.out.println("Your Polynomial: " + polynomial);

            String choice;

            while (true) {

                System.out.print("\nWould you like to add a new term? [Y/n]\n> ");
                choice = scan.nextLine().toLowerCase();

                if (choice.equals("y") || choice.equals("n")) break;
            }

            if (choice.equals("n")) break;
        }

        return that.add(polynomial);

    }

}