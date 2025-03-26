/*
    Intution: 
    Firstly we need to convert this 2D array to 1D array then
    I saw that doing mod is a must and if every remainder is not equal then return -1 and if everything is fine then push to the 1D array;
    Once we check the above condition we need to sort the array so that we can find the middle element or in this case you can say we need to find the median
    Sorting will take O(nmlogn)
    Now once we get the median the next task is to find the steps by using the abs function aka (element - median element) / x 
    the output of the abs will be added to the steps later on.
*/

class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> array = new ArrayList<>();
        int remainder = grid[0][0] % x;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] % x != remainder) {
                    return -1;
                }
                array.add(grid[i][j]);
            }
        }

        Collections.sort(array);

        int n = array.size();
        int median = n / 2;

        int steps = 0;
        for (int i = 0; i < n; i++) {
            steps += Math.abs(array.get(i) - array.get(median)) / x;
        }

        return steps;
    }
}

// TC - O(mnlogn + mn)
// SC - O(nm)