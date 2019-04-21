import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Driver class for morse code encoder/decoder
 */
public class MorseCode {
    public static void main(String[] args) throws FileNotFoundException {
        MorseTree morseTree = new MorseTree();

        // Construct tree
        Scanner scanner = new Scanner(new File("resources/morse_code_mapping.txt"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String letter = line.substring(0, 1);
            String code = line.substring(1);
            morseTree.addNode(letter, code);
        }

        // Decoding
        String input = "_.. __.";
        System.out.printf("Decoded message for [%s] is [%s]\n", input, morseTree.decoder(input));
        // Encoding
        input = "ac";
        System.out.printf("Encoded message for [%s] is [%s]", input, morseTree.encoder(input));
    }
}
