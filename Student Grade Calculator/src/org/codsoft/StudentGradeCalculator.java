package org.codsoft;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGradeCalculator extends JFrame {

    private JLabel[] labels;
    private JTextField[] textFields;
    private JButton calculateButton;
    private JTextArea resultArea;

    private String[] subjects = {"Physics", "Chemistry", "Mathematics", "English", "Computers"};

    public StudentGradeCalculator() {
        setTitle("Student Grade Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Initialize components
        labels = new JLabel[5];
        textFields = new JTextField[5];
        for (int i = 0; i < 5; i++) {
            labels[i] = new JLabel(subjects[i] + " Marks:");
            labels[i].setBounds(50, 30 + i * 30, 100, 20);
            add(labels[i]);

            textFields[i] = new JTextField();
            textFields[i].setBounds(160, 30 + i * 30, 100, 20);
            add(textFields[i]);
        }

        calculateButton = new JButton("Calculate");
        calculateButton.setBounds(120, 180, 120, 30);
        add(calculateButton);

        resultArea = new JTextArea();
        resultArea.setBounds(50, 220, 300, 50);
        resultArea.setEditable(false);
        add(resultArea);

        // Add action listener to calculate button
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateGrade();
            }
        });

        setVisible(true);
    }

    private void calculateGrade() {
        int totalMarks = 0;
        int subjectsCount = 0;

        for (int i = 0; i < 5; i++) {
            try {
                int marks = Integer.parseInt(textFields[i].getText());
                totalMarks += marks;
                subjectsCount++;
            } catch (NumberFormatException e) {
                // Handle invalid input
                resultArea.setText("Invalid input. Please enter valid marks for all subjects.");
                return;
            }
        }

        double averagePercentage = (double) totalMarks / subjectsCount;
        String grade = calculateGradeFromPercentage(averagePercentage);

        resultArea.setText("Total Marks: " + totalMarks + "\nAverage Percentage: " + averagePercentage + "%\nGrade: " + grade);
    }

    private String calculateGradeFromPercentage(double percentage) {
        if (percentage >= 90) {
            return "A";
        } else if (percentage >= 80) {
            return "B";
        } else if (percentage >= 70) {
            return "C";
        } else if (percentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        new StudentGradeCalculator();
    }
}
