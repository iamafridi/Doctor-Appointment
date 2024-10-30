import java.util.List;

public class Doctor {
    private final String name;
    private final String specialty;
    private final List<String> availableTimeSlots;

    public Doctor(String name, String specialty, List<String> availableTimeSlots) {
        this.name = name;
        this.specialty = specialty;
        this.availableTimeSlots = availableTimeSlots;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public List<String> getAvailableTimeSlots() {
        return availableTimeSlots;
    }
}
