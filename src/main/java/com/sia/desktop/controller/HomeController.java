package com.sia.desktop.controller;

import java.io.IOException;
import java.util.Map;

public interface HomeController {
	abstract String actionEventHomeSearchButton(Map<String,String> map)throws IOException;
}
