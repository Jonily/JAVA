class Solution {
    public int[] spiralOrder(int[][] matrix) {
       List<Integer> list = new ArrayList<>();
        int hangMax = matrix.length-1;
        if(hangMax+1 == 0){
            return new int[0];
        }

        int lieMax = matrix[0].length-1;
        int[] res = new int[(hangMax+1) * (lieMax+1)];
        int lieMin = 0;
        int hangMin = 0;
        int index = 0;

        while(true){
            for(int i = lieMin; i<=lieMax;i++){
                res[index++] = matrix[hangMin][i];
            }
            hangMin++;
            if(hangMin > hangMax){
                break;
            }
            for(int i = hangMin; i<=hangMax;i++){
               res[index++] = matrix[i][lieMax];
            }
            lieMax--;
            if(lieMax < lieMin){
                break;
            }
            for(int i = lieMax; i>=lieMin;i--){
               res[index++] = matrix[hangMax][i];
            }
            hangMax--;
            if(hangMax < hangMin){
                break;
            }
            for(int i = hangMax; i>=hangMin;i--){
                res[index++] = matrix[i][lieMin];
            }
            lieMin++;
            if(lieMin > lieMax){
                break;
            }
        }
     
        return res;


    }
}