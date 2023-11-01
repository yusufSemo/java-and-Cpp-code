#include <iostream>
#include <string>

#include "hexagon.h"

int main(void){
    Shape shape;
    std::cout<<shape.to_string()<<std::endl;
    hexagon pol(6.0);
    std::cout<<pol.to_string()<<std::endl;

}