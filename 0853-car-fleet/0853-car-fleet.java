class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        int n = position.length;
        int res = 0;
        
        double[][] arr = new double[n][2];
        
        for(int i = 0; i < n; i++){
            arr[i] = new double[] {position[i], (double)(target - position[i])/speed[i]};
        }
        Arrays.sort(arr, (a,b) -> Double.compare(a[0],b[0]));
        double curr = 0;
        for(int i = n - 1; i >= 0; i--){
            if(arr[i][1] > curr){
                curr = arr[i][1];
                res++;
            }
        }
        return res;
    }
}