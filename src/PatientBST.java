public class PatientBST {

    // Inner class representing a node in the BST
    private class Node {
        Patient patient;
        Node left, right;

        Node(Patient patient) {
            this.patient = patient;
            left = null;
            right = null;
        }
    }

    private Node root;

    public PatientBST() {
        root = null;
    }

    // ---------- INSERT ----------
    public void insert(Patient patient) {
        root = insertRec(root, patient);
    }

    private Node insertRec(Node root, Patient patient) {
        if (root == null) {
            return new Node(patient);
        }
        if (patient.getPatientId() < root.patient.getPatientId()) {
            root.left = insertRec(root.left, patient);
        } else if (patient.getPatientId() > root.patient.getPatientId()) {
            root.right = insertRec(root.right, patient);
        } else {
            System.out.println("Patient ID already exists. Insert skipped.");
        }
        return root;
    }

    // ---------- SEARCH ----------
    public Patient search(int patientId) {
        Node result = searchRec(root, patientId);
        return (result != null) ? result.patient : null;
    }

    private Node searchRec(Node root, int patientId) {
        if (root == null || root.patient.getPatientId() == patientId) {
            return root;
        }
        if (patientId < root.patient.getPatientId()) {
            return searchRec(root.left, patientId);
        }
        return searchRec(root.right, patientId);
    }

    // ---------- DELETE ----------
    public void delete(int patientId) {
        root = deleteRec(root, patientId);
    }

    private Node deleteRec(Node root, int patientId) {
        if (root == null) {
            System.out.println("Patient ID not found.");
            return root;
        }

        if (patientId < root.patient.getPatientId()) {
            root.left = deleteRec(root.left, patientId);
        } else if (patientId > root.patient.getPatientId()) {
            root.right = deleteRec(root.right, patientId);
        } else {
            // Node found - handle 3 cases

            // Case 1: No child (leaf node)
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2: One child
            else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Case 3: Two children - find inorder successor (smallest in right subtree)
            else {
                Node successor = findMin(root.right);
                root.patient = successor.patient;
                root.right = deleteRec(root.right, successor.patient.getPatientId());
            }
        }
        return root;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // ---------- INORDER TRAVERSAL ----------
    public void inorderTraversal() {
        if (root == null) {
            System.out.println("No patient records available.");
            return;
        }
        System.out.println("---- Patient Records (Ascending Order of ID) ----");
        inorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.patient.toString());
            inorderRec(root.right);
        }
    }
}
