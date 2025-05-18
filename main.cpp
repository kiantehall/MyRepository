#include <iostream>
#include <fstream>
#include <string>
#include <algorithm>

using namespace std;

// Function to reverse file content
void reverseFileContent(const string& sourceFile, const string& destinationFile) {
    ifstream inputFile(sourceFile);
    if (!inputFile) {
        cerr << "Error: Cannot open " << sourceFile << endl;
        return;
    }

    // Read entire file into string
    string content((istreambuf_iterator<char>(inputFile)), istreambuf_iterator<char>());
    inputFile.close();

    // Reverse the content
    reverse(content.begin(), content.end());

    // Write to new file — NOT the original
    ofstream outputFile(destinationFile); // this is fine — separate file
    if (!outputFile) {
        cerr << "Error: Cannot write to " << destinationFile << endl;
        return;
    }

    outputFile << content;
    outputFile.close();
}

int main() {
    string userInput;
    cout << "Enter a line of text to append to CSC450_CT5_mod5.txt: ";
    getline(cin, userInput);

    // OPEN IN APPEND MODE — this is key
    ofstream appendFile("CSC450_CT5_mod5.txt", ios::app);
    if (!appendFile) {
        cerr << "Error: Cannot open CSC450_CT5_mod5.txt for appending." << endl;
        return 1;
    }

    appendFile << userInput << endl;
    appendFile.close();

    // Reverse content to a separate file
    reverseFileContent("CSC450_CT5_mod5.txt", "CSC450-mod5-reverse.txt");

    cout << "Text appended and reversed content written to CSC450-mod5-reverse.txt." << endl;

    return 0;
}
