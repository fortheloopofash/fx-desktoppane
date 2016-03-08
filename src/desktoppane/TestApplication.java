package desktoppane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TestApplication extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		StackPane desktopPane = new StackPane();
		desktopPane.getChildren().addAll(new FXInternalFrame("Frame 1"),
				new FXInternalFrame("Frame 2"));

		Scene scene = new Scene(desktopPane, 400, 400);
		primaryStage.setTitle("FX Desktop Pane Test");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
