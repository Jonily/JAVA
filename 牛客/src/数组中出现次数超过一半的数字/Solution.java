package 数组中出现次数超过一半的数字;
import java.util.*;

public class Solution {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String []array = null;
        String s = in.nextLine();
        array = s.split(" ");
        System.out.println(getCount(array));


    }
  public static String getCount(String []array){
        Set<String> set = new HashSet<>();
        int[] a = new int[array.length];
        String b = "";
        for (int i = 0; i < array.length ; i++) {
            set.add(array[i]);
        }
        List<String> list = new ArrayList<>(set);
        for (int j = 0; j < list.size(); j++) {
            int count = 0;
            for (int k = 0; k < array.length ; k++) {
                if(  list.get(j).equals(array[k])){
                    count++;
                    if(count >= array.length/2){
                        b = array[k];
                        return b;
                    }
                }
            }
        }
        return null;
    }
}
