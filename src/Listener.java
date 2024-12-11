import java.util.ArrayList;

class Listener {
    String name;
    String genrePreference;
    double wallet;
    ArrayList<Song> playlist;

    public Listener(String name, String genrePreference, double wallet) {
        this.name = name;
        this.genrePreference = genrePreference;
        this.wallet = wallet;
        this.playlist = new ArrayList<>();
    }

    public void printInfo() {
        System.out.println(name + " enjoys " + genrePreference + " music.");
    }

    public void showWallet() {
        System.out.println(name + " has $" + wallet + " remaining.");
    }

    public void addSongToPlaylist(Song song, int rating) {
        if (isSongOwned(song)) {
            System.out.println(name + " already has " + song.title + " in their playlist.");
        } else if (wallet < song.cost) {
            System.out.println(name + " cannot afford the song " + song.title);
        } else if (rating < 1 || rating > 5) {
            System.out.println("Invalid rating! Please rate between 1 and 5.");
        } else {
            playlist.add(song);
            wallet -= song.cost;
            song.downloads++;
            song.ratings.add(rating);
            System.out.println(name + " added " + song.title + " to their playlist.");
        }
    }

    public boolean isSongOwned(Song song) {
        return playlist.contains(song);
    }

    public void viewPlaylist() {
        System.out.println("\n" + name + "'s playlist:");
        for (Song song : playlist) {
            System.out.println(song);
        }
    }

    public void depositMoney(double amount) {
        wallet += amount;
        System.out.println(name + " deposited $" + amount + " into their wallet.");
    }

    public void playSong(Song song) {
        if (isSongOwned(song)) {
            System.out.println(name + " is now playing " + song.title + "...");
            song.plays++;
        } else {
            System.out.println(name + " does not own the song " + song.title);
        }
    }
}