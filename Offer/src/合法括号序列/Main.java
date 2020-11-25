package 合法括号序列;

import java.util.Stack;

public class Main {
    public static boolean chkParenthesis(String A, int n) {
        Stack<String> stack = new Stack<>();

        if(n%2!=0){
            return false;
        }
        for(int i = 0;i<n;i++){
            if(A.charAt(i)=='('){
                continue;
            }else if(A.charAt(i)==')'){
                stack.push(String.valueOf(A.charAt(i)));
            }else {
                return false;
            }
        }
        if(stack.isEmpty()){
            return false;
        }
        for (int j = 0; j < n ; j++) {
            if(A.charAt(j)=='('){
                stack.pop();
            }

        }
        if(stack.isEmpty()){
            return true;
        }else {
            return false;
        }

    }

    public static void main(String[] args) {
        String a = "))))";
        System.out.println(chkParenthesis(a, a.length()));
    }
}
