#ifndef TIME_H
#define TIME_H
#include <iostream>
class Time {
    private:
        int _hour;
        int _minute;
        int _second;

        void rationalize();

    public:
        Time(int hour = 0, int minute = 0, int second = 0);
        Time operator + (Time time);
        Time& operator++();
        Time operator++(int);
};
#endif
