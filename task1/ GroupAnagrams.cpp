#include <iostream>
#include <vector>
#include <set>
#include <unordered_map>
#include <algorithm>
using namespace std;

vector<vector<string>> groupAnagrams(vector<string>& strs) {

    int pos = 0;
    unordered_map<string ,int> postions;
    vector<vector<string>> anagrams;
    for(string word : strs){
        string key = word;
        sort(key.begin(),key.end());

        if (postions.count(key) == 0){
            vector<string> words;
            words.push_back(word);
            anagrams.insert(anagrams.begin()+pos,words);
            postions[key] = pos++;
        }else{
            anagrams[postions[key]].push_back(word);
        }
    }

    return anagrams;
}

//int main() {
//    vector<string> strs = {"eat","tea","tan","ate","nat","bat"};
//    vector<vector<string >> str= groupAnagrams(strs);
//    for (int i = 0; i < str.size(); ++i) {
//        for (int j = 0; j < str[i].size(); ++j) {
//            cout << str[i][j] << "  ";
//        }
//        cout << endl;
//    }
//    cout<< "done";
//    return 0;
//}
