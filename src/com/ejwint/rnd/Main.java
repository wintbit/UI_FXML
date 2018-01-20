package com.ejwint.rnd;

import com.ejwint.rnd.ui.Gauge;
import com.ejwint.rnd.ui.Gauge.GaugeTypeEnum;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Main, * Created: Jan 19, 2018
 *
 * @author ejwint
 * -----------------------------------------------------------------------------
 * Name, Ticket, Date, Info
 * -----------------------------------------------------------------------------
 *
 *
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        TabPane tabpane = new TabPane();

        addTab(tabpane, "Gauge: VERTICAL", new Gauge(100, 5, GaugeTypeEnum.VERTICAL));
        addTab(tabpane, "Gauge: VERTICAL_SPLIT", new Gauge(35, 5, GaugeTypeEnum.VERTICAL_SPLIT));

        addTab(tabpane, "Gauge: HORIZONTAL", new Gauge(35, 5, GaugeTypeEnum.HORIZONTAL));
        
        Scene scene = new Scene(tabpane, 500, 500);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public static void addTab(TabPane tabpane, String title, Node node) {
        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        box.getChildren().add(node);
        Tab tab = new Tab();
        tab.setText(title);
        tab.setContent(box);
        tabpane.getTabs().add(tab);
    }

}
