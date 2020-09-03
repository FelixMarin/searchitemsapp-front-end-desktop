package com.sia.desktop.controller.impl;

import com.sia.desktop.controller.InitController;
import com.sia.desktop.model.InitModel;
import com.sia.desktop.model.Impl.InitModelImpl;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class InitControllerImpl implements InitController {

	@FXML
	private Button submitButton;
	
	@FXML
	private TextField nameField;
	
	@FXML
	private TextField passField;

	private InitModel initModel;

	public InitControllerImpl() {
		this.submitButton = new Button();
		this.nameField = new TextField();
		this.passField = new TextField();
		this.initModel = new InitModelImpl();
	}

	@Override
	public void actionEventoButtonSubmit() {

		submitButton.setOnAction(e -> {
			boolean validated = validate(nameField.getText(), passField.getText());
			if (validated) {
				System.out.println("validated");
			}
		});
	}

	private boolean validate(String strNameText, String strPassText) {
		return (strNameText != null && !strNameText.isEmpty()) && 
				(strPassText != null && !strPassText.isEmpty());
	}
}
