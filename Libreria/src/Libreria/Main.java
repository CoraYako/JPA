package Libreria;

public class Main {

    public static void main(String[] args) {

        LibreriaMenu lm = new LibreriaMenu();

        try {
            lm.menu();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }

    }

}
