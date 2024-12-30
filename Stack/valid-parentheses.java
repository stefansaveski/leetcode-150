//https://leetcode.com/problems/valid-parentheses/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> brackets = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ']' || s.charAt(i) == '}' || s.charAt(i) == ')'){
                if(brackets.isEmpty())
                    return false;
                char top = brackets.pop();
                System.out.println(top + " " + s.charAt(i));
                if(top == '(' && s.charAt(i) != ')'){
                    return false;
                }
                if(top == '[' && s.charAt(i) != ']'){
                    return false;
                }
                if(top == '{' && s.charAt(i) != '}'){
                    return false;
                }
            }
            else{
                brackets.add(s.charAt(i));
            }
        }
        return brackets.isEmpty();
    }
}
