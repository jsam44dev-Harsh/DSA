#include <iostream>
#include <cmath>
using namespace std;

int countDigit(int n);

int main()
{
    int t;
    cin >> t;
    cout << countDigit(t);
    return 0;
}

int countDigit(int n)
{
    // brute force Approach
    // int count = 0;
    // while (n > 0)
    // {
    //     count++;
    //     n = n / 10;
    // }
    // return count;

    //******************************
    // Optimal Approach
    return (int)(log10(n) + 1);

    // iteration of dividing a number gives TC is O(N)
    // log and divisor(n) will give TC = O(log(N));
}