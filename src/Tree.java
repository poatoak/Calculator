import java.lang.Integer;
import java.util.Stack;
public class Tree {
    public Node root;
    public Stack<Node> expressionTree = new Stack<Node>();
    public Tree() {
        root = null;
    }
    public int calculator(OperatorNode n) {
        if (n.data == null) {
            return Integer.MIN_VALUE;
        }
        if (n.leftKid == null || n.rightKid == null) {
            return Integer.MIN_VALUE;
        }
        int leftValue;
        int rightValue;
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
            return leftValue - rightValue;
        }
        if (n.data.equals("*")) {
            return leftValue * rightValue;
        }
            return leftValue / rightValue;
    }
    public int calculator() {
        return calculator((OperatorNode) this.root);
    }
    public void parser(String[] s) {
        for (int i = 0; i < s.length; i++) {
            if (!isOperator(s[i])) {
                NumberNode temp = new NumberNode(i);
                if (!expressionTree.isEmpty()) {
                    Node top = expressionTree.pop();
                    if (i == s.length - 1) {
                      top.rightKid = temp;
                      expressionTree.push(top);
                      return;
                    }
                    OperatorNode dummy = new OperatorNode(s[i + 1]);
                    if (top.precedence >= dummy.precedence) {
                        top.rightKid = temp;
                        expressionTree.push(top);
                    } else {
                        expressionTree.push(top);
                        expressionTree.push(temp);
                    }
                } else {
                    expressionTree.push(temp);
                }
            } else {
                Node temp = expressionTree.pop();
                OperatorNode temporary = new OperatorNode(s[i]);
                temporary.leftKid = temp;
                expressionTree.push(temporary);
            }
        }
    }
    public boolean isOperator(String s) {
        String operators = "+-*/";
        return operators.contains(s);
    }
}
