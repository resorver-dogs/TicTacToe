package com.reservoir.TicTacToe;

import static spark.Spark.*;

/**
* Implementation of TicTacToe web server (main)
**/
public class Web {

    /**
    * Main initializer for Spark Framework that grants HTTP access to TicTacToe
    *
    * @param args String array - Not used
    */
    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        get("/hello", (req, res) -> "Hello Heroku World");
    }

    /**
    * Checks if environmental variable PORT is set and returns it, else it returns 4567
    *
    * @return Integer with assigned port for Web Service
    */
    public static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        final int defaultHerokuPort = 4567;
        return defaultHerokuPort; //return default port if heroku-port isn't set (i.e. on localhost)
    }

}
