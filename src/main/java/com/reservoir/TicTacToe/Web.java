package com.reservoir.TicTacToe;

import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

/**
* Implementation of TicTacToe web server (main)
**/
public class Web {

    public static void main(String[] args) {
        //port(getHerokuAssignedPort());
        staticFileLocation("/webapp");
        get("/hello", (request, response) -> "Hello world");
        get("/startgame", (request, response) -> new WebService().startGame(request, response));
	/*
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }*/
}
}
