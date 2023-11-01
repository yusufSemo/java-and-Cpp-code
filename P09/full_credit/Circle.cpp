#include "Circle.h"

Circle::Circle(double radius): 
_radius{radius} {    
}
std::string Circle::name(){
    return "Cirlce with Radius " + std::to_string(_radius);
}
double Circle::area(){
    double pi = M_PI;
    double area = pi*(_radius*_radius);
    return area;
}