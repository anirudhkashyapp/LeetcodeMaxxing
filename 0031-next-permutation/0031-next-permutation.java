class Solution {
    public void nextPermutation(int[] nums) {
        int index =-1;
        int n=nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index=i;
                break;
            }
        }
        if(index==-1){
            reverse(nums,0,nums.length-1);
            return;
        }
        
        for(int i =n-1;i>index;i--){
            if(nums[i]>nums[index]){
                swap(nums,i,index);
                break;
            }
        }
        reverse(nums,index+1,nums.length-1);
    }

     private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

        private void swap(int[] arr, int start, int end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
        }
}