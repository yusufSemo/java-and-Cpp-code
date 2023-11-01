#include <iostream>
#include <string>
#include "Circle.h"
#include "hexagon.h"

int main(void){
    hexagon pol(6.0);
    std::cout<<pol.to_string()<<std::endl;
    Circle cir(6.0);
    std::cout<<cir.to_string()<<std::endl;
}