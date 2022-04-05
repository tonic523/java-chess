package chess;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.staticFiles;

import chess.web.controller.BoardController;

public class WebApplication {

    public static void main(String[] args) {
        port(8080);

        staticFiles.location("/static");
        BoardController boardController = new BoardController();

        get("/chess", boardController::printCurrentBoard);
        get("/chess/status", boardController::status);
        post("/chess/move", boardController::move);
        get("/chess/end", boardController::end);
    }
}
