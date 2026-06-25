class Solution {

    int[] count;

    public List<Integer> countSmaller(int[] nums) {

        int n = nums.length;
        count = new int[n];

        int[] indexes = new int[n];

        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }

        mergeSort(nums, indexes, 0, n - 1);

        List<Integer> ans = new ArrayList<>();

        for (int x : count) {
            ans.add(x);
        }

        return ans;
    }

    public void mergeSort(int[] nums, int[] indexes, int low, int high) {

        if (low >= high)
            return;

        int mid = (low + high) / 2;

        mergeSort(nums, indexes, low, mid);
        mergeSort(nums, indexes, mid + 1, high);

        merge(nums, indexes, low, mid, high);
    }

    public void merge(int[] nums, int[] indexes,
                      int low, int mid, int high) {

        int[] temp = new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int k = 0;

        int rightCount = 0;

        while (left <= mid && right <= high) {

            if (nums[indexes[right]] < nums[indexes[left]]) {

                temp[k++] = indexes[right++];
                rightCount++;

            } else {

                count[indexes[left]] += rightCount;
                temp[k++] = indexes[left++];
            }
        }

        while (left <= mid) {

            count[indexes[left]] += rightCount;
            temp[k++] = indexes[left++];
        }

        while (right <= high) {
            temp[k++] = indexes[right++];
        }

        for (int i = low; i <= high; i++) {
            indexes[i] = temp[i - low];
        }
    }
}