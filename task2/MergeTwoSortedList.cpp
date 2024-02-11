struct ListNode {
     int val;
     ListNode *next;
     ListNode() : val(0), next(nullptr) {}
     ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        ListNode *mergedList = new ListNode(-1);
        ListNode *mptr = mergedList;
        while (list2 && list1){

            int x1 = list1->val;
            int x2 = list2->val;
            if (x1 <= x2){
                mptr->next = new ListNode(x1);
                mptr = mptr->next;
                list1 = list1->next;
            }else{
                mptr->next = new ListNode(x2);
                mptr = mptr->next;
                list2 = list2->next;
            }
        }

        while (list1){
            mptr->next = new ListNode(list1->val);
            mptr = mptr->next;
            list1 = list1->next;
        }

        while (list2){
            mptr->next = new ListNode(list2->val);
            mptr = mptr->next;
            list2 = list2->next;
        }


        return mergedList->next;
    }
};