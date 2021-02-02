class Solution {
    public int subarraySum(int[] nums, int k) {
         int len = nums.length;
         int sum = 0;
         int count = 0;
         //双重循环
         for (int i = 0; i < len; ++i) {
             for (int j = i; j < len; ++j) {
                 sum += nums[j];
                 //发现符合条件的区间
                 if (sum == k) {
                     count++;
                 }
             }
             //记得归零，重新遍历
             sum = 0;
         }
         return count;
    }
}


