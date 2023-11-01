#ifndef CIRCLE_H
#define CIRCLE_H
#include "Shape.h"
#include <cmath>
class Circle : public Shape{
    private:
        double _radius;
    public:
        Circle(double _radius);
        std::string name() override;
        double area() override;
};
#endif
