#include "Time.h"


Time::Time(int hour, int minute, int second) : 
_hour{hour}, _minute{minute},_second{second}{
    rationalize();
}
Time Time::operator +(Time time) {
    Time result;
    result._hour = _hour + time._hour;
    result._minute = _minute + time._minute;
    result._second = _second + time._second;
    result.rationalize();
    //std::cout<<"hour  sdffsd"<<result._hour << " min " << result._minute << " sec "<< result._second<<std::endl;
    return result;
}

Time& Time::operator++(){
    _second++;
    rationalize();
    return *this;
}
Time Time::operator++(int) {
    Time temp = *this;
    ++(*this);
    return temp;
}
bool Time::operator==(Time& time){
    return (_hour == time._hour) && (_minute == time._minute) && (_second == time._second);
}

bool Time::operator!=(Time& time){
    return !(*this == time);
}

bool Time::operator<=(Time& time){
    return (*this < time) || (*this == time);
}

bool Time::operator>=(Time& time){
    return (*this > time) || (*this == time);
}

bool Time::operator>(Time& time) {
    return (_hour > time._hour) || ((_hour == time._hour) && ((_minute > time._minute) || ((_minute == time._minute) && (_second > time._second))));
}

bool Time::operator<( Time& time) {
    return (_hour < time._hour) || ((_hour == time._hour) && ((_minute < time._minute) || ((_minute == time._minute) && (_second < time._second))));
}


void Time::rationalize(){
    //seconds approach
    //1hour = 3600 seconds , 1 min 60 seconds
    int total_time = ((_hour * 3600)+ (_minute * 60) + _second);
    if(total_time > 86399){
       int mult = total_time/86400;
        total_time-=(mult* 86400);
    }
    _hour = total_time/3600;
        int remainder = total_time % 3600;
        _minute = remainder/60;
        _second = remainder%60;
        //std::cout<<"hour "<<_hour << " min " << _minute << " sec "<< _second<<std::endl;
}
std::ostream& operator<<(std::ostream& os, const Time& time) {
    os << std::setfill('0') << std::setw(2) << time._hour << ":"
       << std::setw(2) << time._minute << ":" << std::setw(2) << time._second;
    return os;
}

// Implementation of the streaming in operator (>>)
std::istream& operator>>(std::istream& is, Time& time) {
    char separator1, separator2;
    is >> std::setw(2) >> time._hour >> separator1
       >> std::setw(2) >> time._minute >> separator2
       >> std::setw(2) >> time._second;

    if (separator1 != ':' || separator2 != ':') {
        is.setstate(std::ios::failbit);
    }

    return is;
}
