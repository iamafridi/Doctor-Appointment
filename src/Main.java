import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hospital hospital = new Hospital();
        initializeHospitalData(hospital);

        while (true) {
            displayMainMenu();
            int choice = getValidInput(scanner, 1, 6);

            switch (choice) {
                case 1 -> listDoctors(hospital, scanner);
                case 2 -> searchDoctorBySpecialty(hospital, scanner);
                case 3 -> viewDoctorDetails(hospital, scanner);
                case 4 -> bookAppointment(hospital, scanner);
                case 5 -> viewBookedAppointments(hospital);
                case 6 -> {
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                }
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. List all doctors");
        System.out.println("2. Search doctor by specialty");
        System.out.println("3. View doctor details and available appointments");
        System.out.println("4. Book an appointment");
        System.out.println("5. View all booked appointments");
        System.out.println("6. Exit");
        System.out.print("Enter your choice (1-6): ");
    }

    private static int getValidInput(Scanner scanner, int min, int max) {
        int choice;
        while (true) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                if (choice >= min && choice <= max) {
                    break;
                }
            } else {
                scanner.next();  // Consume invalid input
            }
            System.out.print("Invalid choice. Please enter a number from " + min + " to " + max + ": ");
        }
        return choice;
    }

    private static void initializeHospitalData(Hospital hospital) {
        List<String> timeSlots = Arrays.asList("9:00 AM", "10:00 AM", "11:00 AM", "2:00 PM", "4:00 PM");

        hospital.addDoctor(new Doctor("Dr. Saidul Islam", "Dermatologist", timeSlots));
        hospital.addDoctor(new Doctor("Dr. Ishrat", "Cardiologist", timeSlots));
        hospital.addDoctor(new Doctor("Dr. Jahin Mahtab", "Pediatrician", timeSlots));
    }

    private static void listDoctors(Hospital hospital, Scanner scanner) {
        while (true) {
            System.out.println("\n--- List of All Doctors ---");
            for (int i = 0; i < hospital.getDoctors().size(); i++) {
                System.out.println((i + 1) + ". " + hospital.getDoctors().get(i).getName() + " - " + hospital.getDoctors().get(i).getSpecialty());
            }
            System.out.println((hospital.getDoctors().size() + 1) + ". Back to Main Menu");
            int choice = getValidInput(scanner, 1, hospital.getDoctors().size() + 1);

            if (choice == hospital.getDoctors().size() + 1) return;

            Doctor selectedDoctor = hospital.getDoctors().get(choice - 1);
            System.out.println("\nSelected Doctor: " + selectedDoctor.getName());
            viewAndBookAppointment(hospital, selectedDoctor, scanner);
        }
    }

    private static void searchDoctorBySpecialty(Hospital hospital, Scanner scanner) {
        System.out.print("\nEnter specialty to search: ");
        String specialty = scanner.nextLine();
        boolean found = false;
        System.out.println("\n--- Doctors with Specialty: " + specialty + " ---");
        for (Doctor doctor : hospital.getDoctors()) {
            if (doctor.getSpecialty().equalsIgnoreCase(specialty)) {
                System.out.println(doctor.getName());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No doctors found with that specialty.");
        }
    }

    private static void viewDoctorDetails(Hospital hospital, Scanner scanner) {
        listDoctors(hospital, scanner);
    }

    private static void bookAppointment(Hospital hospital, Scanner scanner) {
        listDoctors(hospital, scanner);
    }

    private static void viewBookedAppointments(Hospital hospital) {
        System.out.println("\n--- List of Booked Appointments ---");
        if (hospital.getAppointments().isEmpty()) {
            System.out.println("No appointments booked.");
        } else {
            for (Appointment appointment : hospital.getAppointments()) {
                System.out.println("Doctor: " + appointment.getDoctor().getName() + ", Patient: " + appointment.getPatient().getName() + ", Time Slot: " + appointment.getTimeSlot());
            }
        }
    }

    private static void viewAndBookAppointment(Hospital hospital, Doctor doctor, Scanner scanner) {
        while (true) {
            System.out.println("\nAvailable Time Slots for " + doctor.getName() + ":");
            for (int i = 0; i < doctor.getAvailableTimeSlots().size(); i++) {
                System.out.println((i + 1) + ". " + doctor.getAvailableTimeSlots().get(i));
            }
            System.out.println((doctor.getAvailableTimeSlots().size() + 1) + ". Back to Doctor List");
            int choice = getValidInput(scanner, 1, doctor.getAvailableTimeSlots().size() + 1);

            if (choice == doctor.getAvailableTimeSlots().size() + 1) return;

            String timeSlot = doctor.getAvailableTimeSlots().get(choice - 1);
            System.out.print("Enter patient's name for booking: ");
            String patientName = scanner.nextLine();
            Patient patient = new Patient(patientName);
            hospital.bookAppointment(patient, doctor, choice - 1);
            System.out.println("Appointment booked successfully for " + patientName + " with Dr. " + doctor.getName() + " at " + timeSlot);

            viewBookedAppointments(hospital);
            break;  // After booking, exit to view booked appointments.
        }
    }
}
