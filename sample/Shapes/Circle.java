package sample.Shapes;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;

public class Circle implements Figure {
    int x, y, r;

    public Circle() {
    }

    public Circle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    @Override
    public void draw(Group ui) {
        javafx.scene.shape.Circle ellipse = new javafx.scene.shape.Circle(x, y, r);
        ellipse.setFill(Color.TRANSPARENT);
        ellipse.setStrokeWidth(1);
        ellipse.setStroke(Color.BLACK);
        ellipse.setStrokeType(StrokeType.INSIDE);
        ui.getChildren().add(ellipse);
    }
}
