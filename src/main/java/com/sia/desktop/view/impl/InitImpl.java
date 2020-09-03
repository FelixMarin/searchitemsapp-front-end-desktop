package com.sia.desktop.view.impl;

import java.io.IOException;

import com.sia.desktop.view.Init;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class InitImpl implements Init {
	
	@Override
	public Scene createPage() throws IOException {

		BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/fxml/init.fxml"));
		Scene scene = new Scene(root, 1024, 680);
		scene.getStylesheets().add(getClass().getResource("/css/init.css").toExternalForm());

		return scene;
	}
}
