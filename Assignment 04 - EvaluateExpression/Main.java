import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        while (true) {

            System.out.print("Enter an expression [q to quit]: ");
            String expression = scan.nextLine();

            if (expression.toLowerCase().equals("q")) {
                break;
            } else {
                try {
                    expression = EvaluateExpression.insertSpaces(expression);
                    System.out.println("\n\t" + expression + " = " + EvaluateExpression.evaluate(expression));
                } catch (Exception e) {
                    System.out.println("\n\tINVALID EXPRESSION! Try Again.");
                }
            }

            System.out.println("");

        }

        scan.close();

    }

}