#include <iostream>
#include <vector>
#include <set>
#include <unordered_map>
#include <algorithm>
#include <map>
using namespace std;

vector<int> twoSum(vector<int>& nums, int target) {
    unordered_map<int,int> map;
    for(int i = 0; i < nums.size(); i++){
        int complement = target - nums[i];
        if(map.count(complement)){
            return vector<int>{map[complement],i};
        }
        map[nums[i]] = i;
    }
    return {0};
}

int main() {
    vector<int> nums = {2,7,11,15};
    vector<int> ans = twoSum(nums,9);
    cout << ans[0];
    cout << ans[1];
    cout <<"done";
    return 0;
}
