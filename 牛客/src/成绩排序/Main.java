package 成绩排序;



import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int num = in.nextInt();
            int type = in.nextInt();
            String[] information = new String[2*num];
            String[] name = new String[num];
            int[] sore = new int[num];
            for (int i = 0; i < 2*num ; i++) {
                information[i] = in.next();
            }
            int j = 0;
            int k = 0;
            int p = 0;
            while (j < 2*num){
                if(j % 2 != 0) {
                    sore[k] = Integer.parseInt(information[j]);
                    k++;
                }else {
                    name[p] = information[j];
                    p++;
                }
                j++;
            }
            Map<String,Integer>  map = new HashMap<>();
            for (int i = 0; i < num ; i++) {
                map.put(name[i],sore[i]);
            }
            if(type == 1){
                List<Map.Entry<String, Integer>> list1 = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
                Collections.sort(list1, new Comparator<Map.Entry<String, Integer>>(){
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        return o1.getValue() - o2.getValue();
                    }
                });
                for (Map.Entry<String, Integer> e : list1) {
                    System.out.println(e.getKey()+" "+e.getValue());
                }
            }
            if(type == 0){
                List<Map.Entry<String, Integer>> list1 = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
                Collections.sort(list1, new Comparator<Map.Entry<String, Integer>>(){
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        return o2.getValue() - o1.getValue();
                    }
                });
                for (Map.Entry<String, Integer> e : list1) {
                    System.out.println(e.getKey()+" "+e.getValue());
                }
            }
        }
    }
}

