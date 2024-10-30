# Doctor Appointment Booking System

This Java project is a console-based application for managing doctor appointments. Users can view available doctors, search by specialty, view doctor details, book appointments, and view booked appointments.
![DoctorAppointment](https://github.com/user-attachments/assets/ac494f63-e43a-4082-b0b6-a65cd3979ba2)

## Table of Contents
- [Features](#features)
- [Project Structure](#project-structure)
- [Setup](#setup)
- [Usage](#usage)
- [How It Works](#how-it-works)
- [Contributing](#contributing)
- [License](#license)

---

## Features

- **Doctor Listing**: View a list of doctors with their specialties.
- **Doctor Search**: Search for doctors by specialty.
- **Appointment Booking**: Select a doctor and a time slot to book an appointment.
- **View Booked Appointments**: See details of all booked appointments.
- **User-Friendly Menu**: Easily navigate through options.

## Project Structure

The project contains the following key classes:

- **`Main`**: Entry point of the application, handles the user interface and menu navigation.
- **`Hospital`**: Manages doctors, patients, and appointments.
- **`Doctor`**: Stores information about doctors, including specialties and available time slots.
- **`Patient`**: Stores patient information, including name and unique ID.
- **`Appointment`**: Stores appointment details, associating a doctor, patient, and time slot.

## Setup

1. **Clone the repository**:
   ```bash
   git clone https://github.com/iamafridi/Doctor-Appointment.git
   cd Doctor-Appointment
