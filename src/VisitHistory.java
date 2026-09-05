public class VisitHistory {
    private VisitNode head;

    public VisitHistory() {
        this.head = null;
    }

    // Add a new visit at the end of the list
    public void addVisit(int visitId, String visitDate, String doctorName, String diagnosis, String treatment) {
        VisitNode newNode = new VisitNode(visitId, visitDate, doctorName, diagnosis, treatment);
        if (head == null) {
            head = newNode;
        } else {
            VisitNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        System.out.println("Visit added successfully.");
    }

    // Remove a visit by visitId
    public void removeVisit(int visitId) {
        if (head == null) {
            System.out.println("No visit history found.");
            return;
        }
        if (head.getVisitId() == visitId) {
            head = head.getNext();
            System.out.println("Visit removed successfully.");
            return;
        }
        VisitNode current = head;
        while (current.getNext() != null && current.getNext().getVisitId() != visitId) {
            current = current.getNext();
        }
        if (current.getNext() == null) {
            System.out.println("Visit ID not found.");
        } else {
            current.setNext(current.getNext().getNext());
            System.out.println("Visit removed successfully.");
        }
    }

    // Search for a visit by visitId
    public VisitNode searchVisit(int visitId) {
        VisitNode current = head;
        while (current != null) {
            if (current.getVisitId() == visitId) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    // Display all visits
    public void displayHistory() {
        if (head == null) {
            System.out.println("No visit history available.");
            return;
        }
        VisitNode current = head;
        System.out.println("---- Visit History ----");
        while (current != null) {
            System.out.println(current.toString());
            current = current.getNext();
        }
    }
}