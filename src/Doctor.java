import java.util.List;

public class Doctor {
    private final String name;
    private final String specialty;
    private final List<String> timeSlots;

    public Doctor(String name, String specialty, List<String> timeSlots) {
        this.name = name;
        this.specialty = specialty;
        this.timeSlots = timeSlots;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public List<String> getTimeSlots() {
        return timeSlots;
    }
}
