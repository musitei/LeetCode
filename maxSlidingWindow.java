class Solution {
   public int[] maxSlidingWindow(int[] nums, int k) {
        //如果数组为空，或k == 0，加上这个判断
        if (nums == null || nums.length < k || k == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        //双端队列
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            //在尾部添加元素，并保证左边元素都比尾部大
            //如果左边小于待添加的元素，那么先把小的作为last弹出，然后再把大的元素加入
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);//双端队列中存放的是数组下标
            //在头部移除元素
            if (deque.getFirst() == i - k) {
                deque.removeFirst();
            }
            //输出结果
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.getFirst()];
            }
        }
        return res;
     }
}