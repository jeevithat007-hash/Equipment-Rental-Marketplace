import java.util.ArrayList;
import java.util.Scanner;

public class RentalSystem {

private ArrayList<User> users = new ArrayList<>();  
private ArrayList<Equipment> equipments = new ArrayList<>();  
private ArrayList<Rental> rentals = new ArrayList<>();  

private Scanner sc = new Scanner(System.in);  

private int userId = 1;  
private int equipmentId = 1;  

// Register User  
public void register() {  

    System.out.println("\n===== User Registration =====");  

    System.out.print("Name : ");  
    String name = sc.nextLine();  

    System.out.print("Email : ");  
    String email = sc.nextLine();  

    System.out.print("Password : ");  
    String password = sc.nextLine();  

    System.out.print("Role (Owner/Renter) : ");  
    String role = sc.nextLine();  

    users.add(new User(userId++, name, email, password, role));  

    System.out.println("Registration Successful!");  
}  

// Login  
public User login() {  

    System.out.println("\n===== Login =====");  

    System.out.print("Email : ");  
    String email = sc.nextLine();  

    System.out.print("Password : ");  
    String password = sc.nextLine();  

    for (User user : users) {  

        if (user.getEmail().equals(email)  
                && user.getPassword().equals(password)) {  

            System.out.println("Welcome " + user.getName());  
            return user;  
        }  
    }  

    System.out.println("Invalid Login!");  
    return null;  
}  

// Add Equipment  
public void addEquipment() {  

    System.out.println("\n===== Add Equipment =====");  

    System.out.print("Equipment Name : ");  
    String name = sc.nextLine();  

    System.out.print("Category : ");  
    String category = sc.nextLine();  

    System.out.print("Rent Per Day : ");  
    double rent = Double.parseDouble(sc.nextLine());  

    equipments.add(  
            new Equipment(equipmentId++, name, category, rent, true));  

    System.out.println("Equipment Added Successfully.");  
}  

// View Equipment  
public void viewEquipments() {  

    System.out.println("\n===== Equipment List =====");  

    if (equipments.isEmpty()) {  
        System.out.println("No Equipment Available.");  
        return;  
    }  

    for (Equipment e : equipments) {  

        System.out.println("--------------------------------");  

        System.out.println("ID : " + e.getId());  
        System.out.println("Name : " + e.getName());  
        System.out.println("Category : " + e.getCategory());  
        System.out.println("Rent/Day : ₹" + e.getRentPerDay());  
        System.out.println("Available : " + e.isAvailable());  
    }  
}  

// Rent Equipment  
public void rentEquipment(User renter) {  

    viewEquipments();  

    System.out.print("\nEnter Equipment ID : ");  
    int id = Integer.parseInt(sc.nextLine());  

    for (Equipment e : equipments) {  

        if (e.getId() == id && e.isAvailable()) {  

            System.out.print("Number of Days : ");  
            int days = Integer.parseInt(sc.nextLine());  

            Rental rental = new Rental(renter, e, days);  

            rentals.add(rental);  

            e.setAvailable(false);  

            System.out.println("Equipment Rented Successfully.");  
            return;  
        }  
    }  

    System.out.println("Equipment Not Available.");  
}  

// Return Equipment  
public void returnEquipment() {  

    System.out.print("\nEnter Equipment ID : ");  
    int id = Integer.parseInt(sc.nextLine());  

    for (Equipment e : equipments) {  

        if (e.getId() == id) {  

            e.setAvailable(true);  

            System.out.println("Equipment Returned Successfully.");  
            return;  
        }  
    }  

    System.out.println("Equipment Not Found.");  
}  

// Rental History  
public void rentalHistory() {  

    System.out.println("\n===== Rental History =====");  

    if (rentals.isEmpty()) {  

        System.out.println("No Rentals Found.");  
        return;  
    }  

    for (Rental r : rentals) {  

        System.out.println("----------------------------");  
        r.displayRental();  
    }  
}

}