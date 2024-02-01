#include <iostream>

using namespace std;

int lengthOfLastWord(string s) {
    int i = s.size() - 1;
    while (s[i] == ' '){
        i--;
    }
    int le = 0;
    while (i >= 0 && s[i] != ' '){
        i--;
        le++;
    }
    return le;
}

//int main() {
//    cout << lengthOfLastWord("luffy is still joyboy");
//    return 0;
//}
