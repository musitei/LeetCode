class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
  
    int [] nums1_copy = new int[m];
    //nums1_copy复制nums1，这样nums1就可以用来输出最后的结果数组
    System.arraycopy(nums1, 0, nums1_copy, 0, m);

    // 定义两个指针分别指向nums1_copy和nums2
    int p1 = 0;
    int p2 = 0;

    // 定义一个指针指向nums1
    int p = 0;

    // 比较nums1_copy 和 nums2元素大小，并将最小的 加到nums1里面去。
    while ((p1 < m) && (p2 < n))
      nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];

    // 如果还有剩余
    if (p1 < m)
      System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
    if (p2 < n)
      System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
  }
}


