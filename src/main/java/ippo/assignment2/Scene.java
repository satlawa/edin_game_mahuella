package ippo.assignment2;

import java.util.Set;

public class Scene {

    private String scene;
    private String imagePath;
    private String exit;
    private Item item;

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