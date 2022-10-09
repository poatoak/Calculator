import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Tree tree = new Tree();
        Scanner scnr = new Scanner(System.in);
        // boolean valid = false;
        String input = "";
        // while (!valid) {
        input = scnr.nextLine();
        String[] data = input.split(" ");
        tree.parser(data);
            // String operators = "+-*/";
            //     if (!operators.contains(input)){
            //         System.out.println("Input a valid symbol.");
            //         input = scnr.next();
            //         continue;
            //     }
            // valid = true;
        // }
        tree.root = tree.expressionTree.pop();
        System.out.print(tree.calculator());
        scnr.close();
    }
}
