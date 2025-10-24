import java.util.*;

// Node class for BST
class FeeNode {
    String studentId;
    String name;
    double totalFee;
    double amountPaid;
    FeeNode left, right;

    FeeNode(String id, String name, double totalFee, double amountPaid) {
        this.studentId = id;
        this.name = name;
        this.totalFee = totalFee;
        this.amountPaid = amountPaid;
    }

    double getBalance() {
        return totalFee - amountPaid;
    }
}

// BST manager
class FeeManager {
    private FeeNode root;

    // Insert record into BST
    public void addRecord(String id, String name, double totalFee, double amountPaid) {
        root = insert(root, id, name, totalFee, amountPaid);
        System.out.println("Fee record added successfully!");
    }

    private FeeNode insert(FeeNode node, String id, String name, double totalFee, double amountPaid) {
        if (node == null) return new FeeNode(id, name, totalFee, amountPaid);
        if (id.compareTo(node.studentId) < 0)
            node.left = insert(node.left, id, name, totalFee, amountPaid);
        else if (id.compareTo(node.studentId) > 0)
            node.right = insert(node.right, id, name, totalFee, amountPaid);
        else
            node.amountPaid += amountPaid;
        return node;
    }

    // Search for student
    public FeeNode search(String id) {
        FeeNode cur = root;
        while (cur != null) {
            if (cur.studentId.equals(id)) return cur;
            if (id.compareTo(cur.studentId) < 0) cur = cur.left;
            else cur = cur.right;
        }
        return null;
    }

    // Display all records (in-order)
    public void displayAll() {
        inorder(root);
    }

    private void inorder(FeeNode node) {
        if (node == null) return;
        inorder(node.left);
        System.out.println(node.studentId + " | " + node.name +
                " | Paid: " + node.amountPaid + "/" + node.totalFee +
                " | Balance: " + node.getBalance());
        inorder(node.right);
    }
}

// Main driver
public class FeeSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FeeManager fm = new FeeManager();

        while (true) {
            System.out.println("\n===== FEE TRACKING SYSTEM =====");
            System.out.println("1. Add Fee Record");
            System.out.println("2. Search Student");
            System.out.println("3. View All Records");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter Student ID: ");
                String id = sc.next();
                System.out.print("Enter Name: ");
                String name = sc.next();
                System.out.print("Enter Total Fee: ");
                double total = sc.nextDouble();
                System.out.print("Enter Amount Paid: ");
                double paid = sc.nextDouble();
                fm.addRecord(id, name, total, paid);
            } else if (choice == 2) {
                System.out.print("Enter Student ID: ");
                String id = sc.next();
                FeeNode s = fm.search(id);
                if (s != null)
                    System.out.println("Found: " + s.name + " | Paid: " + s.amountPaid + " | Balance: " + s.getBalance());
                else
                    System.out.println("Student not found!");
            } else if (choice == 3) {
                fm.displayAll();
            } else break;
        }
    }
}