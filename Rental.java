public class Rental {

    private User renter;
    private Equipment equipment;
    private int days;
    private double totalAmount;

    public Rental(User renter, Equipment equipment, int days) {

        this.renter = renter;
        this.equipment = equipment;
        this.days = days;
        this.totalAmount = equipment.getRentPerDay() * days;
    }

    public void displayRental() {

        System.out.println("Renter : " + renter.getName());
        System.out.println("Equipment : " + equipment.getName());
        System.out.println("Days : " + days);
        System.out.println("Total : ₹" + totalAmount);
    }
}