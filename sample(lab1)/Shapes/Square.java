package sample.Shapes;

import javafx.scene.Group;

public class Square implements Figure {
    int x1, y1, a;

    public Square(int x1, int y1, int a) {
        this.x1 = x1;
        this.y1 = y1;
        this.a = a;

    }

    @Override
    public void draw(Group ui) {
        new Line(x1, y1, x1 + a, y1).draw(ui);
        new Line(x1 + a, y1, x1 + a, y1 + a).draw(ui);
        new Line(x1 + a, y1 + a, x1, y1 + a).draw(ui);
        new Line(x1, y1 + a, x1, y1).draw(ui);
    }
}
