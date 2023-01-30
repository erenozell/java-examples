import Pisti.*;

public class GameCenter {

    public static void main(String[] args) {

        /* OYUNCULARI OLUŞTUR */
        Player[] players = new Player[3];
        players[0] = new Player("Eren");
        players[1] = new Player("emre");

        /* OYUNU OLUŞTUR */

        Pisti pisti = new Pisti(players);

    }
}
