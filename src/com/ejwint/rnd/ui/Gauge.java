/*
 * *****************************************************************************
 *
 * Jan 19, 2018,  ejwint,  Class created...
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
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * Gauge,
 *
 * Created: Jan 19, 2018
 *
 * @author ejwint
 * -----------------------------------------------------------------------------
 * Name, Ticket, Date, Info
 * -----------------------------------------------------------------------------
 *
 *
 */
public class Gauge extends WidgetController {

    private final double maximum;
    private double minorTickCount;
    private final double majorTickCount;
    private final GaugeTypeEnum gaugeType;

    public enum GaugeTypeEnum {
        VERTICAL(0),
        VERTICAL_SPLIT(1),
        HORIZONTAL(2);

        private final int value;

        private GaugeTypeEnum(int value) {
            this.value = value;
        }

    }

    @FXML
    private Rectangle Gauge_Background;

    public Gauge(double max, double value, GaugeTypeEnum gaugeType) {
        super("gauge.fxml");
        this.maximum = max;
        this.majorTickCount = (max / 5) + 1;

        this.gaugeType = gaugeType;
        switch (gaugeType) {
            case VERTICAL:
            case HORIZONTAL:

                this.minorTickCount = max;
                break;
            case VERTICAL_SPLIT:
                this.minorTickCount = max * 2;
                break;
            default:
                break;
        }

        draw();
    }

    @Override
    protected void draw() {

        Gauge_Background.setHeight(400);

        double height = Gauge_Background.getHeight();
        double width = Gauge_Background.getWidth();

        double inc = 0.0;

        switch (this.gaugeType) {
            case VERTICAL:
            case VERTICAL_SPLIT:
                inc = (height / minorTickCount);
                break;
            case HORIZONTAL:
                inc = (width / minorTickCount);
                break;
        }

        double lx = Gauge_Background.getLayoutX();
        double ly = Gauge_Background.getLayoutY();
        Line line;
        Text text;

        for (int i = 0; i <= minorTickCount; i++) {
            if (i % 5 == 0) {

                switch (this.gaugeType) {

                    case VERTICAL:
                        line = new Line(0, inc * i, 25, inc * i);
                        line.setStroke(Color.BLACK);
                        line.setLayoutX(lx);
                        line.setLayoutY(ly);
                        this.getChildren().add(line);

                        text = new Text(Integer.toString((int) this.maximum - i));
                        text.setX(26);
                        text.setY((inc * i) + (text.getLayoutBounds().getHeight() / 2.5));
                        text.setLayoutX(lx);
                        text.setLayoutY(ly);
                        this.getChildren().add(text);

                        break;
                    case VERTICAL_SPLIT:
                        line = new Line(0, inc * i, 25, inc * i);
                        line.setStroke(Color.BLACK);
                        line.setLayoutX(lx);
                        line.setLayoutY(ly);
                        this.getChildren().add(line);

                        //text
                        text = new Text(Integer.toString((int) Math.abs(i - maximum)));
                        text.setX(26);
                        text.setY((inc * i) + (text.getLayoutBounds().getHeight() / 2.5));
                        text.setLayoutX(lx);
                        text.setLayoutY(ly);
                        this.getChildren().add(text);

                        break;
                    case HORIZONTAL:

                        line = new Line(inc * i, 0, inc * i, 25);
                        line.setStroke(Color.BLACK);
                        line.setLayoutX(lx);
                        line.setLayoutY(ly);
                        this.getChildren().add(line);

                        text = new Text(Integer.toString((int) (i)));
                        text.setX((inc * i) - (text.getLayoutBounds().getWidth() / 2));
                        text.setY(40 + (text.getLayoutBounds().getHeight() / 2.5));
                        text.setLayoutX(lx);
                        text.setLayoutY(ly);
                        this.getChildren().add(text);

                        break;
                }

            } else {

                switch (this.gaugeType) {
                    case VERTICAL:
                    case VERTICAL_SPLIT:
                        line = new Line(0, inc * i, 10, inc * i);
                        line.setStroke(Color.BLACK);
                        line.setLayoutX(lx);
                        line.setLayoutY(ly);
                        this.getChildren().add(line);

                        break;
                    case HORIZONTAL:

                        line = new Line(inc * i, 0, inc * i, 10);
                        line.setStroke(Color.BLACK);
                        line.setLayoutX(lx);
                        line.setLayoutY(ly);
                        this.getChildren().add(line);

                        break;
                }

            }

        }
    }

}
