import java.util.Scanner;

public class Runner5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sourcePath = "source.bin";
        String destinationPath = "destination.bin";

        BinaryFileManager fileManager = new BinaryFileManager(sourcePath);

        // Copy file
        fileManager.copyFile(destinationPath);

        // Append data
        System.out.print("Enter data to append (as text): ");
        String input = scanner.nextLine();
        byte[] data = input.getBytes();

        fileManager.appendData(data);
    }
}
