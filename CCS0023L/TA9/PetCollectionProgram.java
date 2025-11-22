package TA9;

import java.util.*;

public class PetCollectionProgram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice = "";

        while (!choice.equalsIgnoreCase("D")) {

            System.out.println("\n==== PET COLLECTION MENU ====");
            System.out.println("A. Vector");
            System.out.println("B. TreeSet");
            System.out.println("C. Hashtable");
            System.out.println("D. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextLine().toUpperCase();

            switch (choice) {
                case "A":
                    vectorOption(sc);
                    break;

                case "B":
                    treeSetOption(sc);
                    break;

                case "C":
                    hashtableOption(sc);
                    break;

                case "D":
                    System.out.println("Exiting program... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please choose A, B, C, or D.");
            }
        }
        sc.close();
    }

    // Option A: Vector
    public static void vectorOption(Scanner sc) {
        Vector<String> pets = new Vector<>();

        System.out.println("\n--- VECTOR OPTION ---");
        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter pet name " + i + ": ");
            pets.add(sc.nextLine());
        }

        Collections.sort(pets);

        System.out.println("\nSorted Pet Names (Vector):");
        for (String p : pets) {
            System.out.println(p);
        }
    }

    // Option B: TreeSet
    public static void treeSetOption(Scanner sc) {
        TreeSet<String> petSet = new TreeSet<>();

        System.out.println("\n--- TREESET OPTION ---");
        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter pet name " + i + ": ");
            petSet.add(sc.nextLine());
        }

        System.out.println("\nSorted Pet Names (TreeSet):");
        for (String p : petSet) {
            System.out.println(p);
        }
    }

    // Option C: Hashtable
    public static void hashtableOption(Scanner sc) {
        Hashtable<String, String> petInfo = new Hashtable<>();

        System.out.println("\n--- HASHTABLE OPTION ---");
        System.out.print("Pet Type: ");
        petInfo.put("PetType", sc.nextLine());

        System.out.print("Pet Name: ");
        petInfo.put("PetName", sc.nextLine());

        System.out.print("Pet Color: ");
        petInfo.put("PetColor", sc.nextLine());

        System.out.print("Pet Age: ");
        petInfo.put("PetAge", sc.nextLine());

        System.out.print("Pet Size: ");
        petInfo.put("PetSize", sc.nextLine());

        System.out.println("\n--- DISPLAYING PET INFORMATION (Hashtable) ---");
        for (String key : petInfo.keySet()) {
            System.out.println(key + ": " + petInfo.get(key));
        }
    }
}
