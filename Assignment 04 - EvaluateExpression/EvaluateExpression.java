public class EvaluateExpression {

    public static int evaluate(String expression) {
        LinkedStack<Integer> operands = new LinkedStack<>();
        LinkedStack<Character> operators = new LinkedStack<>();

        String[] items = insertSpaces(expression).split(" ");

        for (String item : items) {
            char op = item.charAt(0);

            // If the extracted item is an operand
            if (Character.isDigit(op)) {

                // push it on the operand stack
                operands.push(Integer.valueOf(item));

            // if the extracted item is a + or - operator
            } else  if (op == '+' || op == '-') {

                // process all the operators at the top of the operator stack
                while (!operators.empty() &&
                (operators.peek() == '+' ||
                 operators.peek() == '-' ||
                 operators.peek() == '*' ||
                 operators.peek() == '/' ||
                 operators.peek() == '^')) {
                    processOperator(operators, operands);
                }

                // push the extracted operator to the operator stack
                operators.push(op);

            // if the extracted item is a * or / operator
            } else if (op == '*' || op == '/') {

                // process the * or / operators at the top of the operator stack
                while (!operators.empty() &&
                (operators.peek() == '*' ||
                 operators.peek() == '/' ||
                 operators.peek() == '^')) {
                    processOperator(operators, operands);
                }

                // push the extracted operator to the operator stack
                operators.push(op);

            } else if (op == '^') {

                while (!operators.empty() &&
                    operators.peek() == '^') {
                    processOperator(operators, operands);
                }

                operators.push(op);

            // if the extracted item is a '('
            } else if (op == '(') {

                // push it to the operator stack
                operators.push(op);

            // If the extracted item is a ')'
            } else if (op == ')') {

                // repeatedly process the operators from the top of the operator stack
                while (operators.peek() != '(') {
                    processOperator(operators, operands);
                }

                // until you see the '(' symbol on the stack
                operators.pop();
            }

        }

        // Repeatedly process the operators from the top of the operator stack
        while (!operators.empty()) { // until the operator stack is empty
            processOperator(operators, operands);
        }

        return operands.pop();
    }

    public static String insertSpaces(String expression) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == '(' || c == ')' || c == '^' || c == '*' || c == '/' || c == '+' || c == '-' )
                result.append(" " + c + " ");
            else
                result.append(c);

        }
        return result.toString().trim().replaceAll("\\s+", " ");
    }

    public static void processOperator(
            LinkedStack<Character> operatorStack,
            LinkedStack<Integer> operandStack)
    {
        char op = operatorStack.pop();
        int op2 = operandStack.pop();
        int op1 = operandStack.pop();

        switch (op) {
            case '+': operandStack.push(op1 + op2); break;
            case '-': operandStack.push(op1 - op2); break;
            case '*': operandStack.push(op1 * op2); break;
            case '/': operandStack.push(op1 / op2); break;
            case '^': operandStack.push((int) Math.pow(op1, op2)); break;
        }

    }

}
