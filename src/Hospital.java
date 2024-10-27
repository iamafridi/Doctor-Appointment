import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hospital {
    private List<Doctor> doctors;
    private List<Patient> patients;
    private List<Appointment> appointments;

    public Hospital() {
        doctors = new ArrayList<>();
        patients = new ArrayList<>();
        appointments = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    // Retrieve a unique list of specialties from the available doctors
    public Set<String> getAvailableSpecialties() {
        Set<String> specialties = new HashSet<>();
        for (Doctor doctor : doctors) {
            specialties.add(doctor.getSpecialty());
        }
        return specialties;
    }

    public List<Doctor> searchDoctorBySpecialty(String specialty) {
        List<Doctor> result = new ArrayList<>();
        for (Doctor doctor : doctors) {
            if (doctor.getSpecialty().equalsIgnoreCase(specialty)) {
                result.add(doctor);
            }
        }
        return result;
    }

    public boolean bookAppointment(Doctor doctor, Patient patient, String time) {
        if (doctor.getAvailableTimes().contains(time)) {
            Appointment appointment = new Appointment(doctor, patient, time);
            appointments.add(appointment);
            doctor.removeAvailableTime(time);
            System.out.println("Appointment booked successfully!");
            return true;
        } else {
            System.out.println("Time slot unavailable.");
            return false;
        }
    }

    public void listAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments booked.");
        } else {
            for (Appointment appointment : appointments) {
                System.out.println(appointment);
            }
        }
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }
}
