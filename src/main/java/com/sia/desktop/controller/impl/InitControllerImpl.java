package com.sia.desktop.controller.impl;

import java.io.IOException;

import com.sia.desktop.controller.InitController;
import com.sia.desktop.model.InitModel;
import com.sia.desktop.model.Impl.InitModelImpl;

public class InitControllerImpl implements InitController {

	private InitModel initModel;

	public InitControllerImpl() {
		this.initModel = new InitModelImpl();
	}

	@Override
	public boolean actionEventoButtonSubmit() throws IOException {
		return initModel.submitButtonModel();
	}
}
