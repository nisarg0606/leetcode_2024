class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // STEP 1: Build the graph
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];

        // STEP 2: Fill adjacency list and in-degree Array
        for(int[] pair: prerequisites){
            int course = pair[0];
            int prereq = pair[1];
            adj.get(prereq).add(course); // prereq -> course
            inDegree[course]++;
        }

        // STEP 3: Initialize queue with nodes having in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0)
                queue.offer(i);
        }

        int completedCourses = 0;

        // STEP 4: Process nodes with in-degree 0
        while(!queue.isEmpty()){
            int course = queue.poll();
            completedCourses++;

            for(int neighbor: adj.get(course)){
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }

        // STEP 5: If we could complete all courses, return true
        return completedCourses == numCourses;
    }
}