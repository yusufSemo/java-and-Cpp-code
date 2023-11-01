#include <iostream>
#include<string>
class Shape{
    public:
    virtual std::string name();
    virtual double area();
    std::string to_string();
};