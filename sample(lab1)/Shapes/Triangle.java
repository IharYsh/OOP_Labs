package sample.Shapes;

import javafx.scene.Group;

public class Triangle implements Figure {
    int x1, y1, x2, y2, x3, y3;
    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    @Override
    public void draw(Group ui) {
            new Line(x1, y1, x2, y2).draw(ui);
            new Line(x2, y2, x3, y3).draw(ui);
            new Line(x3, y3, x1, y1).draw(ui);
        }

}

