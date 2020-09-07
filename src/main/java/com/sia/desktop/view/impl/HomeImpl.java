package com.sia.desktop.view.impl;

import java.io.IOException;

import com.sia.desktop.view.Home;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class HomeImpl implements Home {

	@Override
	public Scene ceatePage()  throws IOException {
		
		BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/fxml/home.fxml"));
		Scene scene = new Scene(root, 1024, 720);
		scene.getStylesheets().add(getClass().getResource("/css/home.css").toExternalForm());
		
		return scene;
	}

}
