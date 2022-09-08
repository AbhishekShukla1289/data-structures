class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        int[] distance = new int[n];
        
        for(int i = 0; i < n; i++){
            distance[i] = dist(points[i]);
        }
        
        Arrays.sort(distance);
        int distK = distance[k-1];
        
        int[][] ans = new int[k][2];
        int t = 0;
        for (int i = 0; i < n; ++i)
            if (dist(points[i]) <= distK)
                ans[t++] = points[i];
        return ans;
        
    }
    
    public int dist(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }
    
}