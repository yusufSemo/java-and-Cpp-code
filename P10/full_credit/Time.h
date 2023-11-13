#ifndef TIME_H
#define TIME_H
#include <iostream>
#include <iomanip>
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
        bool operator==(Time& time);
        bool operator!=( Time& time);
        bool operator>=( Time& time);
        bool operator<=( Time& time);
        bool operator>( Time& time);
        bool operator<( Time& time);
        friend std::ostream& operator<<(std::ostream& os, const Time& time);
        friend std::istream& operator>>(std::istream& is, Time& time);

};
#endif
