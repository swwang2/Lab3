import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScrapper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
    public static int wordCount(final String url) {
        String contents = urlToString(url);
        String[] words = contents.split(" ");
        int count = 0;
        boolean letters;
        for (int i = 0; i < words.length; i++) {
            letters = true;
            for (int j = 0; j < words[i].length(); j++) {
                if (!Character.isDefined(words[i].charAt(j))) {
                    letters = false;
                }
            }
            if (letters) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] unused) {
//        System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
        System.out.println(wordCount("https://www.bls.gov/tus/charts/chart9.txt"));
    }
}
