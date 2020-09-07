package com.sia.desktop.controller.impl;

import java.io.IOException;
import java.util.Map;

import com.sia.desktop.controller.HomeController;
import com.sia.desktop.model.HomeModel;
import com.sia.desktop.model.Impl.HomeModelImpl;

public class HomeControllerImpl implements HomeController {
	
	private HomeModel homeModel;
	
	public HomeControllerImpl() {
		homeModel = new HomeModelImpl();
	}

	@Override
	public String actionEventHomeSearchButton(Map<String, String> map) throws IOException {
		return homeModel.searchButtonModel(map);
	}
}
