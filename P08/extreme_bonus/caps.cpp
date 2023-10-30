#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

//function that sorts by length
//& so we dont make copys of the string, more efficient
bool sort_by_length(const std::string& a, const std::string& b)
{
    return a.length() < b.length();
}

int main(int argc, char **argv)
{
    //argc number of arguments
    //65-90 A-Z ascii
    //97-122 a-z ascii
    std::vector<std::string> caps;
    std::vector<std::string>* no_caps = new std::vector<std::string>;

    for(int i = 1;i<argc;i++)
    {
        if(argv[i][0]>=65 && argv[i][0]<=90)
        {
            caps.push_back(argv[i]);
        }

        if(argv[i][0]>=97 && argv[i][0]<=122)
        {
            no_caps->push_back(argv[i]);
        }
    }
    std::sort(caps.begin(), caps.end());
    std::sort(no_caps->begin(), no_caps->end(),sort_by_length);//passing a function as an argument

    std::cout<< "Capitalized:"<<std::endl;
    for (std::string e : caps) {
        std::cout << e <<std::endl;
    }
    std::cout << std::endl;

    std::cout<< "Lower Case:"<<std::endl;
    for (std::string e : *no_caps) {
        std::cout << e <<std::endl;
    }
    std::cout << std::endl;

    delete no_caps;

    return 0;
}