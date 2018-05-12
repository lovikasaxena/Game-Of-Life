package exercise4lovika.game.service;

public class AliveCellRequiredException extends Exception{
    public AliveCellRequiredException() {
        super("Atleast one alive cell required");
    }
}
