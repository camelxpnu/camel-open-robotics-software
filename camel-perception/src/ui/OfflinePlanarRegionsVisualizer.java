package ui;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;
import printTools.PrintTools;
import ui.controller.PlanarRegionsBrowserAnchorPaneController;

public class OfflinePlanarRegionsVisualizer extends Application
{
	private static final int WIDTH = 1400;
	private static final int HEIGHT = 1000;

	@FXML
	PlanarRegionsBrowserAnchorPaneController planarRegionsBrowserAnchorPaneController;

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setController(this);
		loader.setLocation(getClass().getResource("\\OfflinePlanarRegionsVisualizer" + ".fxml"));

		BorderPane mainPane = loader.load();

//		Box box = new Box(100, 20, 50);
//
//		SmartGroup group = new SmartGroup();
//		group.getChildren().add(box);
//
//		Camera camera = new PerspectiveCamera();
//		Scene scene = new Scene(group, WIDTH, HEIGHT);
//		scene.setFill(Color.SILVER);
//		scene.setCamera(camera);
//
//		group.translateXProperty().set(WIDTH / 2);
//		group.translateYProperty().set(HEIGHT / 2);
//		group.translateZProperty().set(-1500);

		// TODO: in order to add graphic nodes which are came from the shared memory.
//		planarRegionsBrowserAnchorPaneController.init(primaryStage);

		mainPane.setCenter(planarRegionsBrowserAnchorPaneController);
		primaryStage.setTitle(getClass().getSimpleName());
		primaryStage.setMaximized(false);
		Scene mainScene = new Scene(mainPane, 1350, 900);

		primaryStage.setScene(mainScene);
		primaryStage.show();
	}

	public static void main(String[] args)
	{
		launch(args);
	}

	class SmartGroup extends Group
	{
		Rotate r;
		Transform t = new Rotate();

		void rotateByX(int ang)
		{
			r = new Rotate(ang, Rotate.X_AXIS);
			t = t.createConcatenation(r);
			this.getTransforms().clear();
			this.getTransforms().addAll(t);
		}

		void rotateByY(int ang)
		{
			r = new Rotate(ang, Rotate.Y_AXIS);
			t = t.createConcatenation(r);
			this.getTransforms().clear();
			this.getTransforms().addAll(t);
		}
	}
}
