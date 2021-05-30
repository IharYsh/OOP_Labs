package sample.Shapes;

import javafx.scene.Group;

public class Line implements Figure {
    int x, y, x1, y1;
    public Line(int x, int y, int x1, int y1){
        this.x = x;
        this.y = y;
        this.x1 = x1;
        this.y1 = y1;
    }

    @Override
    public void draw(Group ui) {
        javafx.scene.shape.Line line = new javafx.scene.shape.Line(x, y, x1, y1);
        ui.getChildren().add(line);
    }
}
