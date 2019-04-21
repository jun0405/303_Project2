import java.util.HashMap;
import java.util.Map;

/**
 * Morse tree
 */
public class MorseTree {
    private static final String MORSE_DOT = ".";
    private static final String MORSE_DASH = "_";
    private static final String PLACEHOLDER = "*";
    private static final String DELIMITER = " ";

    // Root node in morse tree
    private MorseNode root;
    // Map for alphabet letter to code
    private Map<String, String> map = new HashMap<>();

    /**
     * Constructor
     */
    public MorseTree() {
        root = new MorseNode(null, null, PLACEHOLDER);
    }

    /**
     * Add a node to the morse tree
     *
     * @param value the value of current node (alphabet letter)
     * @param code  the morse code for current node
     */
    public void addNode(String value, String code) {
        MorseNode current = root;

        for (int i = 0; i < code.length(); i++) {
            // Add the node to the left if the current first code is a dot
            // Add the node to the right if the current first code is a dash
            if (code.substring(i, i + 1).equals(MORSE_DOT)) {
                if (current.getLeft() == null) {
                    current.setLeft(new MorseNode(null, null, PLACEHOLDER));
                }
                current = current.getLeft();
            } else if (code.substring(i, i + 1).equals(MORSE_DASH)) {
                if (current.getRight() == null) {
                    current.setRight(new MorseNode(null, null, PLACEHOLDER));
                }
                current = current.getRight();
            }
        }
        // Add the node to the morse tree
        current.setValue(value);
        // Add mapping to the map
        map.put(value, code);
    }

    /**
     * Encoder for encoding input to morse code
     *
     * @param input input string
     * @return encoded message (morse code)
     */
    public String encoder(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            // Lookup letter to code mapping and add it to string builder
            sb.append(map.get(input.substring(i, i + 1))).append(DELIMITER);
        }
        return sb.toString().trim();
    }

    /**
     * Decoder for decoding the morse code
     *
     * @param input input string (morse code)
     * @return plain text message
     */
    public String decoder(String input) {
        StringBuilder sb = new StringBuilder();
        for (String part : input.split(DELIMITER)) {
            // Decode each code and add it to string builder
            sb.append(decode(part));
        }
        return sb.toString().trim();
    }

    /**
     * Helper function for decoding morse code
     *
     * @param code morse code
     * @return plain text message
     */
    private String decode(String code) {
        MorseNode current = root;
        // Variable to check if the morse code is valid
        boolean valid = true;
        for (int i = 0; i < code.length(); i++) {
            // Continue only if the morse code is valid
            if (valid) {
                // Go left is first letter of the code is a dot
                // Go right is first letter of the code is a dash
                if (code.substring(i, i + 1).equals(MORSE_DOT)) {
                    // If left node doesn't exist, then the morse code is not valid
                    if (current.getLeft() == null) {
                        valid = false;
                    }
                    // Go to left node
                    current = current.getLeft();
                } else if (code.substring(i, i + 1).equals(MORSE_DASH)) {
                    // If right node doesn't exist, then the morse code is not valid
                    if (current.getRight() == null) {
                        valid = false;
                    }
                    // Go to right node
                    current = current.getRight();
                }
            } else {
                // Return placeholder
                return PLACEHOLDER;
            }
        }
        // Return the letter corresponding to the morse code
        return current.getValue().trim();
    }
}
