#ifndef INDEX_H
#define INDEX_H

#include <map>
#include <set>
#include <string>
#include "Location.h"
typedef std::set<Location> Locations;
typedef std::string Word;

class Index {
private:
    std::map<Word, Locations> _index;

public:
    void add_word(Word word, std::string filename, int line);
    friend std::ostream& operator<<(std::ostream& ost, Index& index);
};

#endif
