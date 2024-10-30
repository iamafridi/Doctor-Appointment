public class Appointment {
    private final Patient patient;
    private final Doctor doctor;
    private final String time;

    public Appointment(Patient patient, Doctor doctor, String time) {
        this.patient = patient;
        this.doctor = doctor;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Appointment Details:\n" +
                "Doctor: " + doctor.getName() + " (" + doctor.getSpecialty() + ")\n" +
                "Patient: " + patient.getName() + " (ID: " + patient.getId() + ")\n" +
                "Time: " + time;
    }
}
