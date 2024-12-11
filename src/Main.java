public class Main {
    public static void main(String[] args) {
        Song track1 = new Song("Chandelier", "Sia", "Pop", 1.29, 213, "https://www.youtube.com/watch?v=2vjPBrBU-TM");
        Song track2 = new Song("Blinding Lights", "The Weeknd", "Pop", 1.49, 200, "https://www.youtube.com/watch?v=4NRXx6U8ABQ");

        Listener john = new Listener("John Doe", "Pop", 10.00);
        Listener emily = new Listener("Emily Smith", "Rock", 5.00);

        john.printInfo();
        john.showWallet();
        john.addSongToPlaylist(track1, 5);
        john.viewPlaylist();

        emily.depositMoney(10.00);
        emily.addSongToPlaylist(track2, 4);
        emily.playSong(track2);

        track1.showStatistics();
        track2.showStatistics();
        track2.openInBrowser();
    }
}