#include <iostream>
#include <vector>
#include <set>
#include <unordered_map>
#include <algorithm>
using namespace std;

bool isAnagram(string s, string t) {
    sort(s.begin(),s.end());
    sort(t.begin(),t.end());

    return (s==t);
}

//int main() {
//    cout<<isAnagram("rat","car");
//    return 0;
//}
