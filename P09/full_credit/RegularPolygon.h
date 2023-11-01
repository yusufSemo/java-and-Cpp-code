//file name RegularPolygon.h
#ifndef REGULARPOLYGON_H
#define REGULARPOLYGON_H
#include "Shape.h"
#include <iostream>
#include<string>

class RegularPolygon : public Shape{
    private:
        double _num_sides;
        double _length;
    public:
        RegularPolygon(double _num_sides,double _length);
        std::string name() override;
        double area() override;
};
#endif