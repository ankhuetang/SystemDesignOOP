package org.example;

public class Main {
    public static void main(String[] args) {
        Product coca = new Product(150, "Coca-cola");
        Product snack = new Product(370, "Cheetos");
        Inventory inventory = new Inventory();
        inventory.restockProduct(coca, 10);
        inventory.restockProduct(snack, 5);
        VendingMachine vendingMachine = new VendingMachine(inventory);

        // Customer select coca
        vendingMachine.selectProduct(coca);
        vendingMachine.handleCoinPayment(Coin.FIFTY_CENTS);
        vendingMachine.handleNotePayment(Note.TEN_DOLLAR);
        vendingMachine.dispenseProduct();
        vendingMachine.returnChange();
    }
}