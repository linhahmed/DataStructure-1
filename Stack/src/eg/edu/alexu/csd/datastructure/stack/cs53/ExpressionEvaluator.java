package eg.edu.alexu.csd.datastructure.stack.cs53;

/**
 * ExpressionEvaluator
 * 
 * @author linh
 */
public class ExpressionEvaluator implements IExpressionEvaluator {
	/**
	 * Takes a symbolic/numeric infix expression as input and converts it to postfix
	 * notation. There is no assumption on spaces between terms or the length of the
	 * term (e.g., two digits symbolic or numeric term)
	 * 
	 * @param expression infix expression
	 * @return postfix expression
	 */
	public String infixToPostfix(String expression) {
		Stack s = new Stack();
		String postfix = "";
		for (int i = 0; i < expression.length(); i++) {
			while (expression.charAt(i) == ' ') {
				i++;
			}
			if (Character.isDigit(expression.charAt(i))) {
				postfix += expression.charAt(i);
				postfix += ' ';
			} else if (isopen(expression.charAt(i))) {
				s.push(expression.charAt(i));
			} else if (isoperator(expression.charAt(i))) {
				while (!s.isEmpty() && !isopen((Character) s.peek())
						&& higher((Character) s.peek(), expression.charAt(i))) {
					postfix += s.peek();
					postfix += ' ';
					s.pop();
				}
				s.push(expression.charAt(i));
			} else if (isclose(expression.charAt(i))) {
				while (!s.isEmpty() && !isopen((Character) s.peek())) {
					postfix += s.peek();
					postfix += ' ';
					s.pop();
				}
				s.pop();
			} else {
				System.out.println("Error. invalid input.");
			}
		}
		while (!s.isEmpty()) {
			postfix += s.peek();
			postfix += ' ';
			s.pop();
		}
		return postfix;
	}

	/**
	 * Evaluate a postfix numeric expression, with a single space separator
	 * 
	 * @param expression postfix expression
	 * @return the expression evaluated value
	 */
	public int evaluate(String expression) {
		Stack s = new Stack();
		char ex[] = expression.toCharArray();
		float result = 0;
		float op1, op2;
		for (int i = 0; i < ex.length; i++) {
			if (Character.isDigit(ex[i])) {
				float c = 0;
				while (Character.isDigit(ex[i])) {
					c = c * 10 + Character.getNumericValue(ex[i]);
					i++;
				}
				s.push(c);
			} else if (isoperator(ex[i])) {
				try {
					op2 = (Float) s.pop();
					op1 = (Float) s.pop();
					result = perform(ex[i], op1, op2);
					s.push(result);
				} catch (Exception e) {
					System.out.println("Error. can't divide by 0");
				}
			} else {
				System.out.println("Error. invalid input.");
			}
		}
		System.out.println(result);
		return (int) result;
	}

	/**
	 * compares between operators and test which one of them has higher precedence
	 * 
	 * @param op1 operator1
	 * @param op2 operator2
	 * @return true if op1 has higher precedence than op2
	 */
	public boolean higher(char op1, char op2) {
		if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
			return true;
		} else if ((op1 == '+' || op1 == '-') && (op2 == '+' || op2 == '-')) {
			return true;
		} else if ((op1 == '*' || op1 == '/') && (op2 == '*' || op2 == '/')) {
			return true;
		}
		return false;
	}

	/**
	 * tests if the character is an open parentheses
	 * 
	 * @param character
	 * @return true if character is an open parentheses
	 */
	public boolean isopen(char character) {
		if (character == '(' || character == '{' || character == '[') {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * tests if the character is a close parentheses
	 * 
	 * @param character
	 * @return true if character is a close parentheses
	 */
	public boolean isclose(char character) {
		if (character == ')' || character == '}' || character == ']') {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * tests if the character is an operator
	 * 
	 * @param character
	 * @return true if character is an operator
	 */
	public boolean isoperator(char character) {
		if (character == '*' || character == '/' || character == '+' || character == '-') {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * perform the required operator
	 * 
	 * @param operator the operator
	 * @param op1      operand1
	 * @param op2      operand2
	 * @return the result
	 */
	public float perform(char operator, float op1, float op2) {
		float result = 0;
		if (operator == '*') {
			result = op1 * op2;
		} else if (operator == '/') {
			result = op1 / op2;
		} else if (operator == '+') {
			result = op1 + op2;
		} else if (operator == '-') {
			result = op1 - op2;
		}
		return result;
	}
}
