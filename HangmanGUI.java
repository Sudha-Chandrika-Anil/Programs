import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HangmanGUI extends JFrame {
    private static final String[] WORDS = {"java", "programming", "computer", "hangman", "code", "algorithm"};
    private static final int MAX_TRIES = 6;

    private String wordToGuess;
    private char[] guessedLetters;
    private int triesLeft;
    private JLabel wordLabel;
    private JLabel triesLabel;
    private JTextField letterField;
    private JButton guessButton;
    private JTextArea resultArea;

    public HangmanGUI() {
        setTitle("Hangman Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 200);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel gamePanel = new JPanel(new GridLayout(4, 1));
        JPanel hangmanPanel = new HangmanPanel(); // Custom JPanel for drawing hangman

        wordLabel = new JLabel();
        triesLabel = new JLabel();
        letterField = new JTextField(1);
        guessButton = new JButton("Guess");
        resultArea = new JTextArea();
        resultArea.setEditable(false);

        guessButton.addActionListener(new ActionListener() {
   		 public void actionPerformed(ActionEvent e) {
       		 String letter = letterField.getText().toLowerCase();
       		 if (letter.length() == 1 && Character.isLetter(letter.charAt(0))) {
            		char guess = letter.charAt(0);
           		 if (!checkGuess(guess)) {
               			 triesLeft--;
                		if (triesLeft == 0) {
                   	 	// Game over
                   			 updateUI();
               			} else {
                   		 //Incremental drawing of hangman
                   			 repaint();
               		 }
            		} else {
                	// Correct guess
                	updateUI();
            		}
       		 } else {
           		 JOptionPane.showMessageDialog(HangmanGUI.this, "Please enter a valid letter.");
        	   }
         	letterField.setText("");
  	     }
	});


        gamePanel.add(wordLabel);
        gamePanel.add(triesLabel);
        gamePanel.add(letterField);
        gamePanel.add(guessButton);

        mainPanel.add(gamePanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(resultArea), BorderLayout.CENTER);
        mainPanel.add(hangmanPanel, BorderLayout.SOUTH);

        initializeGame();
        updateUI();

        add(mainPanel);
        setVisible(true);
    }

    private void initializeGame() {
        wordToGuess = WORDS[(int) (Math.random() * WORDS.length)];
        guessedLetters = new char[wordToGuess.length()];
        triesLeft = MAX_TRIES;
        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = '_';
        }
    }

    private void updateUI() {
        wordLabel.setText("Word: " + String.valueOf(guessedLetters));
        triesLabel.setText("Tries left: " + triesLeft);
        if (triesLeft <= 0) {
            resultArea.setText("Game over! The word was: " + wordToGuess);
            guessButton.setEnabled(false);
            letterField.setEnabled(false);
        } else if (wordGuessed()) {
            resultArea.setText("Congratulations! You guessed the word!");
            guessButton.setEnabled(false);
            letterField.setEnabled(false);
        }
        repaint(); // Repaint the hangman panel
    }

    private boolean checkGuess(char guess) {
        boolean correctGuess = false;
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guess) {
                guessedLetters[i] = guess;
                correctGuess = true;
            }
        }
        if (!correctGuess) {
            resultArea.append("Incorrect guess: " + guess + "\n");
        }
        return correctGuess;
    }

    private boolean wordGuessed() {
        for (char c : guessedLetters) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    private class HangmanPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Draw the hangman figure based on the number of incorrect guesses
        switch (MAX_TRIES - triesLeft) {
            case 6:
                // Draw right leg
                g.drawLine(200, 300, 250, 370);
            case 5:
                // Draw left leg
                g.drawLine(200, 300, 150, 370);
            case 4:
                // Draw right arm
                g.drawLine(200, 180, 250, 230);
            case 3:
                // Draw left arm
                g.drawLine(200, 180, 150, 230);
            case 2:
                // Draw body
                g.drawLine(200, 150, 200, 300);
            case 1:
                // Draw head
                g.drawOval(150, 50, 100, 100);
                break;
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400); // Set preferred size for hangman panel
    }
}


    public static void main(String[] args) {
        SwingUtilities.invokeLater(HangmanGUI::new);
    }
}
