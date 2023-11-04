#include <iostream>
#include <string>
#include <gtkmm.h>
#include "Circle.h"
#include "hexagon.h"
#include "Shape.h"

class CircleDrawingArea : public Gtk::DrawingArea {
private:
    double _radius;

public:
    CircleDrawingArea(double radius) : _radius{radius} {
        // Connect the drawing callback
        signal_draw().connect(sigc::mem_fun(*this, &CircleDrawingArea::on_draw), false);
    }

protected:
    bool on_draw(const Cairo::RefPtr<Cairo::Context>& cr) override {
        // Set the color for the circle's outline
        cr->set_source_rgb(1.0, 0.5, 0.0);  // Orange color (R=1.0, G=0.5, B=0.0)

        // Set the line width for the outline
        cr->set_line_width(2.0);

        // Calculate the circle's center and radius
        double center_x = get_allocated_width() / 2.0;
        double center_y = get_allocated_height() / 2.0;
        double radius = std::min(center_x, center_y) * 0.2;
        cr->arc(center_x, center_y, _radius, 0.0, 2.0 * M_PI);
        cr->stroke();

        return true;
    }
};

int main(int argc, char* argv[]) {
    std::vector<Shape*> shapes;
    double cir1Radious = 100;
    hexagon pol(6.0);
    Circle cir(cir1Radious);
    Circle cir2(99.0);
    shapes.push_back(&pol);
    shapes.push_back(&cir);
    shapes.push_back(&cir2);
    for (Shape* shape : shapes) {
        std::cout << shape->to_string() << std::endl;
    }
    auto app = Gtk::Application::create(argc, argv, "org.gtkmm.examples.base");

    Gtk::Window window;
    window.set_default_size(420, 420);

    Gtk::Box vbox(Gtk::ORIENTATION_VERTICAL); // Vertical box

    CircleDrawingArea drawing_area(cir1Radious);

    vbox.pack_start(drawing_area);
    window.add(vbox);

    window.show_all();

    return app->run(window);
}
