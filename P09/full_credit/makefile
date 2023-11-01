CXXFLAGS += --std=c++17
shapes: Shapes.o Shape.o Circle.o hexagon.o *.h
	$(CXX) $(CXXFLAGS) Shapes.o Shape.o Circle.o hexagon.o -o shapes
Circle.o: Circle.cpp *.h
	$(CXX) $(CXXFLAGS) -c Circle.cpp -o Circle.o
hexagon.o: hexagon.cpp *.h
	$(CXX) $(CXXFLAGS) -c hexagon.cpp -o hexagon.o
Shape.o: Shape.cpp *.h
	$(CXX) $(CXXFLAGS) -c Shape.cpp -o Shape.o
Shapes.o: Shapes.cpp *.h
	$(CXX) $(CXXFLAGS) -c Shapes.cpp -o Shapes.o
clean:
	rm -f *.o *.gch *~ a.out shapes

