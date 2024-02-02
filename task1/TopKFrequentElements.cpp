#include <iostream>
#include <vector>
#include <set>
#include <unordered_map>
#include <algorithm>
#include <map>
#include <queue>
using namespace std;

typedef struct Node{
    int num;
    int freq;

    bool operator<(const Node& other) const {
        return other.freq > freq;  // Sort descending by fre
    }
}node;


vector<int> topKFrequent(vector<int>& nums, int k) {

    unordered_map<int,int> numfre;

    for(int num : nums){
        if(numfre.count(num) == 0){
            numfre[num] = 1;
        }else{
            numfre[num] = numfre[num] + 1;
        }
    }

    priority_queue<node> pq;
    for(auto kv: numfre){
        node x;
        x.num = kv.first;
        x.freq = kv.second;
        pq.push(x);
    }

    vector<int> vector1;
    for (int i = 0; i < k; ++i) {
        vector1.push_back(pq.top().num);
        pq.pop();
    }

    return vector1;

}