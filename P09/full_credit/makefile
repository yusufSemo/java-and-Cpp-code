CXXFLAGS += --std=c++17
shapes: Shapes.o Shape.o Circle.o RegularPolygon.o *.h
	$(CXX) $(CXXFLAGS) Shapes.o Shape.o Circle.o RegularPolygon.o -o shapes
Circle.o: Circle.cpp *.h
	$(CXX) $(CXXFLAGS) -c Circle.cpp -o Circle.o
RegularPolygon.o: RegularPolygon.cpp *.h
	$(CXX) $(CXXFLAGS) -c RegularPolygon.cpp -o RegularPolygon.o
Shape.o: Shape.cpp *.h
	$(CXX) $(CXXFLAGS) -c Shape.cpp -o Shape.o
Shapes.o: Shapes.cpp *.h
	$(CXX) $(CXXFLAGS) -c Shapes.cpp -o Shapes.o
clean:
	rm -f *.o *.gch *~ a.out shapes
