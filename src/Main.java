import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();

        // Adding sample doctors
        Doctor doctor1 = new Doctor("Dr. Saidul Islam", "Cardiology");
        doctor1.addAvailableTime("10:00 AM");
        doctor1.addAvailableTime("11:00 AM");

        Doctor doctor2 = new Doctor("Dr. Ishrat", "Dermatology");
        doctor2.addAvailableTime("2:00 PM");
        doctor2.addAvailableTime("3:00 PM");

        Doctor doctor3 = new Doctor("Dr. Jahin Mahtab", "Pediatrics");
        doctor3.addAvailableTime("9:00 AM");
        doctor3.addAvailableTime("1:00 PM");

        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);
        hospital.addDoctor(doctor3);

        // User interface
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Doctor Appointment System!");

        List<Doctor> doctors = null;  // Initialize doctors here

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Search Doctor by Specialty");
            System.out.println("2. Book Appointment");
            System.out.println("3. List Appointments");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    // Display available specialties
                    Set<String> specialties = hospital.getAvailableSpecialties();
                    System.out.println("Available Specialties:");
                    for (String specialty : specialties) {
                        System.out.println("- " + specialty);
                    }
                    System.out.print("Enter specialty to search for: ");
                    String selectedSpecialty = scanner.nextLine();
                    doctors = hospital.searchDoctorBySpecialty(selectedSpecialty);  // Assign the doctors list here
                    if (doctors.isEmpty()) {
                        System.out.println("No doctors found for specialty: " + selectedSpecialty);
                    } else {
                        System.out.println("Doctors found:");
                        for (int i = 0; i < doctors.size(); i++) {
                            System.out.println((i + 1) + ". " + doctors.get(i).getName() + " - Specialty: " + doctors.get(i).getSpecialty());
                        }
                    }
                    break;

                case 2:
                    if (doctors == null || doctors.isEmpty()) { // Check if doctors list is empty
                        System.out.println("Please search for doctors first.");
                        break;
                    }

                    // Allow user to select a doctor to book an appointment
                    System.out.print("Enter the number of the doctor you wish to book an appointment with: ");
                    int doctorIndex = scanner.nextInt() - 1; // adjust for zero-based indexing

                    if (doctorIndex >= 0 && doctorIndex < doctors.size()) {
                        Doctor selectedDoctor = doctors.get(doctorIndex);
                        List<String> availableTimes = hospital.getAvailableTimeSlots(selectedDoctor);

                        if (availableTimes.isEmpty()) {
                            System.out.println("No available time slots for " + selectedDoctor.getName());
                        } else {
                            System.out.println("Available time slots for " + selectedDoctor.getName() + ":");
                            for (int i = 0; i < availableTimes.size(); i++) {
                                System.out.println((i + 1) + ". " + availableTimes.get(i));
                            }

                            System.out.print("Select a time slot by number: ");
                            int timeSlotIndex = scanner.nextInt() - 1; // adjust for zero-based indexing

                            if (timeSlotIndex >= 0 && timeSlotIndex < availableTimes.size()) {
                                String selectedTime = availableTimes.get(timeSlotIndex);
                                System.out.print("Enter patient name: ");
                                scanner.nextLine(); // consume newline
                                String patientName = scanner.nextLine();
                                System.out.print("Enter patient ID: ");
                                int patientId = scanner.nextInt();
                                Patient patient = new Patient(patientName, patientId);

                                // Book the appointment
                                hospital.bookAppointment(selectedDoctor, patient, selectedTime);
                            } else {
                                System.out.println("Invalid time slot selection.");
                            }
                        }
                    } else {
                        System.out.println("Invalid doctor selection.");
                    }
                    break;

                case 3:
                    hospital.listAppointments();
                    break;

                case 4:
                    System.out.println("Exiting system.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }
}
