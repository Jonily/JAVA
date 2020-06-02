package 插入字符为回文字符;


import java.util.Scanner;
public class Test1{
        public static void main (String[] args) {
        Scanner in = new Scanner(System. in) ;
        String A = in.nextLine ();
        Scanner in1 = new Scanner (System. in);
        String B = in.nextLine();
        int count = 0;
        if(A == null && B == null) {
            System.out.println(count);
            return;
        } else if (A != null && B != null) {
        count = add(A, B) ;
        }else if (A == null)  {
              A=B;
     StringBuffer C = new StringBuffer (A) ;
   int k = C.length();
   if (justHuiwen(C,k)) {
       count++;
   }
        }else if (B == null) {
     StringBuffer C = new StringBuffer (A) ;
        int k = C.length() ;
    if (justHuiwen(C,k)) {
        count++;

    }
        }
            System.out.println(count);
        }
   public static  int add(String A, String B) {

       int i = A.length() ;
        int count = 0;
        StringBuffer C = null;
        for(int j = 0;j< i+1;j++) {
            StringBuffer stringBuffer = new StringBuffer(A);
             C = stringBuffer.insert(j, B);
            int k = C.length();
            if (justHuiwen(C, k)) {
                count++;
            }
        }
            return count;
        }
        public static boolean justHuiwen (StringBuffer C, int length) {
        for (int i = 0; i < length/2 ; i++) {
        if (C.charAt(i)  != C.charAt (length -1-i)){
            return false;
        }
        }
            return true;
        }
}
