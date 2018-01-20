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
package com.ejwint.rnd;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

/**
 * WidgetController,
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
public abstract class WidgetController extends Pane {

    private FXMLLoader fxmlLoader;

    public WidgetController(String fileName) {
        fxmlLoader = new FXMLLoader(getClass().getResource(
                fileName));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    protected abstract void draw();

}
