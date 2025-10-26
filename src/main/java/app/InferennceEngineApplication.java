package app;


import classes.Expression;
import classes.Result;
import factory.InferenceRuleFactory;

import java.util.Scanner;

public class InferennceEngineApplication {


    public static void main(String[] args) {
        String str1;
        String str2;
        InferenceRuleFactory inferenceRuleFactory = new InferenceRuleFactory();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the first expression(q  to exit): ");

            str1 = sc.nextLine();
            if (str1.equals("q")) {
                System.out.println("Au revoir!");
                break;
            }
            System.out.println("Enter the second expression: ");
            str2 = sc.nextLine();
            Expression exp1 = transformToExppression(str1);
            Expression exp2 = transformToExppression(str2);
            Result result = inferenceRuleFactory.solve(exp1, exp2);

            System.out.println("The inference rules that match this 2 expressions is: " + result.getText());
            System.out.println("the result is: " + result.getExpression().toString());
        }
    }


    private static Expression transformToExppression(String exp) {
        String[] operators = {"^", "v", ">"};
        exp = exp.replaceAll("\\s+", "");
        for (String op : operators) {
            int index = exp.indexOf(op);
            if (index != -1) {
                String left = exp.substring(0, index);
                String right = exp.substring(index + 1);
                return new Expression(left, op, right);
            }
        }
        return new Expression(exp); // if it don't include operator so it is literal
    }
}
