CXXFLAGS += --std=c++17

TestTime: TestTime.o Time.o
	$(CXX) $(CXXFLAGS) TestTime.o Time.o -o TestTime

TestTime.o: TestTime.cpp Time.h
	$(CXX) $(CXXFLAGS) -c TestTime.cpp -o TestTime.o

Time.o: Time.cpp Time.h
	$(CXX) $(CXXFLAGS) -c Time.cpp -o Time.o

clean:
	rm -f *.o *.gch *~ a.out testtime

