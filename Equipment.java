public class Equipment {

    private int id;
    private String name;
    private String category;
    private double rentPerDay;
    private boolean available;

    public Equipment(int id, String name, String category,
                     double rentPerDay, boolean available) {

        this.id = id;
        this.name = name;
        this.category = category;
        this.rentPerDay = rentPerDay;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getRentPerDay() {
        return rentPerDay;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}