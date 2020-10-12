package DSA.Graph;
/**
 * https://leetcode.com/problems/course-schedule-ii
 * Time Complexity:O(V+E)
 * Space Complexity:O(V+E)
 */
/**
 * Time Complexity: O(V + E)O(V+E) where VV represents the number of vertices and EE represents the number of edges. 
 * We pop each node exactly once from the zero in-degree queue and that gives us VV. Also, for each vertex,
 *  we iterate over its adjacency list and in totality, we iterate over all the edges in the graph which gives us EE.
 *  Hence, O(V + E)O(V+E)
 * Space Complexity: O(V + E)O(V+E). We use an intermediate queue data structure to keep all the nodes with 0 in-degree. 
 * In the worst case, there won't be any prerequisite relationship and the queue will contain all the vertices 
 * initially since all of them will have 0 in-degree. That gives us O(V)O(V).
 * Additionally, we also use the adjacency list to represent our graph initially. 
 * The space occupied is defined by the number of edges because for each node as the key, 
 * we have all its adjacent nodes in the form of a list as the value. Hence, O(E)O(E). So, 
 * the overall space complexity is O(V + E).
 */
class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,ArrayList<Integer>> graph=new HashMap<>();
        int[] indegree=new int[numCourses];
        int[] topologicalOrder = new int[numCourses];
        //Initialize graph
        for(int i=0;i<numCourses;i++)
            graph.put(i,new ArrayList<Integer>());
        
        //adding Edges and populating indegree
        for(int i=0;i<prerequisites.length;i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        //BFS
        Queue<Integer> queue=new LinkedList<Integer>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)
                queue.add(i);
        }
        int index=0;
        while(!queue.isEmpty()){
            int curr=queue.poll();
            topologicalOrder[index++]=curr;
            for(int child:graph.get(curr)){
                indegree[child]--;
                if(indegree[child]==0)
                    queue.add(child);
            }
        }
        //check if topological sort is posible or not
        if(index==numCourses)
            return topologicalOrder;
        return new int[0];
    }
}