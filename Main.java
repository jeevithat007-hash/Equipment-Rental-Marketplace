import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        RentalSystem system = new RentalSystem();

        while (true) {

            System.out.println("\n=================================");
            System.out.println(" EQUIPMENT RENTAL MARKETPLACE ");
            System.out.println("=================================");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    system.register();
                    break;

                case 2:

                    User currentUser = system.login();

                    if (currentUser != null) {

                        // Owner Menu
                        if (currentUser.getRole().equalsIgnoreCase("Owner")) {

                            while (true) {

                                System.out.println("\n========== OWNER MENU ==========");
                                System.out.println("1. Add Equipment");
                                System.out.println("2. View Equipments");
                                System.out.println("3. Rental History");
                                System.out.println("4. Logout");
                                System.out.print("Enter your choice: ");

                                int ownerChoice = Integer.parseInt(sc.nextLine());

                                switch (ownerChoice) {

                                    case 1:
                                        system.addEquipment();
                                        break;

                                    case 2:
                                        system.viewEquipments();
                                        break;

                                    case 3:
                                        system.rentalHistory();
                                        break;

                                    case 4:
                                        System.out.println("Logged Out Successfully.");
                                        break;

                                    default:
                                        System.out.println("Invalid Choice.");
                                }

                                if (ownerChoice == 4)
                                    break;
                            }
                        }

                        // Renter Menu
                        else {

                            while (true) {

                                System.out.println("\n========== RENTER MENU ==========");
                                System.out.println("1. View Equipments");
                                System.out.println("2. Rent Equipment");
                                System.out.println("3. Return Equipment");
                                System.out.println("4. Rental History");
                                System.out.println("5. Logout");
                                System.out.print("Enter your choice: ");

                                int renterChoice = Integer.parseInt(sc.nextLine());

                                switch (renterChoice) {

                                    case 1:
                                        system.viewEquipments();
                                        break;

                                    case 2:
                                        system.rentEquipment(currentUser);
                                        break;

                                    case 3:
                                        system.returnEquipment();
                                        break;

                                    case 4:
                                        system.rentalHistory();
                                        break;

                                    case 5:
                                        System.out.println("Logged Out Successfully.");
                                        break;

                                    default:
                                        System.out.println("Invalid Choice.");
                                }

                                if (renterChoice == 5)
                                    break;
                            }
                        }
                    }

                    break;

                case 3:
                    System.out.println("Thank You for Using Equipment Rental Marketplace!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}