class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
            //判断是否与target相同，相同返回索引值，不同返回-1
        }
        int l = 0, r = n - 1;
        //定义左右端点
        while (l <= r) {
        //如果左端点小于右端点
            int mid = (l + r) / 2;//找中心mid
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
            //左端点比中心点小，左部分有序情况
                if (nums[0] <= target && target < nums[mid]) {
                //如果target在有序数组中
                    r = mid - 1;
                } else {
                ////如果target在无序数组中
                    l = mid + 1;
                }
            } else {
            // //左端点比中心点大，左部分无序情况
                if (nums[mid] < target && target <= nums[n - 1]) {
                // //如果target在有序数组中
                    l = mid + 1;
                } else {
                 //如果target在无序数组中
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}