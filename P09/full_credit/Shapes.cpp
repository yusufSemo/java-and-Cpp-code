#include <iostream>
#include <string>
#include <vector>
#include "Shape.h"
#include "Circle.h"
#include "hexagon.h"

int main(void){
    std::vector<Shape*> shapes;
    hexagon pol(6.0);
    Circle cir(6.0);
    shapes.push_back(&pol);
    shapes.push_back(&cir);
    for (Shape* shape : shapes) {
        std::cout << shape->to_string() << std::endl;
    }
}
