import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private String name;
    private String specialty;
    private List<String> availableTimes;

    public Doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
        this.availableTimes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public List<String> getAvailableTimes() {
        return availableTimes;
    }

    public void addAvailableTime(String time) {
        availableTimes.add(time);
    }

    public void removeAvailableTime(String time) {
        availableTimes.remove(time);
    }
}
