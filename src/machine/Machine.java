package machine;

public class Machine {

    private MachineState machineState;
    private int water;
    private int milk;
    private int coffee;
    private int cups;
    private int money;

    public Machine(int water, int milk, int coffee, int cups, int money) {

        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
        this.cups = cups;
        this.money = money;
        setMainState();

    }

    public void setMainState() {
        machineState = MachineState.MAIN_MENU;
        machineState.printState();

    }

    public void executeAction(String input) {

        switch(machineState) {
            case MAIN_MENU:
                handleMainMenuInput(input);
                break;
            case BUYING:
                handleBuy(input);
                setMainState();
                break;
            case FILLING_WATER:
                water += Integer.parseInt(input);
                machineState = MachineState.FILLING_MILK;
                machineState.printState();
                break;
            case FILLING_MILK:
                milk += Integer.parseInt(input);
                machineState = MachineState.FILLING_COFFEE;
                machineState.printState();
                break;
            case FILLING_COFFEE:
                coffee += Integer.parseInt(input);
                machineState = MachineState.ADDING_CUPS;
                machineState.printState();
                break;
            case ADDING_CUPS:
                cups += Integer.parseInt(input);
                setMainState();
                break;
            default:
                break;
        }
    }

    private void handleBuy(String input) {

        Beverage beverage;

        switch (input) {
            case "1":
                beverage = Beverage.ESPRESSO;
                break;
            case "2":
                beverage = Beverage.LATTE;
                break;
            case "3":
                beverage = Beverage.CAPPUCCINO;
                break;
            case "back":
                machineState = MachineState.MAIN_MENU;
                return;
            default:
                return;
        }

        makeCoffee(beverage);
        return;
    }

    private void makeCoffee(Beverage beverage) {
        if (!beverage.enoughWater(water) ||
                !beverage.enoughMilk(milk) ||
                !beverage.enoughCoffee(coffee)) {
            return;
        } else if (cups == 0) {
            System.out.println("Sorry, not enough disposable cups!");
            return;
        }
        water -= beverage.getWater();
        milk -= beverage.getMilk();
        coffee -= beverage.getCoffee();
        cups -= 1;
        money += beverage.getMoney();
        System.out.println("I have enough resources, making you a coffee!");
        return;
    }


    private void handleMainMenuInput(String input) {

        switch(input) {
            case "buy":
                machineState = MachineState.BUYING;
                machineState.printState();
                break;
            case "fill":
                machineState = MachineState.FILLING_WATER;
                machineState.printState();
                break;
            case "remaining":
                printSupplies();
                setMainState();
                break;
            case "take":
                System.out.printf("\nI gave you $%d\n", money);
                money = 0;
                setMainState();
                break;
            case "exit":
                machineState = MachineState.OFF;
                break;

        }
    }

    private void printSupplies() {
        System.out.println("\nThe coffee machine has:");
        System.out.printf("%d of water\n" +
                "%d of milk\n" +
                "%d of coffee beans\n" +
                "%d of disposable cups\n" +
                "$%d of money\n", water, milk, coffee, cups, money);
    }

    public boolean isOn() {
        return machineState != MachineState.OFF;
    }

}
