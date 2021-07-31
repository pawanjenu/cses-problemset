#include <bits/stdc++.h>
using namespace std;

void file_input(){
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
}


int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    // file_input();
    int n;
    cin >> n;
    vector<pair<int, bool>> arr;
    int x, y;
    for (int i = 0; i < n; i++)
    {
        cin >> x >> y;
        arr.push_back(make_pair(x,true));
        arr.push_back(make_pair(y,false));

    }

    sort(arr.begin(), arr.end());
    int max_people = 0, current_max = 0;
    for(const auto & it: arr){
        current_max += it.second ? 1:-1;
        max_people = max(max_people, current_max);
    }
    cout << max_people;


 return 0;
}