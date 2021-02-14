class Solution {
    public int[][] findContinuousSequence(int target) {
          List<int[]> list = new ArrayList<>();
        for(int i = 1;i<=target/2;i++){
            int j = i;
            int sum = 0;
            while(sum<target ){
                sum+=j;
                j++;
            }
            if(sum == target){
                int[] row = new int [j-i];
                for(int k = 0;k< row.length;k++ ){
                    row[k] = i+k;
                }
                list.add(row);
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}