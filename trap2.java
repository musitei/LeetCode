public int trap(int[] height) {
    int ans = 0, current = 0;
    Deque<Integer> stack = new LinkedList<Integer>();
    while (current < height.length) {
        while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
            int top = stack.pop();
            if (stack.isEmpty())
                break;
            int distance = current - stack.peek() - 1;
            int bounded_height = Math.min(height[current], height[stack.peek()]) - height[top];
            ans += distance * bounded_height;
        }
        stack.push(current++);
    }
    return ans;
}
