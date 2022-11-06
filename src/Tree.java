import java.lang.Integer;
import java.util.Stack;
public class Tree {
    public Node root;
    private int inputIndex = 0;
    public Stack<Node> expressionTree = new Stack<Node>();
    public Tree() {
        root = null;
    }
    public double calculator(OperatorNode n) {
        if (n.data == null) {
            return Integer.MIN_VALUE;
        }
        if (n.leftKid == null || n.rightKid == null) {
            return Integer.MIN_VALUE;
        }
        double leftValue;
        double rightValue;
        if (n.leftKid instanceof OperatorNode) {
            leftValue = calculator((OperatorNode) n.leftKid);
        } else {
            leftValue = ((NumberNode) n.leftKid).data;
        }
        if (n.rightKid instanceof OperatorNode) {
            rightValue = calculator((OperatorNode) n.rightKid);
        } else {
            rightValue = ((NumberNode) n.rightKid).data;
        }
        if (n.data.equals("+")) {
            return leftValue + rightValue;
        }
        if (n.data.equals("-")) {
            return rightValue - leftValue;
        }
        if (n.data.equals("*")) {
            return leftValue * rightValue;
        }
            return  rightValue /leftValue;
    }
    public double calculator() {
        return calculator((OperatorNode) this.root);
    }
    public Node parser(String[] input) {
        Node curroot = new Node();
        if (!"+-*/".contains(input[inputIndex])) {
            curroot = new NumberNode(Double.parseDouble(input[inputIndex]));
            // NumberNode temp = (NumberNode) curroot;
            // System.out.println( temp.data);
            this.inputIndex++;
            return curroot;
        }
        curroot = new OperatorNode(input[inputIndex]);
        this.inputIndex++;
        curroot.leftKid = parser(input);
        curroot.rightKid = parser(input);
        return curroot;
    }
    public String toString() {
        Node t = this.root;
        return t.toString();
    }
    public boolean isOperator(String s) {
        String operators = "+-*/";
        return operators.contains(s);
    }
}
