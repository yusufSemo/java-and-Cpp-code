#include "Index.h"
#include <iostream>
#include <fstream>
#include <sstream>


int main(int argc, char* argv[]) {
    if (argc < 2) {
        std::cerr << "file error" << std::endl;
        return 1;
    }

    Index index;
    std::cout<<"Index\n=====\n\n";
    //go thorugh each file
    for (int i = 1; i < argc; ++i) {
        std::ifstream file(argv[i]);
        if (!file.is_open()) {
            std::cerr << "error opening file: " << argv[i] << std::endl;
            continue;
        }

        std::string line;
        int lineNum = 1;

        while (std::getline(file, line)) {
            std::istringstream StringStream(line);
            std::string word;

            while (StringStream >> word) {
                std::string cleanedWord;
                for (char c : word) {
                    if (std::isalpha(c)) {
                        cleanedWord.push_back(std::tolower(c));
                    }
                }
                index.add_word(cleanedWord, argv[i], lineNum);
            }

            ++lineNum;
        }
    }
    std::cout << index;

    return 0;
}
