package com.sia.desktop.model.Impl;

import java.io.IOException;
import java.util.Map;

import com.sia.desktop.model.HomeModel;
import com.sia.desktop.model.apiconnect.GetConnection;

public class HomeModelImpl implements HomeModel{

	@Override
	public String searchButtonModel(Map<String, String> map) throws IOException {
		
		return new GetConnection()
				.run("http://localhost:8081/search?"
						+ "ordenacion=" + map.get("ORDENACION")
						+ "&producto=" + map.get("PRODUCTO")
						+ "&empresas=" + map.get("EMPRESAS"));
	}
	
}
