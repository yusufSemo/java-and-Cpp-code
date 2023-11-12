#include <iostream>
#include "Time.h"
int main(){
    std::cout<< "Test\n";
    Time time = {1,15,60};
    Time time3{time+time};
    return 0;
}