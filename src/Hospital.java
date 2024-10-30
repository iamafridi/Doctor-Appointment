import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hospital {
    private final List<Doctor> doctors = new ArrayList<>();
    private final List<Appointment> appointments = new ArrayList<>();

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public List<Doctor> findDoctorsBySpecialty(String specialty) {
        return doctors.stream()
                .filter(doctor -> doctor.getSpecialty().equalsIgnoreCase(specialty))
                .collect(Collectors.toList());
    }

    public void bookAppointment(Patient patient, Doctor doctor, String time) {
        doctor.getTimeSlots().remove(time); // Remove the time slot from the doctor's available slots
        Appointment appointment = new Appointment(patient, doctor, time);
        appointments.add(appointment);
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }
}
