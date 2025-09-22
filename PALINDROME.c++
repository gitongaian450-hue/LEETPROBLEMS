#include<iostream>
using namespace std;
int main()
{
int x,original,reversed = 0, digit;
cout<<"ENTER A NUMBER: ";
cin >>x;	
original = x;
while(x>0)
{digit = x % 10;
reversed = reversed * 10 + digit;
x= x / 10;	
}
if (original == reversed)
{
	cout <<original<<" " <<"IS A PALINDROME NUMBER."<<"\n";
}
else
{
	cout<<original<<" "<<"IS NOT A PALINDROME NUMBER."<<"\n";
}
return 0;
}