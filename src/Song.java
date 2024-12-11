import java.util.ArrayList;
import java.awt.Desktop;
import java.net.URI;
class Song {
    String title;
    String artist;
    String genre;
    double cost;
    int duration; // in seconds
    int downloads;
    int plays;
    ArrayList<Integer> ratings;
    String link;

    public Song(String title, String artist, String genre, double cost, int duration, String link) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.cost = cost;
        this.duration = duration;
        this.link = link;
        this.downloads = 0;
        this.plays = 0;
        this.ratings = new ArrayList<>();
    }

    public void displayDetails() {
        System.out.println("Title: " + title + ", Artist: " + artist + ", Genre: " + genre + ", Price: $" + cost);
    }

    public void showStatistics() {
        System.out.println(title + " has been downloaded " + downloads + " times and played " + plays + " times.");
    }

    public double getAverageRating() {
        if (ratings.isEmpty()) return 0.0;
        double total = 0;
        for (int rating : ratings) {
            total += rating;
        }
        return total / ratings.size();
    }

    public void openInBrowser() {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI(link));
            } else {
                System.out.println("Browser is not supported on this system.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return title + " by " + artist;
    }
}