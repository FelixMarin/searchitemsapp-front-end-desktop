package com.sia.desktop;
	
import com.sia.desktop.view.Init;
import com.sia.desktop.view.impl.InitImpl;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {

			Init init = new InitImpl();
			Scene scene = init.createPage();
			
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
