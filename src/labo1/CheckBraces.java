package labo1;

import java.util.Scanner;
import java.util.Stack;

public class CheckBraces {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (isBracketsOk(input))
            System.out.println("true");
        else
            System.out.println("false");
    }

    static boolean isBracketsOk(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            if (ch == '{'){
                stack.push(ch);
                continue;
            }
            if (ch == '}'){
                stack.pop();
            }
            if (stack.isEmpty()){
                return false;
            }
        }
        return (stack.isEmpty());

    }
}