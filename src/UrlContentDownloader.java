import java.io.*;
import java.net.URL;
import java.util.List;

public class UrlContentDownloader {
    private List<String> urls;

    public UrlContentDownloader(List<String> urls) {
        this.urls = urls;
    }

    public void downloadContents() {
        int count = 1;
        for (String urlString : urls) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(urlString).openStream()));
                 FileWriter writer = new FileWriter("Downloaded_Content_" + count + ".txt")) {

                String line;
                while ((line = reader.readLine()) != null) {
                    writer.write(line + System.lineSeparator());
                }
                System.out.println("Content from " + urlString + " saved to Downloaded_Content_" + count + ".txt");
                count++;
            } catch (IOException e) {
                System.err.println("Failed to download content from: " + urlString);
                e.printStackTrace();
            }
        }
    }
}

