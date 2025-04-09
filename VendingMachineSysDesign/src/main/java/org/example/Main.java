package org.example;

public class Main {
    public static void main(String[] args) {
        Product coca = new Product(150, "Coca-cola");
        Product snack = new Product(370, "Cheetos");

        VendingMachine vendingMachine = VendingMachine.getInstance();
        vendingMachine.getInventory().restockProduct(coca, 10);
        vendingMachine.getInventory().restockProduct(snack, 5);

        // Customer select coca
        vendingMachine.selectProduct(coca);
        vendingMachine.handleCoinPayment(Coin.FIFTY_CENTS);
        vendingMachine.handleNotePayment(Note.TEN_DOLLAR);
        vendingMachine.dispenseProduct();
        vendingMachine.returnChange();
    }
}