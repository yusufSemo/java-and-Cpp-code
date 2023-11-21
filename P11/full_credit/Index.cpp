#include "Index.h"
#include <iostream>
#include <sstream>
#include <cctype>

void Index::add_word(Word word, std::string filename, int line) {
    // Cleanup word by removing punctuation and making it lowercase
    std::string cleaned_word;
    for (char c : word) {
        if (std::isalpha(c)) {
            cleaned_word.push_back(std::tolower(c));
        }
    }

    // Add the cleaned word to the index
    _index[cleaned_word].emplace(Location(filename, line));
}

