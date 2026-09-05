public class TreatmentStack {

    // Node for the stack (using linked list internally)
    private class SNode {
        String treatmentRecord;
        SNode next;

        SNode(String treatmentRecord) {
            this.treatmentRecord = treatmentRecord;
            this.next = null;
        }
    }

    private SNode top;

    public TreatmentStack() {
        top = null;
    }

    // ---------- PUSH ----------
    public void push(String treatmentRecord) {
        SNode newNode = new SNode(treatmentRecord);
        newNode.next = top;
        top = newNode;
        System.out.println("Treatment record added: " + treatmentRecord);
    }

    // ---------- POP ----------
    public String pop() {
        if (top == null) {
            System.out.println("Treatment history is empty. Nothing to remove.");
            return null;
        }
        String record = top.treatmentRecord;
        top = top.next;
        System.out.println("Removed most recent treatment record: " + record);
        return record;
    }

    // ---------- DISPLAY ----------
    public void displayStack() {
        if (top == null) {
            System.out.println("No treatment records available.");
            return;
        }
        System.out.println("---- Treatment History (Most Recent First) ----");
        SNode current = top;
        while (current != null) {
            System.out.println(current.treatmentRecord);
            current = current.next;
        }
    }

    // ---------- CHECK EMPTY ----------
    public boolean isEmpty() {
        return top == null;
    }
}
