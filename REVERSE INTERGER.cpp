#include <iostream>
#include <climits>
using namespace std;

int reverseInt(int num) {
    long long reversed = 0; 
    while (num != 0) {
        int digit = num % 10;
        reversed = reversed * 10 + digit;


        if (reversed > INT_MAX || reversed < INT_MIN) {
            return 0;
        }

        num /= 10;
    }

    return (int)reversed; 
}

int main() {
    int num;
    cout << "Enter a 32-bit integer: ";
    cin >> num;

    int result = reverseInt(num);
    cout << "Reversed (32-bit safe): " << result << endl;

    return 0;
}