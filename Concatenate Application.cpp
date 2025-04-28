#include <iostream>
#include <string>

int main() {
    std::string firstString, secondString, result;

    for (int i = 1; i <= 3; ++i) {
        std::cout << "Test " << i << std::endl;

        std::cout << "Enter the first string: ";
        std::getline(std::cin, firstString);

        std::cout << "Enter the second string: ";
        std::getline(std::cin, secondString);

        result = firstString + secondString;

        std::cout << "Concatenated string: " << result << std::endl << std::endl;
    }

    return 0;
}
