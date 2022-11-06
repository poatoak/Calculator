import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Stack;
public class App {
    public static void main(String[] args) throws Exception {
        DecimalFormat format = new DecimalFormat("#.#########################################");
        Tree tree = new Tree();
        Scanner scnr = new Scanner(System.in);
        // boolean valid = false;
        String input = "";
        // while (!valid) {
        input = scnr.nextLine();
        String[] data = input.split(" ");
        data = reverse(toPostFix(data));
        tree.root = tree.parser(data);
        // String operators = "+-*/";
            //     if (!operators.contains(input)){
            //         System.out.println("Input a valid symbol.");
            //         input = scnr.next();
            //         continue;
            //     }
            // valid = true;
        // }
        System.out.println(format.format(tree.calculator()));
        scnr.close();
    }
    public static String[] toPostFix(String[] input) {
        Stack<OperatorNode> operatorStack = new Stack<OperatorNode>();
        String toReturn = "";
        for (int i = 0; i < input.length; i++) {
            if (!"+-*/".contains(input[i])) {
                toReturn += input[i] + " ";
            } else {
                OperatorNode temporary = new OperatorNode(input[i]);
                if (operatorStack.isEmpty() || temporary.precedence > operatorStack.peek().precedence) {
                    operatorStack.push(temporary);
                } else if (!operatorStack.isEmpty()){
                    while (!operatorStack.isEmpty() && temporary.precedence <= operatorStack.peek().precedence) {
                        toReturn += operatorStack.pop().data + " ";
                    }
                    operatorStack.push(temporary);
                }
            }
        }
        while (!operatorStack.isEmpty()) {
            toReturn += operatorStack.pop().data + " ";
        }
        return toReturn.split(" ");
    }
    public static String[] reverse(String[] a) {
        String[] newWord = new String[a.length];
        for (int i = 0, j = a.length - 1; i < a.length; i++, j--) {
            newWord[j] = a[i];
            if (newWord[j] == ".") {
                //Need to add for if it is a 2+ digit before the decimal 32.5213
                String tempword = "";
                int l = j - 1;
                while (!"+-*/".contains(a[l])) {
                    tempword += a[l];
                    l--;
                }
                int k = j + 1;
                while (!"+-*/".contains(a[k])) {
                    tempword += a[k];
                    k++;
                }
                j = k;
                newWord[j] = tempword;
            }
        }
        return newWord;
    }
}
