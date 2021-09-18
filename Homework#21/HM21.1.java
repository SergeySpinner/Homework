package hm21;

import java.util.Stack;

class Solution {
    public static boolean isValid(String tempString) {

        Stack<Character> characterStack = new Stack<>();

        for (int i = 0; i < tempString.length(); i++) {
            if ((tempString.charAt(i) == '(') || (tempString.charAt(i) == '[') || (tempString.charAt(i) == '{'))
                characterStack.push(tempString.charAt(i));

            else {
                if (characterStack.empty()) return false;
                if ((tempString.charAt(i) == ')') && (characterStack.peek() != '(')) return false;
                if ((tempString.charAt(i) == ']') && (characterStack.peek() != '[')) return false;
                if ((tempString.charAt(i) == '}') && (characterStack.peek() != '{')) return false;
                characterStack.pop();
            }
        }
        return characterStack.empty();
    }

    public static void main(String[] args) {
        String temp = "((([][][])))";
        System.out.println(isValid(temp));
    }
}
