import java.util.Arrays;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int temp;
        for(int i = 0; i < nums.length; i++){
            temp = nums[i];
            for(int j = i + 1; j < nums.length; j++){
                if(temp != 101){
                    if(temp == nums[j]){
                        nums[j] = 101;
                    }
                }
            }
        }
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 101){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        RemoveDuplicates rd = new RemoveDuplicates();
        int[] nums = { 0,0,1,1,1,2,2,3,3,4 };
        System.out.println(rd.removeDuplicates(nums));
        System.out.println();
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
}
