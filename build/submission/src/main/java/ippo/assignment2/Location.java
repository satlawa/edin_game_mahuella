package ippo.assignment2;

import java.util.HashMap;

/**
 * This class represents one location in the application.
 * One location contains the Scenes of every compass direction.
 * It is a intermediary between the World class and the Scene class
 */
public class Location {

    private String name;
    private HashMap<String, Scene> scenes;

    /**
     * The constructor sets the name of the location
     *
     * @param name name of the location
     */
    public Location(String name) {
        this.name = name;
        this.scenes = new HashMap<String,Scene>();
    }

    /**
     * adds a Scene to HashMap scenes
     *
     * @param direction scene direction
     * @param imageName file name of the image
     */
    public void addScene(String direction, String imageName) {
        // create and add Direction to HashMap if it is one of the four compass directions
        //if (this.changingDirectionLeft.containsKey(direction)) {
        Scene scene = new Scene(direction);
        scene.setImagePath(imageName);
        this.scenes.put(direction, scene);
        //}
    }

    /**
     * Sets the name of a location as an exit at the Scene
     *
     * @param direction is the direction
     * @param neighbourLocationName name of the location
     */
    public void setSceneExit(String direction, String neighbourLocationName) {
        this.scenes.get(direction).setExit(neighbourLocationName);
    }

    /**
     * Retrieves the file name of the current looking direction (Scene)
     *
     * @param lookingDirection is the direction the player is currently looking at
     */
    public String getSceneImage(String lookingDirection) {
        return this.scenes.get(lookingDirection).getImagePath();
    }

    /**
     * Retrieves the exit location of the current looking direction (Scene)
     *
     * @param lookingDirection is the direction the player is currently looking at
     */
    public String getSceneExit(String lookingDirection) {
        if (this.scenes.containsKey(lookingDirection)) {
            return this.scenes.get(lookingDirection).getExit();
        }
        else {
            return "noExit";
        }
    }

    /**
     * Adds an Item to the Scene
     *
     * @param direction is the direction the player is currently looking at
     * @param item is the item to be added to the scene
     */
    public void addItemToScene(String direction, Item item) {
        this.scenes.get(direction).addItem(item);
    }

    /**
     * Removes an Item from the Scene
     *
     * @param direction is the direction the player is currently looking at
     */
    public void removeItemFromScene(String direction) {
        this.scenes.get(direction).removeItem();
    }

    /**
     * Checks if the Scene contains an Item
     *
     * @param lookingDirection is the direction the player is currently looking at
     */
    public boolean checkIfSceneHasItem(String lookingDirection) {
        return this.scenes.get(lookingDirection).checkIfSceneHasItem();
    }

    /**
     * Returns the Item of the Scene
     *
     * @param lookingDirection is the direction the player is currently looking at
     */
    public Item getItemFormScene(String lookingDirection) {
        return this.scenes.get(lookingDirection).getItem();
    }
}
