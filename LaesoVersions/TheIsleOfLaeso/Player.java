public class Player {
    /**
     * @Author Maximilian C. Sutton
     * @Version 0.75
     * @Since 2021-04-26
     */

    // varables that are inportant
    private int x;
    private int y;
    private String name;
    private String hat;
    private String clothes;
    private String color;
    private int[] inventory;
    private int health;

    /**
     * a constructure
     *
     * @param x,        y, playerNum
     * @param name,     hat, clothes, color, dirFace
     * @param inventory
     */
    public Player(int x, int y, String name, String hat, String clothes, String color, int[] inventory, int health) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.hat = hat;
        this.clothes = clothes;
        this.color = color;
        this.inventory = inventory;
        this.inventory = new int[6];
        this.health = health;
    }

    public int getXPos() {
        return x;
    }

    public int getYPos() {
        return y;
    }

    public String getName() {
        return name;
    }

    public String getHat() {
        return hat;
    }

    public String getClothes() {
        return clothes;
    }

    public String getColor() {
        return color;
    }

    public int getHealth() {
        return health;
    }

    public void damage() {
        health -= 1;
    }

    /**
     * a function to control movment
     *
     * @param dirFace
     */
    public void move(String direction) {
        direction = direction.toLowerCase();
        switch (direction) {
        case "lu":
            x -= 1;
            y += 1;
            break;
        case "ld":
            x -= 1;
            y -= 1;
            break;
        case "ru":
            x += 1;
            y += 1;
            break;
        case "rd":
            x += 1;
            y -= 1;
            break;
        default:
            System.out.println("YOU BIG DUMB");
        }
    }

    /**
     * a functionn to clear a players inventory
     */
    public void clearInventory() {
        for (int i = 0; i < 6; i++) {
            // first fill with empty int
            inventory[i] = 0;
        }
    }

    /**
     * a functionn to get a resource in players inventory
     *
     * @param resource
     * @returns amount
     */
    public int getResource(String resource) {
        resource = resource.toLowerCase();
        int amount = 0;
        switch (resource) {
        case "wood":
            amount = inventory[0];
            break;
        case "people":
            amount = inventory[1];
            break;
        case "food":
            amount = inventory[2];
            break;
        case "stone":
            amount = inventory[3];
            break;
        case "ore":
            amount = inventory[4];
            break;
        case "magic":
            amount = inventory[5];
            break;
        default:
            amount = 0;
            System.out.println("YOU BIG DUMB");
        }
        return amount;
    }

    /**
     * a functionn to add to a recorce to a players inventory
     *
     * @param resource
     */
    public void addResource(String resource) {
        resource = resource.toLowerCase();
        switch (resource) {
        case "wood":
            inventory[0] += 1;
            break;
        case "people":
            inventory[1] += 1;
            break;
        case "food":
            inventory[2] += 1;
            break;
        case "stone":
            inventory[3] += 1;
            break;
        case "ore":
            inventory[4] += 1;
            break;
        case "magic":
            inventory[5] += 1;
            break;
        default:
            System.out.println("YOU BIG DUMB");
        }
    }

    /**
     * a functionn to add to a players inventory, can add more than one
     *
     * @param resource
     * @param amount
     */
    public void addResource(String resource, int amount) {
        resource = resource.toLowerCase();
        switch (resource) {
        case "wood":
            inventory[0] += amount;
            break;
        case "people":
            inventory[1] += amount;
            break;
        case "food":
            inventory[2] += amount;
            break;
        case "stone":
            inventory[3] += amount;
            break;
        case "ore":
            inventory[4] += amount;
            break;
        case "magic":
            inventory[5] += amount;
            break;
        default:
            System.out.println("YOU BIG DUMB");
        }
    }
}
