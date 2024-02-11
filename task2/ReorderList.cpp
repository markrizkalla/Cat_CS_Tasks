#include <iostream>
#include <vector>
#include <set>
#include <unordered_map>
#include <algorithm>
#include <map>
#include <queue>
#include <stack>
using namespace std;


struct ListNode {
     int val;
     ListNode *next;
     ListNode() : val(0), next(nullptr) {}
     ListNode(int x) : val(x), next(nullptr) {}
     ListNode(int x, ListNode *next) : val(x), next(next) {}
};


class Solution {
public:
    void reorderList(ListNode* head) {
        stack<int> stack1;
        queue<int> queue1;

        ListNode *ptr = head;
        while(ptr){
            stack1.push(ptr->val);
            queue1.push(ptr->val);
            ptr = ptr->next;
        }

        bool addFromStack = false;

        ptr = head;
        while(ptr){

            if(addFromStack){
                ptr->val = stack1.top();
                stack1.pop();
                addFromStack = false;
            }else{
                ptr->val = queue1.front();
                queue1.pop();
                addFromStack = true;
            }

            ptr = ptr->next;
        }
    }

};

