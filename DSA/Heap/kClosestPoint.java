package DSA.Heap;
/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 * Time Complexity:O(nlogn)
 * Space Complexity:O(n)
 */
class kClosestPoint {
    int res;
    int x;
    int y;
    kClosestPoint(){
        
    }
    kClosestPoint(int res,int x,int y){
        this.res=res;
        this.x=x;
        this.y=y;
    }
    public int[][] kClosest(int[][] points, int K) {
        int[][] result=new int[K][2];
        if(points.length==0)
            return result;
        PriorityQueue<kClosestPoint> minHeap = new PriorityQueue<>(new Comparator<kClosestPoint>(){
            @Override
            public int compare(kClosestPoint a,kClosestPoint b){
                return a.res-b.res;
            }
        }); 
        for(int i=0;i<points.length;i++){
            int arr[]=points[i];
            int res=arr[0]*arr[0]+arr[1]*arr[1];
            minHeap.add(new kClosestPoint(res,arr[0],arr[1]));
        }
        for(int i=0;i<K;i++){
            kClosestPoint sol=minHeap.poll();
            int[] r={sol.x,sol.y};
            result[i]=r;
        }
        return result;
    }
}
