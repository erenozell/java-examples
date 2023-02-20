import Pisti.*;

public class GameCenter {

    public static void main(String[] args) {
        Player[] players = new Player[3];
        players[0] = new Player("Eren");
        players[1] = new Player("emre");
        players[2] = new Player("fatih");

        Pisti pisti = new Pisti(players);
        pisti.onGame(players);
    }
}
