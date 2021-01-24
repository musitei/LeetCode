class Solution {
    public int numberOfSubarrays(int[] nums, int k) 
 {
	int n = nums.length;
	int[] odd = new int[n+2];
	//建立一个odd 数组来记录第 i 个奇数的下标
        //此处数组开头和结尾预设了数组，做边界处理
	int ans = 0;//优美子数组个数
	int cnt = 0;//odd数组的下标
	for(int i = 0; i<n; i++)
	{
		if((nums[i]&1)!=0)
		{
			odd[++cnt]=i;
		}
	}
	odd[0]=-1;
	odd[++cnt]=n;
	for(int i=1;i+k<=cnt;++1)
	{
		ans+=(odd[i]-odd[i-1])*(odd[i+k]-odd[i+k-1]);
	}
	return ans;

 }
}