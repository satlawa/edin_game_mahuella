package ippo.assignment2;

public class Item {

    private String name;
    private String imagePath;

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
