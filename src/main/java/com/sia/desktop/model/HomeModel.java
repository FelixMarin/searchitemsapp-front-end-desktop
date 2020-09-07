package com.sia.desktop.model;

import java.io.IOException;
import java.util.Map;

public interface HomeModel {
	abstract String searchButtonModel(Map<String,String> map)  throws IOException;
}
