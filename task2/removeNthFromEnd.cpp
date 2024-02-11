#include <iostream>
#include <vector>
#include <set>
#include <unordered_map>
#include <algorithm>
#include <map>
#include <queue>
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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode *p = head;
        ListNode *c = head;
        ListNode *ptr = head;

        for(int i = 0; i < n-1; i++){
            ptr = ptr->next;
        }
        while (ptr->next){
            p = c;
            c = c->next;
            ptr = ptr->next;
        }
        if (p == c)
        {
            return c->next;
        }
        p->next = c->next;
        return head;
    }
};