package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Canvas canvas;
    public Slider speed;
    public Slider degrees;
    public Slider screenWide;
    Timeline timeline = new Timeline();
    Position[] positions = new Position[2400];

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        GraphicsContext gc = canvas.getGraphicsContext2D();



        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(0.1), (ActionEvent event) -> {
            Missile.wideScreen = screenWide.getValue();
            for (int i = 0; i < 2400; i++) {
                positions[i] = Missile.calcPosition(speed.getValue(),degrees.getValue(),i/24.0);
            }
            drawShape(gc);
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void drawShape(GraphicsContext gc){
        gc.setFill(Color.DARKSALMON);
        gc.fillRect(0,0,600,400);
        gc.setFill(Color.PERU);
        for (int i = 0, positionsLength = positions.length; i < positionsLength; i++) {
            gc.fillRect(positions[i].getX(), positions[i].getY(), 10, 10);
        }
    }
}
