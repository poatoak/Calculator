import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Stack;
public class App {
    public static void main(String[] args) throws Exception {
        Tree tree = new Tree();
        Scanner scnr = new Scanner(System.in);
        String input = scnr.nextLine().strip();
        while(!input.equalsIgnoreCase("e")) {
            DecimalFormat format = new DecimalFormat("#.#########################################");
            boolean valid = false;
            String[] data = input.split(" ");
            data = reverse(toPostFix(data));
            while (!valid) {
                for (int i = 0; i < data.length; i++) {
                    String validInputs = "+-*/%1234567890.=abcdfghijklmnopqrstuvwxyz";
                    for (int j = 0; j < data[i].length(); j++) {
                        if (!validInputs.contains(Character.toString(data[i].charAt(j)))) {
                            break;
                        }
                    }
                    if (i == data.length - 1) {
                        valid = true;
                    }
                }
                if (valid == false) {
                    System.out.println("ERROR: NEW INPUT NEEDED");
                    input = scnr.nextLine();
                    data = input.split(" ");
                    data = reverse(toPostFix(data));
                }
            }
            try {
                if (data[0].equals("=")) {
                    tree.parser(data);
                    input = "";
                    input = scnr.nextLine();
                    continue;
                } else {
                    tree.root = tree.parser(data);
                }
            } catch (Exception e) {
                    System.out.println("ERROR: BAD INPUT");
                    scnr.close();
                    return;
            }
            System.out.println(format.format(tree.calculator()));
            System.out.println(tree.toString());
            input = "";
            input = scnr.nextLine();
            tree.inputIndex = 0;
            }
            scnr.close();
    }
    public static String[] toPostFix(String[] input) {
        Stack<OperatorNode> operatorStack = new Stack<OperatorNode>();
        String toReturn = "";
        for (int i = 0; i < input.length; i++) {
            if (!"+-*/%=".contains(input[i])) {
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
                //Need to add for if it is a 2+ digit before the decimal 32.5213 DONE
                String tempword = "";
                int l = j - 1;
                while (!"+-*/%".contains(a[l])) {
                    tempword += a[l];
                    l--;
                }
                int k = j + 1;
                while (!"+-*/%".contains(a[k])) {
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
