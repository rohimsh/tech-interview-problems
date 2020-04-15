package tech.interview.problems.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import tech.interview.problems.utils.Util;

public class EvaluateExpression {
	public static void main(String[] args) {
		Set<Character> ops = new HashSet<Character>();
		ops.add('+');
		ops.add('-');
		ops.add('*');
		ops.add('/');
		ops.add('^');
		
		String exp = "100 * ( 2 + 12 ) / 14";
		System.out.println(evaluate(exp, ops));
	}

	private static int evaluate(String exp, Set<Character> ops) {
		if(exp == null || exp.length() == 0)
			return 0;
		
		Stack<Integer> values = new Stack<Integer>();
		Stack<Character> operators = new Stack<Character>();
		
		for(int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
			
			if(ch == ' ') // whitespace
				continue;
			else if(Character.isDigit(ch)) { // operand
				StringBuffer sb = new StringBuffer(ch);
				while(i < exp.length() &&  Character.isDigit(ch = exp.charAt(i))) {
					sb.append(ch);
					i++;
				}
				values.push(Integer.parseInt(sb.toString()));
			} else if(ch == '(') { // opening braces
				operators.push(ch);
			} else if(ch == ')') { // closing braces
				while(!operators.isEmpty() && operators.peek() != '(')
					values.push(Util.eval(values.pop(), values.pop(), operators.pop()));
				operators.pop();
			} else if(ops.contains(ch)) { 
				while(!operators.isEmpty() && Util.hasPrecedence(ch, operators.peek()))
					values.push(Util.eval(values.pop(), values.pop(), operators.pop()));	
				operators.push(ch);
			}
		}
		
		while(!operators.isEmpty())
			values.push(Util.eval(values.pop(), values.pop(), operators.pop()));	
		
		return values.pop();
	}
}
