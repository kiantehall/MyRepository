#include <iostream>
using namespace std;

int main() {
    // Declare variables
    int num1, num2, num3;

    // Get input from user
    cout << "Enter first integer: ";
    cin >> num1;
    cout << "Enter second integer: ";
    cin >> num2;
    cout << "Enter third integer: ";
    cin >> num3;

    // Allocate dynamic memory using pointers
    int* ptr1 = new int;
    int* ptr2 = new int;
    int* ptr3 = new int;

    // Assign values to the pointers
    *ptr1 = num1;
    *ptr2 = num2;
    *ptr3 = num3;

    // Display the variable and pointer values
    cout << "\nValues stored in variables:\n";
    cout << "num1 = " << num1 << endl;
    cout << "num2 = " << num2 << endl;
    cout << "num3 = " << num3 << endl;

    cout << "\nValues pointed to by pointers:\n";
    cout << "*ptr1 = " << *ptr1 << endl;
    cout << "*ptr2 = " << *ptr2 << endl;
    cout << "*ptr3 = " << *ptr3 << endl;

    // Free allocated memory
    delete ptr1;
    delete ptr2;
    delete ptr3;

    return 0;
}
