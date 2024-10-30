public class Appointment {
    private final Doctor doctor;
    private final Patient patient;
    private final String timeSlot;

    public Appointment(Doctor doctor, Patient patient, String timeSlot) {
        this.doctor = doctor;
        this.patient = patient;
        this.timeSlot = timeSlot;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getTimeSlot() {
        return timeSlot;
    }
}
