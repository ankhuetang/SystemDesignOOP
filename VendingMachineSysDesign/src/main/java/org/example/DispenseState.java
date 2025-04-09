package org.example;

public class DispenseState implements VendingMachineState {
    private VendingMachine vendingMachine;

    public DispenseState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void printStateName() {
        System.out.println("Machine is in dispense mode.");
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Product is already selected.");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Inserted cash is sufficient.");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Inserted cash is sufficient");
    }

    @Override
    public void dispenseProduct() {
        Product selectedProduct = vendingMachine.getSelectedProduct();
        vendingMachine.getInventory().dispenseProduct(selectedProduct);
        System.out.println("Please grab your " + selectedProduct.getName());
    }

    @Override
    public int returnChange() {
        Product selectedProduct = vendingMachine.getSelectedProduct();
        if (vendingMachine.getTotalInsertedCash() > selectedProduct.getPrice()) {
            return vendingMachine.getTotalInsertedCash() - selectedProduct.getPrice();
        }
        return 0;
    }
}
