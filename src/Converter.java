import java.util.ArrayList;
import java.util.Stack;

public class Converter {

	public String convert(String expression) {
		return createNodes(expression.split(" "));
	}

	private String createNodes(String[] terms) {
		ArrayList<Node> nodeList = new ArrayList<Node>();
		for (String term : terms) {
			if (isDouble(term)) {
				nodeList.add(new Node(Double.parseDouble(term)));
			} else if (isOperator(term)) {
				nodeList.add(new Node(term.charAt(0)));
			}
		}
		return createTree(nodeList);
	}
	
	private String createTree(ArrayList<Node> nodeList) {
		Stack<Node> s = new Stack<Node>(); // using stack create expression tree form postfix
		for(Node node : nodeList) {
			if(node.isOperand()) {
				s.push(node);
			} else {
				node.addChildren(s.pop(), s.pop());
				s.push(node);
			}
		}
		return s.pop().toString();
	}

	private boolean isDouble(String term) {
		try {
			Double.parseDouble(term);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private boolean isOperator(String term) {

		if (term.length() > 1) { // if string is longer than 1 then it's not a char
			return false;
		}

		char character = term.charAt(0); // converting to char

		switch (character) { // disallows invalid operators
		case '+':
		case '-':
		case '*':
		case '/':
			return true;
		default:
			return false;
		}
	}
}
