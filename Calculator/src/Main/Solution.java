package Main;

import java.util.LinkedList;

public class Solution extends Calculator {

	private static final long serialVersionUID = 1;
	public static String str;

	Solution(String title) {

		super(title);

		if (s1.length() == 0) {
			s1 = "0";
		}
	}

	static boolean isDelim(char c) {
		return c == ' ';
	}

	static boolean isOperator(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/';
	}

	static int priority(char op) {
		switch (op) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		default:
			return -1;
		}
	}

	static void processOperator(LinkedList<Double> st, char op) {
		double r = st.removeLast();
		double l = st.removeLast();
		switch (op) {
		case '+':
			st.add(l + r);
			break;
		case '-':
			st.add(l - r);
			break;
		case '*':
			st.add(l * r);
			break;
		case '/':
			st.add(l / r);
			break;
		}
	}

	public static double eval(String str) {
		LinkedList<Double> st = new LinkedList<Double>();
		LinkedList<Character> op = new LinkedList<Character>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (isDelim(c))
				continue;
			if (c == '(') {
				if (str.charAt(i + 1) == ')') {
					System.err.println("ERROR: Mежду скобками ничего не введено в строке между полем: "
									+ i + " и " + (i + 1));
					break;
				}
				op.add('(');
			} else if (c == ')') {
				while (op.getLast() != '(')
					processOperator(st, op.removeLast());
				op.removeLast();
			} else if (isOperator(c)) {
				while (!op.isEmpty() && priority(op.getLast()) >= priority(c))
					processOperator(st, op.removeLast());
				op.add(c);
			} else {
				String operand = "";
				while (i < str.length() && Character.isDigit(str.charAt(i)))
					operand += str.charAt(i++);
				--i;
				st.add(Double.parseDouble(operand));
			}
		}

		while (!op.isEmpty())
			processOperator(st, op.removeLast());

		return st.get(0);

	}

}/* Окончание класса Solution */