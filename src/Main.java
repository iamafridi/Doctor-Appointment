import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Hospital hospital = new Hospital();

    public static void main(String[] args) {
        initializeData();

        while (true) {
            showMainMenu();
            int choice = getUserChoice(1, 6);

            switch (choice) {
                case 1 -> listDoctors();
                case 2 -> searchDoctorBySpecialty();
                case 3 -> viewAndBookAppointment();
                case 4 -> bookAppointment();
                case 5 -> viewBookedAppointments();
                case 6 -> {
                    try (scanner) {
                        System.out.println("Exiting...");
                    }
                    return;
                }

                default -> System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

 
    private static void initializeData() {
        Doctor doctor1 = new Doctor("Dr. Saidul Islam", "Dermatologist", new ArrayList<>(Arrays.asList("9:00 AM", "10:00 AM", "11:00 AM")));
        Doctor doctor2 = new Doctor("Dr. Ishrat", "Cardiologist", new ArrayList<>(Arrays.asList("9:00 AM", "10:00 AM", "11:00 AM", "2:00 PM", "4:00 PM")));
        Doctor doctor3 = new Doctor("Dr. Jahin Mahtab", "Pediatrician", new ArrayList<>(Arrays.asList("9:00 AM", "12:00 PM", "3:00 PM")));
        
        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);
        hospital.addDoctor(doctor3);
    }
    

    private static void showMainMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. List all doctors");
        System.out.println("2. Search doctor by specialty");
        System.out.println("3. View doctor details and available appointments");
        System.out.println("4. Book an appointment");
        System.out.println("5. View all booked appointments");
        System.out.println("6. Exit");
        System.out.print("Enter your choice (1-6): ");
    }

    private static int getUserChoice(int min, int max) {
        int choice = -1;
        while (choice < min || choice > max) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // clear the buffer
            } else {
                System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ".");
                scanner.nextLine(); // clear the invalid input
            }
        }
        return choice;
    }

    private static void listDoctors() {
        System.out.println("\n--- List of All Doctors ---");
        List<Doctor> doctors = hospital.getDoctors();
        
        for (int i = 0; i < doctors.size(); i++) {
            System.out.println((i + 1) + ". " + doctors.get(i).getName() + " - " + doctors.get(i).getSpecialty());
        }
        System.out.println((doctors.size() + 1) + ". Back to Main Menu");

        int doctorChoice = getUserChoice(1, doctors.size() + 1);
        if (doctorChoice <= doctors.size()) {
            viewDoctorDetails(doctors.get(doctorChoice - 1));
        }
    }

    private static void viewDoctorDetails(Doctor doctor) {
        System.out.println("\n--- Doctor Details ---");
        System.out.println("Name: " + doctor.getName());
        System.out.println("Specialty: " + doctor.getSpecialty());
        System.out.println("Available Time Slots:");
        
        List<String> timeSlots = doctor.getTimeSlots();
        for (int i = 0; i < timeSlots.size(); i++) {
            System.out.println((i + 1) + ". " + timeSlots.get(i));
        }
        System.out.println((timeSlots.size() + 1) + ". Back to Doctor List");

        int slotChoice = getUserChoice(1, timeSlots.size() + 1);
        if (slotChoice <= timeSlots.size()) {
            System.out.print("Enter patient name: ");
            String patientName = scanner.nextLine();
            Patient patient = new Patient(patientName);
            hospital.bookAppointment(patient, doctor, timeSlots.get(slotChoice - 1));
            System.out.println("Appointment booked successfully!\n");

            viewBookedAppointments(); // Show booked appointments after booking
        }
    }

    private static void viewAndBookAppointment() {
        listDoctors();
    }

    private static void bookAppointment() {
        System.out.println("Please choose a doctor first from the list.");
        listDoctors();
    }

    private static void searchDoctorBySpecialty() {
        System.out.print("Enter specialty to search: ");
        String specialty = scanner.nextLine();
        List<Doctor> doctors = hospital.findDoctorsBySpecialty(specialty);
        
        if (doctors.isEmpty()) {
            System.out.println("No doctors found with specialty: " + specialty);
        } else {
            System.out.println("\n--- Search Results ---");
            for (int i = 0; i < doctors.size(); i++) {
                System.out.println((i + 1) + ". " + doctors.get(i).getName() + " - " + doctors.get(i).getSpecialty());
            }
        }
    }

    private static void viewBookedAppointments() {
        System.out.println("\n--- All Booked Appointments ---");
        List<Appointment> appointments = hospital.getAppointments();
        
        if (appointments.isEmpty()) {
            System.out.println("No appointments booked.");
        } else {
            for (Appointment appointment : appointments) {
                System.out.println(appointment);
            }
        }
    }
}
