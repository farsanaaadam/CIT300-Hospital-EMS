public class EmergencyQueue {

    // Node for the queue (using linked list internally)
    private class QNode {
        Patient patient;
        QNode next;

        QNode(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }

    private QNode front;
    private QNode rear;

    public EmergencyQueue() {
        front = null;
        rear = null;
    }

    // ---------- ENQUEUE ----------
    public void enqueue(Patient patient) {
        QNode newNode = new QNode(patient);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println("Patient added to emergency queue: " + patient.getName());
    }

    // ---------- DEQUEUE ----------
    public Patient dequeue() {
        if (front == null) {
            System.out.println("Emergency queue is empty. No patients waiting.");
            return null;
        }
        Patient patient = front.patient;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        System.out.println("Patient dequeued for treatment: " + patient.getName());
        return patient;
    }

    // ---------- DISPLAY ----------
    public void displayQueue() {
        if (front == null) {
            System.out.println("No patients currently waiting in the emergency queue.");
            return;
        }
        System.out.println("---- Patients Waiting ----");
        QNode current = front;
        while (current != null) {
            System.out.println(current.patient.toString());
            current = current.next;
        }
    }

    // ---------- CHECK EMPTY ----------
    public boolean isEmpty() {
        return front == null;
    }
}
