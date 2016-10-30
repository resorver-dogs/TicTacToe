package com.reservoir.TicTacToe;

import spark.Request;
import spark.Response;

public class WebService {
	public Object startGame(Request req, Response res) {
		Object obj = new Object();
		try {
			
			WebGame game = new WebGame();
			return obj;
		} catch (Exception e) {
			return "Error creating new game";
		}
	}
}