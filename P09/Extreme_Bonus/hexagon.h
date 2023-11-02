//file name RegularPolygon.h
#ifndef HEXAGON_H
#define HEXAGON_H
#include "Shape.h"
#include <cmath>

class hexagon : public Shape{
    private:
        double _side_length;
    public:
        hexagon(double _side_length);
        std::string name() override;
        double area() override;
};

#endif