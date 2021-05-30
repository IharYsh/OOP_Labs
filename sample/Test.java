package sample;

import javafx.scene.Group;
import sample.Shapes.*;

import java.util.ArrayList;

public class Test {
    public Test(Group ui) {
        ArrayList<Figure> figures = new ArrayList<>();
        figures.add(new Rectangle(50, 20, 150, 70));
        figures.add(new Square(40, 50, 40));
        figures.add(new Triangle(10, 50, 20, 60, 5, 10));
        figures.add(new Ellipse(40, 60, 30, 80));
        figures.add(new Circle(90, 160, 30));
        figures.add(new Line(90, 160, 30, 60));
        for (Figure figure : figures) {
            figure.draw(ui);
        }
    }
}
