import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private final List<Doctor> doctors;
    @SuppressWarnings("unused")
    private final List<Patient> patients;
    private final List<Appointment> appointments;

    public Hospital() {
        doctors = new ArrayList<>();
        patients = new ArrayList<>();
        appointments = new ArrayList<>();
    }

    // Add doctor to the list
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    // Getter for doctors list
    public List<Doctor> getDoctors() {
        return doctors;
    }

    // Method to search doctors by specialty
    public List<Doctor> searchDoctorBySpecialty(String specialty) {
        List<Doctor> result = new ArrayList<>();
        for (Doctor doctor : doctors) {
            if (doctor.getSpecialty().equalsIgnoreCase(specialty)) {
                result.add(doctor);
            }
        }
        return result;
    }

    // Method to book an appointment
    public void bookAppointment(Patient patient, Doctor doctor, int timeSlotIndex) {
        String timeSlot = doctor.getAvailableTimeSlots().get(timeSlotIndex);
        Appointment appointment = new Appointment(doctor, patient, timeSlot);
        appointments.add(appointment);
        doctor.getAvailableTimeSlots().remove(timeSlotIndex); // Mark timeslot as booked
        System.out.println("Appointment booked successfully for " + patient.getName() + " with " + doctor.getName() + " at " + timeSlot);
    }

    // Method to get the list of appointments
    public List<Appointment> getAppointments() {
        return appointments;
    }
}
