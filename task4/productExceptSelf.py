class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        output = []
        pre = 1
        post = 1
        
        for i in range(len(nums)):
            if i > 0:
                pre = pre * nums[i - 1];
            else:
                pre = 1;
            output.append(pre)

        for j in range(len(nums),0,-1):
            if j == len(nums):
                post = 1
            else:
                post = post * nums[j]
            output[j-1] = output[j-1] * post

        return output