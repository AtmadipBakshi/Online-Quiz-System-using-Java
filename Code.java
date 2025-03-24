import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OnlineExaminationSystem extends JFrame implements ActionListener {
    private JLabel questionLabel;
    private JRadioButton[] options = new JRadioButton[4];
    private ButtonGroup bg;
    private JButton nextButton;
    private int currentQuestion = 0, score = 0;

    private String[][] questions = {
            {"What is the capital of France?", "Berlin", "Madrid", "Paris", "Rome", "2"},
            {"Which planet is known as the Red Planet?", "Earth", "Mars", "Jupiter", "Saturn", "1"},
            {"What is 5 + 3?", "5", "8", "12", "15", "1"}
    };

    public OnlineExaminationSystem() {
        setTitle("Online Examination System");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        questionLabel = new JLabel();
        add(questionLabel);

        bg = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            bg.add(options[i]);
            add(options[i]);
        }

        nextButton = new JButton("Next");
        nextButton.addActionListener(this);
        add(nextButton);

        loadQuestion();
        setVisible(true);
    }

    private void loadQuestion() {
        if (currentQuestion < questions.length) {
            questionLabel.setText(questions[currentQuestion][0]);
            for (int i = 0; i < 4; i++) {
                options[i].setText(questions[currentQuestion][i + 1]);
                options[i].setSelected(false);
            }
        } else {
            showResult();
        }
    }

    private void showResult() {
        JOptionPane.showMessageDialog(this, "Quiz Over! Your Score: " + score + "/" + questions.length);
        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 4; i++) {
            if (options[i].isSelected() && Integer.parseInt(questions[currentQuestion][5]) == i) {
                score++;
            }
        }
        currentQuestion++;
        loadQuestion();
    }

    public static void main(String[] args) {
        new OnlineExaminationSystem ();
    }
}
