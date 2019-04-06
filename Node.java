public class Node { // acts as expression tree

	private char operator;
	private double operand;
	private Node left; // left child
	private Node right; // right child

	// Node can have either operator or operand but not both
	public Node(char operator) {
		this.operator = operator;
	}

	public Node(double operand) {
		this.operand = operand;
	}

	public boolean isOperand() {
		if (this.operator != '\u0000') { // if operator has been given a value
			return false;
		} else {
			return true;
		}
	}

	public String getValue() { // returns the operator or operand
		String output = "";
		output += this.isOperand() ? this.operand : this.operator;
		return output;
	}

	public void addChildren(Node right, Node left) {
		this.right = right;
		this.left = left;
	}

	public String toString() { // inorder traversal
		String output = "";

		if (this.left != null) {
			output += this.left;
		}
		// not using ternary operator because it casts char to double
		if (this.isOperand()) {
			output += this.operand;
		} else {
			output += this.operator;
		}
		output += " ";

		if (this.right != null) {
			output += this.right;
		}

		return output;
	}
}
