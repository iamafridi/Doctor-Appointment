public class Appointment {
    private Doctor doctor;
    private Patient patient;
    private String time;

    public Appointment(Doctor doctor, Patient patient, String time) {
        this.doctor = doctor;
        this.patient = patient;
        this.time = time;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Appointment with Dr. " + doctor.getName() + " for patient " + patient.getName() + " at " + time;
    }
}
