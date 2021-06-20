package searchengine;

import java.io.IOException;

import static spark.Spark.*;

public class MiniGoogle {
    public static void main(String[] args) throws IOException {
        get("/", (req, res) -> {
            return "MiniGoogle by X, Y"; // TODO: replace X and Y by your name(s)
        });
    }
}
