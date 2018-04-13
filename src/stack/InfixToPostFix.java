package stack;

import java.util.Stack;

import utils.Util;

public class InfixToPostFix {
	public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(toPostFix(exp));
	}

	private static String toPostFix(String exp) {
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
			
			if(Character.isLetterOrDigit(ch)) { // operand
				sb.append(ch);
			} else if(ch == '(') { // opening braces
				stack.push(ch);
			} else if(ch == ')') { // closing braces
				while(!stack.isEmpty() && stack.peek() != '(')
					sb.append(stack.pop());
				
				if(!stack.isEmpty() && stack.peek() != '(')
					System.out.println("Invalid Expression");
				else
					stack.pop();
			} else { // operator
				while(!stack.isEmpty() && Util.hasPrecedence(ch, stack.peek())) {
					sb.append(stack.pop());
				}
				
				stack.push(ch);
			}
		}
		
		while(!stack.isEmpty())
			sb.append(stack.pop());
		
		return sb.toString();
	}
}
