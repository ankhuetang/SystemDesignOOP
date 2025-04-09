package org.example;

import java.util.HashMap;
import java.util.Map;

public class ReadyState implements VendingMachineState {
    private static final HashMap<Coin, Integer> COIN_TO_CENT = new HashMap<>();
    private static final Map<Note, Integer> NOTE_TO_CENT = new HashMap<>();

    static {
        COIN_TO_CENT.put(Coin.ONE_CENT, 1);
        COIN_TO_CENT.put(Coin.FIVE_CENTS, 2);
        COIN_TO_CENT.put(Coin.TEN_CENTS, 10);
        COIN_TO_CENT.put(Coin.TWENTY_FIVE_CENTS, 25);
        COIN_TO_CENT.put(Coin.FIFTY_CENTS, 50);
        COIN_TO_CENT.put(Coin.ONE_HUNDRED_CENTS, 100);
        NOTE_TO_CENT.put(Note.ONE_DOLLAR, 100);
        NOTE_TO_CENT.put(Note.TWO_DOLLAR, 200);
        NOTE_TO_CENT.put(Note.FIVE_DOLLAR, 500);
        NOTE_TO_CENT.put(Note.TEN_DOLLAR, 1000);
        NOTE_TO_CENT.put(Note.TWENTY_DOLLAR, 2000);
        NOTE_TO_CENT.put(Note.FIFTY_DOLLAR, 5000);
        NOTE_TO_CENT.put(Note.ONE_HUNDRED_DOLLAR, 10000);
    }

    private VendingMachine vendingMachine;

    public ReadyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void printStateName() {
        System.out.println("Machine is ready");
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Product is already selected.");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Received " + COIN_TO_CENT.get(coin) + " cents.");
        Product selectedProduct = vendingMachine.getSelectedProduct();
        int insertedCash = vendingMachine.getTotalInsertedCash();
        vendingMachine.setTotalInsertedCash(insertedCash + COIN_TO_CENT.get(coin));

        if (vendingMachine.getTotalInsertedCash() < selectedProduct.getPrice()) {
            System.out.println("Please insert more money");
        } else {
            System.out.println("Please wait for your change.");
        }
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Received " + NOTE_TO_CENT.get(note) + " cents.");
        Product selectedProduct = vendingMachine.getSelectedProduct();
        int insertedCash = vendingMachine.getTotalInsertedCash();
        vendingMachine.setTotalInsertedCash(insertedCash + NOTE_TO_CENT.get(note));

        if (vendingMachine.getTotalInsertedCash() < selectedProduct.getPrice()) {
            System.out.println("Please insert more money");
        }
    }

    @Override
    public void dispenseProduct() {
        Product selectedProduct = vendingMachine.getSelectedProduct();
        System.out.println("Please wait for your " + selectedProduct.getName() + " to be released.");
    }

    @Override
    public int returnChange() {
        System.out.println("Please wait for your product and change.");
        return 0;
    }
}
