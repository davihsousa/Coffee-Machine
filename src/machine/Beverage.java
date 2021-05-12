package machine;

public enum Beverage {
    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6);

    private final int water;
    private final int milk;
    private final int coffee;
    private final int money;

    Beverage(int water, int milk, int coffee, int money) {
        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
        this.money = money;
    }

    public boolean enoughWater(int water) {
        if (this.water <= water) {
            return true;
        } else {
            System.out.println("Sorry, not enough water!");
            return false;
        }
    }

    public boolean enoughMilk(int milk) {
        if (this.milk <= milk) {
            return true;
        } else {
            System.out.println("Sorry, not enough milk!");
            return false;
        }
    }

    public boolean enoughCoffee(int coffee) {
        if (this.coffee <= coffee) {
            return true;
        } else {
            System.out.println("Sorry, not enough coffee!");
            return false;
        }
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffee() {
        return coffee;
    }

    public int getMoney() {
        return money;
    }

}
