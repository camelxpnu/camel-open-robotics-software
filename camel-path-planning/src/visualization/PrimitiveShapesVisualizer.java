package visualization;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class PrimitiveShapesVisualizer extends Application
{
	private static final int WIDTH = 1400;
	private static final int HEIGHT = 1000;

	private double anchorX, anchorY;
	private double anchorAngleX = 0;
	private double anchorAngleY = 0;
	private final DoubleProperty angleX = new SimpleDoubleProperty(0);
	private final DoubleProperty angleY = new SimpleDoubleProperty(0);

	@Override
	public void start(Stage primaryStage)
	{
		Box box = new Box(100, 20, 50);

		Group group = new Group();
		group.getChildren().add(box);

		Camera camera = new PerspectiveCamera();
		Scene scene = new Scene(group, WIDTH, HEIGHT);
		scene.setFill(Color.SILVER);
		scene.setCamera(camera);

		group.translateXProperty().set(WIDTH / 2);
		group.translateYProperty().set(HEIGHT / 2);
		group.translateZProperty().set(-1500);

		initMouseControl(group, scene);

		primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event ->
		{
			switch (event.getCode())
			{
			case W:
				group.translateZProperty().set(group.getTranslateZ() + 100);
				break;
			case S:
				group.translateZProperty().set(group.getTranslateZ() - 100);
				break;
			case A:
				group.translateXProperty().set(group.getTranslateX() + 10);
				break;
			case D:
				group.translateXProperty().set(group.getTranslateX() - 10);
				break;
			}
		});

		primaryStage.setTitle("PrimitiveShapesVisualizer");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void initMouseControl(Group group, Scene scene)
	{
		Rotate xRotate;
		Rotate yRotate;
		group.getTransforms().addAll(xRotate = new Rotate(0, Rotate.X_AXIS), yRotate = new Rotate(0, Rotate.Y_AXIS));
		xRotate.angleProperty().bind(angleX);
		yRotate.angleProperty().bind(angleY);

		scene.setOnMousePressed(event ->
		{
			anchorX = event.getSceneX();
			anchorY = event.getSceneY();
			anchorAngleX = angleX.get();
			anchorAngleY = angleY.get();
		});

		scene.setOnMouseDragged(event ->
		{
			angleX.set(anchorAngleX - (anchorY - event.getSceneY()));
			angleY.set(anchorAngleY + anchorX - event.getSceneX());
		});
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
