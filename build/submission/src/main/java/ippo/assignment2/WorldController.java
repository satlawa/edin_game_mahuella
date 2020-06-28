package ippo.assignment2;

import java.util.HashMap;

/**
 * A simple controller for the assignment2 application.
 *
 * @author Philipp Satlawa
 * @version 1.0, §PUBDATE
 */

public class WorldController {

    private World world;

    public WorldController() {
        world = new World("mahuella");
        world.createWorld();
    }

    public void turnLeft() {
        System.out.println("Left");
        world.turnLeft();
    }

    public void turnRight() {
        System.out.println("Right");
        world.turnRight();
    }

    public String getExit() {
        return world.getExit();
    }

    public void setCurrentLocation(String exit) {
        world.setCurrentLocation(exit);
    }

    public String getImageLookingDirection() {
        return world.getImageLookingDirection();
    }

    public boolean checkIfSceneHasItem() {
        return world.checkIfSceneHasItem();
    }

    public String getImageItem() {
        return world.getImageItem();
    }

    public String pickupItem() {
        return world.pickupItem();
    }

    public void dropItem(String item) {
        world.dropItem(item);
    }

    public HashMap<String,Item> getPlayerItems() {
        return world.getPlayerItems();
    }

}
