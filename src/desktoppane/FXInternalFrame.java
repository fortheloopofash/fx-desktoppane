package desktoppane;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FXInternalFrame extends Group {

	private Delta origPosDelta = new Delta();
	private Delta translatePosDelta = new Delta();

	public FXInternalFrame(String title) {
		initContent(title);
		addMouseEvents();
	}

	void initContent(String title) {
		HBox titleBar = new HBox();
		Button minButton = new Button("m");
		Button maxButton = new Button("M");
		Button closeButton = new Button("X");
		titleBar.getChildren().addAll(new Label(title), minButton, maxButton,
				closeButton);
		titleBar.setAlignment(Pos.CENTER_RIGHT);
		titleBar.setStyle("-fx-border-color: red;");

		TextField textField = new TextField();
		DatePicker datePicker = new DatePicker();
		ChoiceBox<String> choiceBox = new ChoiceBox<>();
		choiceBox.getItems().addAll("Option 1", "Option 2");
		VBox content = new VBox(textField, datePicker, choiceBox);
		content.setPadding(new Insets(20));
		content.setSpacing(10);
		content.setStyle("-fx-border-color: blue;");

		BorderPane internalFrame = new BorderPane(content);
		internalFrame.setTop(titleBar);
		internalFrame.setStyle("-fx-border-color: green;");
		getChildren().add(internalFrame);
	}

	private void addMouseEvents() {
		setOnMousePressed(event -> {
			origPosDelta.x = event.getSceneX();
			origPosDelta.y = event.getSceneY();
			translatePosDelta.x = ((Group)event.getSource()).getTranslateX();
			translatePosDelta.y = ((Group)event.getSource()).getTranslateY();
		});

		setOnMouseDragged(event -> {
			double offsetX = event.getSceneX() - origPosDelta.x;
			double offsetY = event.getSceneY() - origPosDelta.y;
			double newTranslateX = translatePosDelta.x + offsetX;
			double newTranslateY = translatePosDelta.y + offsetY;

			setTranslateX(newTranslateX);
			setTranslateY(newTranslateY);
		});
	}

	// ******************** Inner Class ******************** //

	private class Delta {
		double x;
		double y;
	}

}
