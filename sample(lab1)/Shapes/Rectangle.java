package sample.Shapes;

import javafx.scene.Group;

public class Rectangle extends Square {
    int b;

    public Rectangle(int x1, int y1, int a, int b) {
        super(x1, y1, a);
        this.b = b;
    }

    @Override
    public void draw(Group ui) {
        new Line(x1, y1, x1 + b, y1).draw(ui);
        new Line(x1 + b, y1, x1 + b, y1 + a).draw(ui);
        new Line(x1 + b, y1 + a, x1, y1 + a).draw(ui);
        new Line(x1, y1 + a, x1, y1).draw(ui);
    }
}
