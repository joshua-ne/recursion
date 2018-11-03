public class JR_Quicksort {


    private static void quicksort(int[] nums, int start, int end){

        if (end <= start || start >= end) {return;}

        int pivotIndex = start, pivot = nums[start];
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] < pivot) {
               nums[pivotIndex] = nums[i];
               nums[i] = nums[pivotIndex + 1];
               pivotIndex++;
            }
        }
        nums[pivotIndex] = pivot;

        quicksort(nums, start, pivotIndex - 1);
        quicksort(nums, pivotIndex + 1, end);



    }


    public static void main(String[] args) {
        int[] nums = {100, 3,6,9,5,87,4,7,3, 32};
        quicksort(nums, 0, nums.length - 1);
        for(int i : nums) System.out.print(i + " ");
    }
}
