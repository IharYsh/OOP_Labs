package sample.Shapes;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;

public class Ellipse extends Circle {
    int r1, r2;

    public Ellipse(int x, int y, int r1, int r2) {
        this.x = x;
        this.y = y;
        this.r1 = r1;
        this.r2 = r2;
    }

    @Override
    public void draw(Group ui) {
        javafx.scene.shape.Ellipse ellipse = new javafx.scene.shape.Ellipse(x, y, r1, r2);
        ellipse.setFill(Color.TRANSPARENT);
        ellipse.setStrokeWidth(1);
        ellipse.setStroke(Color.BLACK);
        ellipse.setStrokeType(StrokeType.INSIDE);
        ui.getChildren().add(ellipse);
    }
}
