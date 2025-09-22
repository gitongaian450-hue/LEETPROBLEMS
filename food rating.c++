#include <bits/stdc++.h>
using namespace std;

class FoodRatings {
private:
    unordered_map<string, pair<int, string>> foodInfo;

    struct cmp {
        bool operator()(const pair<int,string>& a, const pair<int,string>& b) const {
            if (a.first == b.first) return a.second < b.second;
            return a.first > b.first;
        }
    };

    unordered_map<string, set<pair<int,string>, cmp>> cuisineFoods;

public:
    FoodRatings(vector<string>& foods, vector<string>& cuisines, vector<int>& ratings) {
        for (int i = 0; i < foods.size(); i++) {
            foodInfo[foods[i]] = {ratings[i], cuisines[i]};
            cuisineFoods[cuisines[i]].insert({ratings[i], foods[i]});
        }
    }
    void changeRating(string food, int newRating) {
        auto [oldRating, cuisine] = foodInfo[food];
        cuisineFoods[cuisine].erase({oldRating, food});
        foodInfo[food] = {newRating, cuisine};
        cuisineFoods[cuisine].insert({newRating, food});
    }
    string highestRated(string cuisine) {
        return cuisineFoods[cuisine].begin()->second;
    }
};
int main() {
    vector<string> foods = {"sushi", "ramen", "pizza", "burger"};
    vector<string> cuisines = {"japanese", "japanese", "italian", "american"};
    vector<int> ratings = {5, 7, 9, 6};

    FoodRatings system(foods, cuisines, ratings);

    cout << system.highestRated("japanese") << endl; 
    cout << system.highestRated("italian") << endl;  

    system.changeRating("sushi", 10);
    cout << system.highestRated("japanese") << endl;

    return 0;
}