package bloom;

/*
 * Intuition: We can use an array to represent the men in the circle. We can then iterate through the array, removing the men one by one until only two remain. 
 */
public class Criminal {
    // let's create a function which returns String for our input and takes a num
    public static String lastManStanding(int n){
        // base case
        if (n <= 0){
            return "Invalid input";
        }else if(n == 1){
            return "1, 1";
        }
        // let's create an array for the men in the circle
        int[] men = new int[n];
        for(int i = 0; i < n; i++){
            men[i] = i + 1;
        }
        int index = 0;
        // Let's eliminate men in the circle until two remains
        while(men.length > 2){
            // so for that we need to determine the index of the person to be killed
            int killIndex = (index + 1) % men.length;
            // Now let's remove the men at killIndex from the circle
            // for that we need a helper function
            men = removeElement(men, killIndex);
            index = killIndex;
        }
        return men[0] + ", " + men[1];
    }
    
    public static int[] removeElement(int[] arr, int index){
        //base case where we will directly return array
        if(arr == null || index < 0 || index >= arr.length){
            return arr;
        }
        // This array is one shorter for the men to be killed
        int[] newArray = new int[arr.length - 1];
        int j = 0;
        for(int i = 0; i < arr.length; i++){
            if(i != index){
                newArray[j++] = arr[i];
            }
        }
        return newArray;
    }
    
    public static void main(String[] args){
        if(args.length != 1){
            System.out.println("Invalid!!! args(Need N)");
        }else{
            int n = Integer.parseInt(args[0]);
            System.out.println(lastManStanding(n));
        }
    }
}
