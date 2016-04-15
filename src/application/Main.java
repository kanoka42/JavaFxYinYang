package application;
	
import java.util.Random;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.EllipseBuilder;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;
import javafx.scene.shape.Shape;


public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ying Yang");
        Group root = new Group();
        Canvas canvas = new Canvas(900, 450);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        
        Ellipse bigCircleOriginal = EllipseBuilder.create()
                .centerX(450)
                .centerY(225)
                .radiusX(107)
                .radiusY(107)
                .strokeWidth(3)
                .stroke(Color.BLACK)
                .build();
        
        
        Ellipse smallCircleWhite = EllipseBuilder.create()
                .centerX(450)
                .centerY(171)
                .radiusX(54)
                .radiusY(54)
                .fill(Color.rgb(random(), random(), random()))
                .build();
        
        Ellipse dotCircleWhite = EllipseBuilder.create()
                .centerX(450)
                .centerY(175)
                .radiusX(10)
                .radiusY(10)
                
                .build();
        
        Ellipse dotCircleBlack = EllipseBuilder.create()
                .centerX(450)
                .centerY(275)
                .radiusX(10)
                .radiusY(10)
                
                .build();

        Ellipse tinyCircleWhite = EllipseBuilder.create()
                .centerX(426)
                .centerY(147)
                .radiusX(26)
                .radiusY(50)
                .rotate(72)
                .fill(Color.rgb(random(), random(), random()))
                .build();
        
        Ellipse bigEllipseWhite = EllipseBuilder.create()
                .centerX(402)
                .centerY(207)
                .radiusX(56)
                .radiusY(80)
                .rotate(20)
                .fill(Color.rgb(random(), random(), random()))
                .build();
        
     
        
        Ellipse bottomEllipseWhite = EllipseBuilder.create()
        		.centerX(404)
                .centerY(283)
                .radiusX(33.8)
                .radiusY(65)
                .rotate(-51.3)
                .fill(Color.rgb(random(), random(), random()))
        		.build();
        
        Ellipse smallCircleBlack = EllipseBuilder.create()
                .centerX(450)
                .centerY(279)
                .radiusX(54)
                .radiusY(54)
               
                .build();
        
        Ellipse bottomEllipseBlack = EllipseBuilder.create()
        		.centerX(497.5)
                .centerY(235)
                .radiusX(50)
                .radiusY(80)
                .rotate(-143.8)
                
        		.build();
        
        
        
        Shape shape = Path.subtract(bigCircleOriginal, smallCircleWhite);
        Shape shape1 = Path.subtract(shape, bigEllipseWhite);
        Shape shape2 = Path.subtract(shape1, tinyCircleWhite);
        Shape shape3 = Path.subtract(shape2, bottomEllipseWhite);
        shape.setFill(Color.rgb(random(), random(), random()));
        shape3.setStrokeWidth(0);
        shape3.setStroke(Color.WHITE);
        
        Shape shapeBlack = Path.intersect(bigCircleOriginal, smallCircleBlack);
        Shape shapeBlack1 = Path.union(shapeBlack, bottomEllipseBlack);
        Shape blackComplete = Path.union(shapeBlack, shape3);
        blackComplete.setStrokeWidth(1);
        blackComplete.setStroke(Color.BLACK);
        
        Shape shapeDotWhite = dotCircleWhite;
        shapeDotWhite.setStrokeWidth(1);
        shapeDotWhite.setStroke(Color.BLACK);
        
        Shape shapeDotBlack = dotCircleBlack;
        shapeDotBlack.setStrokeWidth(1);
        shapeDotBlack.setStroke(Color.WHITE);
        
        

        bigCircleOriginal.setFill(Color.rgb(random(), random(), random()));
        shape3.setFill(Color.rgb(random(), random(), random()));
        blackComplete.setFill(Color.rgb(random(), random(), random()));
        shapeDotWhite.setFill(Color.rgb(0, 0, 0));
        shapeDotBlack.setFill(Color.rgb(255, 255, 255));
        
        root.getChildren().add(bigCircleOriginal);
        root.getChildren().add(shape3);
        root.getChildren().add(blackComplete);
        root.getChildren().add(shapeDotWhite);
        root.getChildren().add(shapeDotBlack);

        
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
	
	public int random(){
		Random randW = new Random();
        int rand = randW.nextInt(255) + 1;
        
        return rand;
	}
}
