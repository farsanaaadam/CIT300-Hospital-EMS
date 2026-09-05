import java.util.Scanner;

public class Main {

    static PatientBST bst = new PatientBST();
    static EmergencyQueue queue = new EmergencyQueue();
    static TreatmentStack stack = new TreatmentStack();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> addPatient();
                case 2 -> searchPatient();
                case 3 -> deletePatient();
                case 4 -> bst.inorderTraversal();
                case 5 -> addToQueue();
                case 6 -> treatNextPatient();
                case 7 -> queue.displayQueue();
                case 8 -> addVisitToPatient();
                case 9 -> viewPatientVisitHistory();
                case 10 -> stack.displayStack();
                case 0 -> System.out.println("Exiting system. Goodbye!");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

    static void printMenu() {
        System.out.println("\n===== Hospital Emergency Management System =====");
        System.out.println("1. Add Patient (BST)");
        System.out.println("2. Search Patient (BST)");
        System.out.println("3. Delete Patient (BST)");
        System.out.println("4. Display All Patients (Inorder Traversal)");
        System.out.println("5. Add Patient to Emergency Queue");
        System.out.println("6. Treat Next Patient (Dequeue + Push to Treatment Stack)");
        System.out.println("7. Display Waiting Queue");
        System.out.println("8. Add Visit to Patient History");
        System.out.println("9. View Patient Visit History");
        System.out.println("10. Display Treatment History (Stack)");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    static void addPatient() {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Contact Number: ");
        String contact = sc.nextLine();
        System.out.print("Enter Medical Condition: ");
        String condition = sc.nextLine();

        Patient patient = new Patient(id, name, age, contact, condition);
        bst.insert(patient);
        System.out.println("Patient added successfully.");
    }

    static void searchPatient() {
        System.out.print("Enter Patient ID to search: ");
        int id = sc.nextInt();
        Patient result = bst.search(id);
        if (result != null) {
            System.out.println("Patient Found: " + result);
        } else {
            System.out.println("Patient not found.");
        }
    }

    static void deletePatient() {
        System.out.print("Enter Patient ID to delete: ");
        int id = sc.nextInt();
        bst.delete(id);
    }

    static void addToQueue() {
        System.out.print("Enter Patient ID to add to emergency queue: ");
        int id = sc.nextInt();
        Patient patient = bst.search(id);
        if (patient == null) {
            System.out.println("Patient not found in records. Add patient first.");
            return;
        }
        queue.enqueue(patient);
    }

    static void treatNextPatient() {
        Patient patient = queue.dequeue();
        if (patient != null) {
            String record = "Patient: " + patient.getName() + " (ID: " + patient.getPatientId() +
                             ") - Condition: " + patient.getMedicalCondition();
            stack.push(record);
        }
    }

    static void addVisitToPatient() {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        Patient patient = bst.search(id);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }
        System.out.print("Enter Visit ID: ");
        int visitId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Visit Date: ");
        String date = sc.nextLine();
        System.out.print("Enter Doctor Name: ");
        String doctor = sc.nextLine();
        System.out.print("Enter Diagnosis: ");
        String diagnosis = sc.nextLine();
        System.out.print("Enter Treatment: ");
        String treatment = sc.nextLine();

        patient.getVisitHistory().addVisit(visitId, date, doctor, diagnosis, treatment);
    }

    static void viewPatientVisitHistory() {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        Patient patient = bst.search(id);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }
        patient.getVisitHistory().displayHistory();
    }
}       