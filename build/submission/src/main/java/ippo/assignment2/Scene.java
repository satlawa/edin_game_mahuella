package ippo.assignment2;

/**
 * This scene class represents one direction of a specific location.
 * The scene contains:
 *      the path to the image that represents the scene
 *      if there is an exit in this scene than it holds the name of the exit location otherwise it is null
 *      if there is an item in this scene than it holds the Item otherwise it is null
 */
public class Scene {

    private String scene;
    private String imagePath;
    private String exit;
    private Item item;

    /**
     * The constructor sets the direction of the scene
     *
     * @param direction is the direction the scene is representing
     */
    public Scene(String direction) {
        this.scene = direction;
        this.item = null;
    }

    public void setImagePath(String path) {
        this.imagePath = path;
    }

    public String getImagePath() {
        return this.imagePath;
    }


    public void setExit(String exit) {
        this.exit = exit;
    }

    public String getExit() {
        return this.exit;
    }


    public void addItem(Item item) {
        this.item = item;
    }

    public void removeItem() {
        this.item = null;
    }

    public Item getItem() {
        return this.item;
    }

    public boolean checkIfSceneHasItem() {
        if (this.item != null){
            return true;
        } else {
            return false;
        }
    }
}