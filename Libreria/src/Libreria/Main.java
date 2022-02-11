package Libreria;

public class Main {

    public static void main(String[] args) {

        LibreriaMenu lm = new LibreriaMenu();

        try {
            lm.menu();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}
