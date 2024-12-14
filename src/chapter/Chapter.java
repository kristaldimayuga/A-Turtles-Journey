package chapter;

public abstract class Chapter {
    public int playerId;
    public Chapter(int playerId) {
        this.playerId = playerId;
    }
    public abstract void start();
    public abstract void updateProgress(String state);
}
