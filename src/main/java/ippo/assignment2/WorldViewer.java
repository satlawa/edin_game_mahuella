package ippo.assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.HashMap;

/**
 * This class contains the graphical viewer of the application
 * It is responsible for showing the images of the current looking direction
 * it also shows and handles the action events caused by pressing buttons and items from the menu
 */
public class WorldViewer {

    private WorldController worldController;
    private Image displayImage;
    private Image displayItem;

    @FXML
    private ImageView imageView;

    @FXML
    private ImageView itemView;

    @FXML
    private Menu menu;

    @FXML
    private Button buttonPickUpItem;

    @FXML
    private Button buttonGo;

    /**
     * Starts the viewer and creates a WorldController
     */
    public void Initialise() {
        worldController = new WorldController();
        this.showImages();
    }

    /**
     * When the button "left" is pressed turn left
     */
    public void pressButtonLeft(ActionEvent event) {
        worldController.turnLeft();
        this.showImages();
    }

    /**
     * When the button "right" is pressed turn right
     */
    public void pressButtonRight(ActionEvent event) {
        worldController.turnRight();
        this.showImages();
    }

    /**
     * When the button "go" is pressed go to the exit (neighbour) location
     */
    public void pressButtonGo(ActionEvent event) {
        String exit = worldController.getExit();
        if (exit != null) {
            worldController.setCurrentLocation(exit);
            this.showImages();
        }
    }

    /**
     * When the button "pick up item" is pressed add the item to the players basket
     * and since the basket is represented by a Menu add the item to the Menu
     */
    public void pressButtonPickUpItem(ActionEvent event) {
        System.out.println("Item");
        String itemName = worldController.pickupItem();
        // check if item is picked up
        if (itemName != null) {
            // refresh images
            this.showImages();
            // add MenuItem
            MenuItem oneItem = new MenuItem(itemName);
            menu.getItems().add(oneItem);
            // from tutorials.jenkov.com
            oneItem.setOnAction(event1 -> {
                if (worldController.checkIfSceneHasItem() == false) {
                    System.out.println("#### MenuItem " + oneItem.getText() + " selected ####");
                    worldController.dropItem(oneItem.getText());
                    menu.getItems().remove(oneItem);
                    this.showImages();
                } else {
                    System.out.println("Scene already has an item");
                }
            });
        }
    }

    public void pressButtonBasket(ActionEvent event) {
        HashMap<String,Item> items = worldController.getPlayerItems();
        for (String key: items.keySet()) {
            System.out.println(key);
        }
    }

    /**
     * shows the images (scene and item) of the current looking direction
     */
    private void showImages() {
        displayImage = new Image(worldController.getImageLookingDirection());
        imageView.setImage(displayImage);

        if (worldController.checkIfSceneHasItem()) {
            String imageItem = worldController.getImageItem();
            displayItem = new Image(imageItem);
            itemView.setImage(displayItem);
            itemView.setVisible(true);
            buttonPickUpItem.setVisible(true);
        } else {
            itemView.setVisible(false);
            buttonPickUpItem.setVisible(false);
        }
    }
}
