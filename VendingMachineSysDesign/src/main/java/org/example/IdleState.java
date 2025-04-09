package org.example;

public class IdleState implements VendingMachineState {
    private VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void printStateName() {
        System.out.println("Machine is idle");
    }

    @Override
    public void selectProduct(Product product) {
        if (vendingMachine.getInventory().isInStock(product)) {
            vendingMachine.setSelectedProduct(product);
            System.out.println("Product " + product.getName() + " selected.");
        } else {
            System.out.println("Product " + product.getName() + " is out of stock");
        }
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please select product first.");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Please select product first");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please select product first");
    }

    @Override
    public int returnChange() {
        System.out.println("Please select product first");
        return  0;
    }
}
