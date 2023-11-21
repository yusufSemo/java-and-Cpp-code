#include "Index.h"
#include <iostream>
#include <sstream>
#include <cctype>

void Index::add_word(Word word, std::string filename, int line) {
    std::string cleaned_word;
    for (char c : word) {
        if (std::isalpha(c)) {
            cleaned_word.push_back(std::tolower(c));
        }
    }
    _index[cleaned_word].emplace(Location(filename, line));
}

std::ostream& operator<<(std::ostream& ost, Index& index) {
    for (const auto& [word, locations] : index._index) {
        ost << word << ": ";
        for (const Location& location : locations) {
            ost << location << ", ";
        }
        ost << std::endl;
    }
    return ost;
}
