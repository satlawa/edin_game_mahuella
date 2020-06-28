package ippo.assignment2;

/**
 * This scene class represents one item.
 * The item contains:
 *      the name of the item
 *      the path to the image that represents the item
 */
public class Item {

    private String name;
    private String imagePath;

    /**
     * The constructor sets the name of the item
     *
     * @param name is the name of the item
     */
    public Item(String name) {
        this.name = name;
        this.imagePath = null;
    }

    public String getName() {
        return name;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }
}
