package com.sia.desktop;
	
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.sia.desktop.controller.HomeController;
import com.sia.desktop.controller.InitController;
import com.sia.desktop.controller.impl.HomeControllerImpl;
import com.sia.desktop.controller.impl.InitControllerImpl;
import com.sia.desktop.view.Home;
import com.sia.desktop.view.Init;
import com.sia.desktop.view.impl.HomeImpl;
import com.sia.desktop.view.impl.InitImpl;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {
	
	@FXML
	private Button submitButton;
	
	@FXML
	private TextField nameField;
	
	@FXML
	private TextField passField;
	
	@FXML
	private Button searchButton;
	
	@FXML
	private Button cleanButton;
	
	@FXML 
	private TextField seachTextField;
	
	@FXML
	private ComboBox<String> comboBox;
	
	@FXML
	private CheckBox alcampo;
	
	@FXML
	private CheckBox caprabo;
	
	@FXML
	private CheckBox carrefour;
	
	@FXML
	private CheckBox condis;
	
	@FXML
	private CheckBox consum;
	
	@FXML
	private CheckBox dia;
	
	@FXML
	private CheckBox eci;
	
	@FXML
	private CheckBox eroski;
	
	@FXML
	private CheckBox lidl;
	
	@FXML
	private CheckBox mercadona;
	
	
	private InitController initController;
	
	private HomeController homeController;
	
	private static Stage primaryStage;
	
	public Main() {
		initController = new InitControllerImpl();
		homeController = new HomeControllerImpl();	
		submitButton = new Button();
		nameField = new TextField();
		passField = new TextField();
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {

			Init init = new InitImpl();
			Scene scene = init.createPage();
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Price Rank");
			primaryStage.initStyle(StageStyle.UTILITY);
			primaryStage.centerOnScreen();
			//primaryStage.initModality(Modality.NONE);
			setPrimaryStage(primaryStage);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	//Controller Calls
	
	public void initControllerLogin() {
		
		submitButton.setOnAction(e -> {

			if ((nameField != null && !nameField.getText().isEmpty()) && 
				(passField != null && !passField.getText().isEmpty())) {
				
				try {

					initController.actionEventoButtonSubmit(); //Eliminar. Pruebas
					
					if(true /*initController.actionEventoButtonSubmit()*/) {
						System.out.println(primaryStage.getTitle());
						
						Home home = new HomeImpl();
						primaryStage.setScene(home.ceatePage());
						
					}
					
				} catch (IOException e1) {
					System.out.println(e1.getMessage());
				}
				
			}
		});
	}
	
	public void homeControllerSearchButton() {
		
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
		    
			String strProductos = "";
			Map<String, String> arguments = new HashMap<>();
			arguments.put("PRODUCTO", seachTextField.getText());
			
			if("Precio".equals(comboBox.getValue())) {
				arguments.put("ORDENACION", "1");
			} else if("Precio/Kilo".equals(comboBox.getValue())) {
				arguments.put("ORDENACION", "2");
			} else {
				arguments.put("ORDENACION", "1");
			}
			
			
			String strEmpresas = alcampo.isSelected()?"108,":"";
			strEmpresas += caprabo.isSelected()?"109,":"";
			strEmpresas += carrefour.isSelected()?"104,":"";
			strEmpresas += condis.isSelected()?"110,":"";
			strEmpresas += consum.isSelected()?"116,":"";
			strEmpresas += dia.isSelected()?"105,":"";
			strEmpresas += eci.isSelected()?"111,":"";
			strEmpresas += eroski.isSelected()?"107,":"";
			strEmpresas += lidl.isSelected()?"102,":"";
			strEmpresas += mercadona.isSelected()?"101,":"";
			strEmpresas += strEmpresas.substring(0, strEmpresas.length()-1);
			
			arguments.put("EMPRESAS", strEmpresas);
			
		    try {
				strProductos = homeController.actionEventHomeSearchButton(arguments); 
				System.out.println(strProductos);
			} catch (IOException e) {
				e.printStackTrace();
			}
		    
		    return strProductos;
		});
		
		try {
			String result = future.get();
			
			if("".equals(result)) {

				
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	public void homeControllerCleanButton() {
		
	}

	public void setPrimaryStage(Stage primaryStage) {
		Main.primaryStage = primaryStage;
	}
}
