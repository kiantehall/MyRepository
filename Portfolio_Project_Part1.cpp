#include <iostream>
#include <thread>
#include <chrono>

// Function to count up from 0 to 20
void countUp() {
    for (int i = 0; i <= 20; ++i) {
        std::cout << "Count Up: " << i << std::endl;
        std::this_thread::sleep_for(std::chrono::milliseconds(100));
    }
}

// Function to count down from 20 to 0
void countDown() {
    for (int i = 20; i >= 0; --i) {
        std::cout << "Count Down: " << i << std::endl;
        std::this_thread::sleep_for(std::chrono::milliseconds(100));
    }
}

int main() {
    // Start first thread to count up
    std::thread thread1(countUp);
    thread1.join(); // Wait for thread1 to complete

    // Start second thread to count down
    std::thread thread2(countDown);
    thread2.join(); // Wait for thread2 to complete

    return 0;
}
