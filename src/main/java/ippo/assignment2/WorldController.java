package ippo.assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.HashMap;

public class WorldController {

    private World world;
    private Image displayImage;
    private Image displayItem;

    @FXML
    private ImageView imageView;

    @FXML
    private ImageView itemView;

    @FXML
    private Menu menu;


    public void Initialise() {
        world = new World("mahuella");
        world.createWorld();
        this.showImages();
    }

    public void pressButtonLeft(ActionEvent event) {
        System.out.println("Left");
        world.turnLeft();
        this.showImages();
    }

    public void pressButtonRight(ActionEvent event) {
        System.out.println("Right");
        world.turnRight();
        this.showImages();
    }

    public void pressButtonGo(ActionEvent event) {
        System.out.println("Go");
        String exit = world.getExit();
        if (exit != null) {
            world.setCurrentLocation(exit);
            this.showImages();
        }
    }

    public void pressButtonItem(ActionEvent event) {
        System.out.println("Item");
        String itemName = world.pickupItem();
        // check if item is picked up
        if (itemName != null) {
            // refresh images
            this.showImages();
            // add MenuItem
            MenuItem oneItem = new MenuItem(itemName);
            menu.getItems().add(oneItem);
            // from tutorials.jenkov.com
            oneItem.setOnAction(event1 -> {
                if (world.checkIfSceneHasItem() == false) {
                    System.out.println("#### MenuItem " + oneItem.getText() + " selected ####");
                    world.dropItem(oneItem.getText());
                    menu.getItems().remove(oneItem);
                    this.showImages();
                } else {
                    System.out.println("Scene already has an item");
                }
            });
        }
    }

    public void pressButtonBasket(ActionEvent event) {
        HashMap<String,Item> items = world.getPlayerItems();
        for (String key: items.keySet()) {
            System.out.println(key);
        }
    }

    private void showImages() {
        displayImage = new Image(world.getImageLookingDirection());
        imageView.setImage(displayImage);

        if (world.checkIfSceneHasItem()) {
            String imageItem = world.getImageItem();
            displayItem = new Image(imageItem);
            itemView.setImage(displayItem);
            itemView.setVisible(true);
        } else {
            itemView.setVisible(false);
        }
    }
}
