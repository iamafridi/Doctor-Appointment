public class Patient {
    private static int idCounter = 1;
    private final int id;
    private final String name;

    public Patient(String name) {
        this.name = name;
        this.id = idCounter++;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
