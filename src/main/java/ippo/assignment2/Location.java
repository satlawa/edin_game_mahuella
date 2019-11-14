package ippo.assignment2;

import java.util.HashMap;

public class Location {

    private String name;
    private HashMap<String, Scene> scenes;

    public Location(String name) {
        this.name = name;
        this.scenes = new HashMap<String,Scene>();
    }

    /**
     * add Direction to HashMap directions
     * @param direction
     * @param imageName
     */
    public void addScene(String direction, String imageName) {
        // create and add Direction to HashMap if it is one of the four compass directions
        //if (this.changingDirectionLeft.containsKey(direction)) {
        Scene scene = new Scene(direction);
        scene.setImagePath(imageName);
        this.scenes.put(direction, scene);
        //}
    }

    public void setSceneExit(String direction, String neighbourLocationName) {
        this.scenes.get(direction).setExit(neighbourLocationName);
    }



    public String getSceneImage(String lookingDirection) {
        return this.scenes.get(lookingDirection).getImagePath();
    }

    public String getSceneExit(String lookingDirection) {
        if (this.scenes.containsKey(lookingDirection)) {
            return this.scenes.get(lookingDirection).getExit();
        }
        else {
            return "noExit";
        }
    }

    // item

    public void addItemToScene(String direction, Item item) {
        this.scenes.get(direction).addItem(item);
    }

    public void removeItemFromScene(String direction) {
        this.scenes.get(direction).removeItem();
    }

    public boolean checkIfSceneHasItem(String lookingDirection) {
        return this.scenes.get(lookingDirection).checkIfSceneHasItem();
    }

    public Item getItemFormScene(String lookingDirection) {
        return this.scenes.get(lookingDirection).getItem();
    }
}
