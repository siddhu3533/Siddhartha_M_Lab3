package com.greatlearning.lab3;

import java.util.Stack;

public class BalancingBracket {
	
	static boolean checkingBracketBalancing(String bracketExpression) {
		Stack<Character> stack  = new Stack<Character>();
		char check;
		//traversing the expression
		for(int i=0; i<bracketExpression.length(); i++)
		{
			char x = bracketExpression.charAt(i);
			
			if(x == '(' || x == '{' || x=='[') {
				//push the elements into stack
				stack.push(x);
				continue;
			}
			//checking if stack is empty.
			if(stack.empty()) {
				return false;
			}
			//pop the stack if any close bracket is encountered.
			switch(x) {
				case ')': check = stack.pop();
						  if(check == '{' || check == '[') {
							  return false;
						  }
						  break;
				case ']': check = stack.pop();
				  if(check == '{' || check == '(') {
					  return false;
				  }
				  break;
				case '}': check = stack.pop();
				  if(check == '(' || check == '[') {
					  return false;
				  }
				  break;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String expression = "{[()]}";
		
		boolean isBracketsBalanced = checkingBracketBalancing(expression);
		
		if(isBracketsBalanced) {
			System.out.println("The entered String has Balanced Brackets");
		}
		else
		{
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}

	}

}
