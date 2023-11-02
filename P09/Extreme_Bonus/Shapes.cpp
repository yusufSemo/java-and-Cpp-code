#include <iostream>
#include <string>
#include <gtkmm.h>
#include "Circle.h"
#include "hexagon.h"
#include "Shape.h"
class LineDrawingArea : public Gtk::DrawingArea {
public:
    LineDrawingArea() {
        // Connect the drawing callback
        signal_draw().connect(sigc::mem_fun(*this, &LineDrawingArea::on_draw), false);
    }

protected:
    bool on_draw(const Cairo::RefPtr<Cairo::Context>& cr) override {
        cr->set_source_rgb(0.0, 0.0, 0.0);//background color
        // Create a rectangle that covers the entire drawing area
        double width = get_allocated_width();
        double height = get_allocated_height();
        cr->rectangle(0, 0, width, height);
        // Fill the rectangle with the background color
         cr->fill();
        // Set line color and properties
        cr->set_source_rgb(1.0, 0.5, 0.0);  // Black color
        cr->set_line_width(2.0);

        // Draw the line from (x1, y1) to (x2, y2)
        double x1 = 50.0;
        double y1 = 50.0;
        double x2 = 200.0;
        double y2 = 100.0;

        cr->move_to(x1, y1);
        cr->line_to(x2, y2);
        cr->stroke();

        return true;
    }
};
int main(int argc,char* argv[]){
    auto app =
    Gtk::Application::create(argc, argv,
      "org.gtkmm.examples.base");

  Gtk::Window window;
  window.set_default_size(420, 420);
LineDrawingArea drawing_area;
    window.add(drawing_area);

    window.show_all();
  return app->run(window);


   
    std::vector<Shape*> shapes;
    hexagon pol(6.0);
    Circle cir(6.0);
    Circle cir2(99.0);
    shapes.push_back(&pol);
    shapes.push_back(&cir);
    shapes.push_back(&cir2);
    for (Shape* shape : shapes) {
        std::cout << shape->to_string() << std::endl;
    }
    return 0;
}
