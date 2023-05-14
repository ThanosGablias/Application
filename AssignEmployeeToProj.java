import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Κλάση για την δημιουργία παραθύρου που περιλαμβάνει την ανάθεση ενός υπαλλήλου σε κάποιο απο τα έργα της εταιρίας μέσω γραφικής διεπαφής
public class AssignEmployeeToProj {
    JFrame frame = new JFrame("Corporaze Company"); //Τίτλος πλαισίου
    private JPanel row1,row2,row3,row4,row5,row6;
    // Δημιουργία ετικετών
    private JLabel label1,label2,label3,label4,label5;
    //JTextField, είναι ένα component το οποίο μας επιτρέπει να γράψουμε σε μία γραμμή κειμένου
    private JTextField name1,name2,name3,name4,name5;

    // Δημιουργία των 2 κουμπιών
    JButton jbtn_save = new JButton("Save Employee to Project");
    JButton jbtn_new = new JButton("New Employee");

    Company company; //περέχει όλα τα δεδομένα του object company

    AssignEmployeeToProj(Company c) { //είσοδος του object company διαμέσο του Constructor
        company = c; //ανάθεση τιμής by reference

        frame.setLocationRelativeTo(null); //κεντράρει το παράθυρο στην οθόνη
        frame.setSize(1080, 720);
        frame.setLayout(null);
        frame.setVisible(true);

        row1 = new JPanel();
        label1 = new JLabel("Insert the first name of the employee: ", JLabel.RIGHT);
        name1 = new JTextField(40); // Δημιουργία χώρου για να γράψουμε με μήκος 40 χαρακτήρες

        row2 = new JPanel();
        label2 = new JLabel("Insert the last name of the employee: ", JLabel.RIGHT);
        name2 = new JTextField(40); // Δημιουργία χώρου για να γράψουμε με μήκος 40 χαρακτήρες

        row3 = new JPanel();
        label3 = new JLabel("Insert the name of the project: ", JLabel.RIGHT);
        name3 = new JTextField(40); // Δημιουργία χώρου για να γράψουμε με μήκος 40 χαρακτήρες

        row4 = new JPanel();
        label4 = new JLabel("Insert the date start of the project: ", JLabel.RIGHT);
        name4 = new JTextField(40); // Δημιουργία χώρου για να γράψουμε με μήκος 40 χαρακτήρες

        row5 = new JPanel();
        label5 = new JLabel("Insert the date end of the project: ", JLabel.RIGHT);
        name5 = new JTextField(40); // Δημιουργία χώρου για να γράψουμε με μήκος 40 χαρακτήρες

        //Δημιουργία Panel για το Button jbtn_save
        row6 = new JPanel();
        jbtn_save.setBounds(100, 160, 200, 40);
        jbtn_save.setFocusable(false);

        //καθοριμός του κώδικα που θα εκτελεστεί όταν θα πατηθεί το button και μέσω της Action Performed
        jbtn_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                company.assignEmployeeToProject(name1.getText(), name2.getText(), name3.getText(), new DateTime(name4.getText()), new DateTime(name5.getText()));
            }
        });

        //Δημιουργία Panel για το Button jbtn_new
        jbtn_new.setBounds(100, 160, 200, 40);
        jbtn_new.setFocusable(false);
        jbtn_new.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                name1.setText("");
                name2.setText("");
                name3.setText("");
                name4.setText("");
                name5.setText("");
            }
        });

        Container pane = frame.getContentPane(); // Δημιουργία υποδοχέα

        // Ο grid layout manager παρέχει ευελιξία στην τοποθέτηση components.
        // Δημιουργείτε o διαχειριστής τοποθέτησης δίνοντας το πλήθος των
        // γραμμών και των στηλών. Τα components θα γεμίσουν τα κελιά που
        // ορίζει ο διαχειριστής.
        GridLayout layout = new GridLayout(5, 2);
        pane.setLayout(layout);
        FlowLayout flo = new FlowLayout(); // Δημιουργία διαχειριστή διάταξης

        //Καθορισμός του layout για την εμφάνιση των labels και των text fields
        row1.setLayout(flo); //1η σειρά
        row1.add(label1);
        row1.add(name1);
        pane.add(row1);

        row2.setLayout(flo); //2η σειρά
        row2.add(label2);
        row2.add(name2);
        pane.add(row2);

        row3.setLayout(flo); //3η σειρά
        row3.add(label3);
        row3.add(name3);
        pane.add(row3);

        row4.setLayout(flo); //4η σειρά
        row4.add(label4);
        row4.add(name4);
        pane.add(row4);

        row5.setLayout(flo); //5η σειρά
        row5.add(label5);
        row5.add(name5);
        pane.add(row5);

        row6.setLayout(flo); //6η σειρά
        row6.add(jbtn_save);
        row6.add(jbtn_new);
        pane.add(row6);

        frame.setContentPane(pane); // Τοποθέτηση υποδοχέα στο πλαίσιο

        // Γέμισμα του πλαισίου
        // Η μέθοδος pack() αυτόματα δίνει διαστάσεις στο JFrame ανάλογα με
        // τις διαστάσεις των components που βάζουμε μέσα του και ανάλογα την
        // θέση στην οποία βάζουμε καθένα από τα components
        frame.pack();
    }
}