package com.sia.desktop.view;

import java.io.IOException;

import javafx.scene.Scene;

public interface Init {
	abstract Scene createPage() throws IOException;
}