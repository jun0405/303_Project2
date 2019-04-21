/**
 * Node for morse tree
 */
public class MorseNode {
    // Current node's value
    private String value;
    // Current node's left node
    private MorseNode left;
    // Current node's right node
    private MorseNode right;

    /**
     * Constructor
     *
     * @param left  the left node of the current node
     * @param right the right node of the current node
     * @param value the value of current node
     */
    public MorseNode(MorseNode left, MorseNode right, String value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    /**
     * Accessor for value
     *
     * @return the value of current node
     */
    public String getValue() {
        return value;
    }

    /**
     * Mutator for value
     *
     * @param value the value of current node
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Accessor for left node
     *
     * @return the left node of current node
     */
    public MorseNode getLeft() {
        return left;
    }

    /***
     * Mutator for left node
     * @param left the left node of the current node
     */
    public void setLeft(MorseNode left) {
        this.left = left;
    }

    /**
     * Accessor for right node
     *
     * @return the right node of current node
     */
    public MorseNode getRight() {
        return right;
    }

    /***
     * Mutator for right node
     * @param right the left node of the current node
     */
    public void setRight(MorseNode right) {
        this.right = right;
    }
}
