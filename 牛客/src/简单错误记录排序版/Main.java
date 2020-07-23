package 简单错误记录排序版;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String,Integer> map = new LinkedHashMap<>();
        String path = "";
        String s1 = "";
        String key = "";
        while (in.hasNext()){
          path = in.next();
            int id = path.lastIndexOf('\\');
            int Line = in.nextInt();
             s1 = id<0  ? path : path.substring(id+1);
            key = s1+" "+Line;
            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }else {
                map.put(key,1);
            }
        }
        in.close();
        List<Map.Entry<String,Integer>> list = new LinkedList<Map.Entry<String,Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o1.getValue()-o2.getValue()) == 0? (o1.getValue()-o2.getValue()) : (o2.getValue()-o1.getValue());
            }
        });

        int count = 0;
        for (Map.Entry<String,Integer> sb:list) {
            count++;
            if(count < 8){
                String[] str = sb.getKey().split(" ");
                String k = str[0].length()>16 ? str[0].substring(str[0].length()-16) : str[0];
                String n = str[1];
                System.out.println(k+" "+n+" "+sb.getValue());
            }else {
                break;
            }
        }

    }
}
