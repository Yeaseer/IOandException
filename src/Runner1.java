public class Runner1 {
    public static void main(String[] args) {
        String filename = "input.txt";  // specify your file path here
        FileCounter counter = new FileCounter(filename);
        counter.processFile();
        counter.displayCounts();
    }
}
