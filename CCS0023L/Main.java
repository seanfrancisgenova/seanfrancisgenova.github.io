import java.util.ArrayList;

class Room {
    private int roomNo;
    private String roomType;
    private double roomArea;
    private boolean hasAC;

    public void setData(int roomNo, String roomType, double roomArea, boolean hasAC) {
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.roomArea = roomArea;
        this.hasAC = hasAC;
    }

    public void displayData() {
        System.out.println("Room No: " + roomNo);
        System.out.println("Room Type: " + roomType);
        System.out.println("Room Area: " + roomArea + " sq.m.");
        System.out.println("AC Machine: " + (hasAC ? "Yes" : "No"));
        System.out.println();
    }
}

class AddressBookEntry {
    private String name;
    private String address;
    private String telephoneNumber;
    private String emailAddress;

    public AddressBookEntry(String name, String address, String telephoneNumber, String emailAddress) {
        this.name = name;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getTelephoneNumber() { return telephoneNumber; }
    public String getEmailAddress() { return emailAddress; }

    public void setName(String name) { this.name = name; }
    public void setAddress(String address) { this.address = address; }
    public void setTelephoneNumber(String telephoneNumber) { this.telephoneNumber = telephoneNumber; }
    public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }

    public void displayEntry() {
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Telephone: " + telephoneNumber);
        System.out.println("Email: " + emailAddress);
        System.out.println();
    }
}


class AddressBook {
    private ArrayList<AddressBookEntry> entries;

    public AddressBook() {
        entries = new ArrayList<>(100);
    }
    
    public void addEntry(AddressBookEntry entry) {
        if (entries.size() < 100) {
            entries.add(entry);
            System.out.println("Entry added successfully!");
        } else {
            System.out.println("Address book is full!");
        }
    }

    public void deleteEntry(String name) {
        boolean removed = entries.removeIf(e -> e.getName().equalsIgnoreCase(name));
        if (removed)
            System.out.println("Entry deleted successfully!");
        else
            System.out.println("Entry not found!");
    }

    public void viewAllEntries() {
        if (entries.isEmpty()) {
            System.out.println("Address book is empty.");
        } else {
            for (AddressBookEntry e : entries) {
                e.displayEntry();
            }
        }
    }

    public void updateEntry(String name, String newAddress, String newPhone, String newEmail) {
        for (AddressBookEntry e : entries) {
            if (e.getName().equalsIgnoreCase(name)) {
                e.setAddress(newAddress);
                e.setTelephoneNumber(newPhone);
                e.setEmailAddress(newEmail);
                System.out.println("Entry updated successfully!");
                return;
            }
        }
        System.out.println("Entry not found!");
    }
}

public class Main {
    public static void main(String[] args) {
        Room room1 = new Room();
        room1.setData(101, "Deluxe", 30.5, true);
        room1.displayData();

        AddressBook myBook = new AddressBook();

        AddressBookEntry entry1 = new AddressBookEntry("Alice", "Manila", "09171234567", "alice@gmail.com");
        AddressBookEntry entry2 = new AddressBookEntry("Bob", "Quezon City", "09987654321", "bob@yahoo.com");

        myBook.addEntry(entry1);
        myBook.addEntry(entry2);

        System.out.println("\n--- All Entries ---");
        myBook.viewAllEntries();

        myBook.updateEntry("Alice", "Cebu City", "09090000000", "alice@newmail.com");

        System.out.println("\n--- After Update ---");
        myBook.viewAllEntries();

        myBook.deleteEntry("Bob");

        System.out.println("\n--- After Deletion ---");
        myBook.viewAllEntries();
    }
}
