/*
 * *****************************************************************************
 *
 * Jan 20, 2018,  ejwint,  Class created...
 * -----------------------------------------------------------------------------
 *   Notes:
 *
 *
 * All Rights Reserved.
 * *****************************************************************************
 */
package com.ejwint.rnd.ui;

import com.ejwint.rnd.WidgetController;
import javafx.fxml.FXML;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;

/**
 * ControlSurfaceGauge,
 *
 * Created: Jan 20, 2018
 *
 * @author ejwint
 * -----------------------------------------------------------------------------
 * Name, Ticket, Date, Info
 * -----------------------------------------------------------------------------
 *
 *
 */
public class ControlSurfaceGauge extends WidgetController {

    @FXML
    Arc Background_Arc;

    @FXML
    Arc Bound_Arc;

    private double max = 35.0;

    public ControlSurfaceGauge() {
        super("control_surface_gauge.fxml");
        draw();
    }

    @Override
    protected void draw() {

        double angle = Background_Arc.getStartAngle();
        double length = Background_Arc.getLength();

        double startX = Background_Arc.getLayoutX();
        double startY = Background_Arc.getLayoutY();

        double degree = (length / (max * 2));

        double minor = (max * 2);

        Rotate rotate;
        double increment = 0.0;
        Line tick;
        for (int i = 0; i <= minor; i++) {

            increment = ((degree * i) - 180.0);
            rotate = new Rotate(increment);
            if (i % 5 == 0) {
                System.out.println(String.format("Degree = %s, Rotation= %s", (degree * i), increment));

                tick = new Line(80, 0, 100, 0);
                tick.setLayoutX(startX);
                tick.setLayoutY(startY);
                tick.getTransforms().add(rotate);
                this.getChildren().add(tick);

                double lx =tick.getStartX();
                double ly =tick.getStartY();
                
                Text text = new Text(Integer.toString((int) Math.abs(i - max)));
                text.setLayoutX(startX);
                text.setLayoutY(startY);
                text.setX(110);
                text.setY(0);
                text.getTransforms().add(rotate);
                this.getChildren().add(text);

            } else {
                tick = new Line(90, 0, 100, 0);
                tick.setLayoutX(startX);
                tick.setLayoutY(startY);
                tick.getTransforms().add(rotate);
                this.getChildren().add(tick);
            }

        }

    }

}
