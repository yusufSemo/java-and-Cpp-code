#include <iostream>
#include <string>
#include "Circle.h"
#include "hexagon.h"
#include "Shape.h"

int main(void){
    std::vector<Shape*> shapes;
    hexagon pol(6.0);
    Circle cir(6.0);
    Circle cir2(99.0);
    shapes.push_back(&pol);
    shapes.push_back(&cir);
    shapes.push_back(&cir2);
    for (Shape* shape : shapes) {
        std::cout << shape->to_string() << std::endl;
    }
}
