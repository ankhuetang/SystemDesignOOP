package org.example;

public interface VendingMachineState {
    void printStateName();
    void selectProduct(Product product);
    void insertCoin(Coin coin);
    void insertNote(Note note);
    void dispenseProduct();
    int returnChange();
}
