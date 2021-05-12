package machine;

public enum MachineState {

    OFF(""),
    MAIN_MENU("\nWrite action (buy, fill, take, remaining, exit):"),
    BUYING("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:"),
    FILLING_WATER("\nWrite how many ml of water do you want to add:"),
    FILLING_MILK("Write how many ml of milk do you want to add:"),
    FILLING_COFFEE("Write how many grams of coffee beans do you want to add:"),
    ADDING_CUPS("Write how many disposable cups of coffee do you want to add:");

    private final String stateDisplay;

    MachineState(String stateDisplay) {
        this.stateDisplay = stateDisplay;
    }

    public void printState() {
        System.out.println(stateDisplay);
    }


}
