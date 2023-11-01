#include "hexagon.h"

hexagon::hexagon(double side_length): 
_side_length{side_length} {    
}
std::string hexagon::name(){
    return "Hexagon with side length " + std::to_string(_side_length);
}

double hexagon::area(){
    double sq3 = std::sqrt(3);
    double area = ((3*sq3)/2)*(_side_length*_side_length);
    return area;
}