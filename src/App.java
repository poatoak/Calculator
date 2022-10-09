import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Tree tree = new Tree();
        Scanner scnr = new Scanner(System.in);
        boolean valid = false;
        String input = "";
        // while (!valid) {
            input = scnr.nextLine();
            String[] data = input.split(" ");
            // String operators = "+-*/";
            //     if (!operators.contains(input)){
            //         System.out.println("Input a valid symbol.");
            //         input = scnr.next();
            //         continue;
            //     }
            // valid = true;
        // }
        tree.root = new OperatorNode(data[1]);
        // System.out.println("What to numbers do you want to calculate with. Input one and then a second, don't do it in one input.");
        tree.root.leftKid = new NumberNode(Integer.valueOf(data[0]));
        tree.root.rightKid = new NumberNode(Integer.valueOf(data[2]));
        System.out.print(tree.calculator());
        scnr.close();
    }
}
