package org.example;

public class VendingMachine {
    private Inventory inventory;
    private VendingMachineState currentState;
    private Product selectedProduct;

    private int totalInsertedCash;

    public VendingMachine(Inventory inventory) {
        this.inventory = inventory;
        this.currentState = new IdleState(this);
    }

    public void selectProduct(Product product) {
        this.currentState.selectProduct(product);
        this.setSelectedProduct(product);
        this.setCurrentState(new ReadyState(this));
    }

    public void handleCoinPayment(Coin coin) {
        this.currentState.insertCoin(coin);
        if (this.getTotalInsertedCash() > this.selectedProduct.getPrice()) {
            this.setCurrentState(new DispenseState(this));
        }
    }

    public void handleNotePayment(Note note) {
        this.currentState.insertNote(note);
        if (this.getTotalInsertedCash() > this.selectedProduct.getPrice()) {
            this.setCurrentState(new DispenseState(this));
        }
    }

    public void returnChange() {
        this.currentState.returnChange();
    }

    public void dispenseProduct() {
        this.currentState.dispenseProduct();
    }

    public int getTotalInsertedCash() {
        return totalInsertedCash;
    }

    public void setTotalInsertedCash(int totalInsertedCash) {
        this.totalInsertedCash = totalInsertedCash;
    }
    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public VendingMachineState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(VendingMachineState currentState) {
        this.currentState = currentState;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

}
