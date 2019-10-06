import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayTicTakToe extends JPanel{

    private JButton[] buttons = new JButton[9];
    private int alternate = 0;

    public PlayTicTakToe() {
        setLayout(new GridLayout(3, 3));
        initializebuttons();
    }

    private void initializebuttons() {
        for(int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].setText("");
            buttons[i].addActionListener( new buttonListener() );

            add(buttons[i]);
        }
    }

    public void resetButtons() {
        for(int i = 0; i < 9; i++) {
            buttons[i].setText("");
            add(buttons[i]);
        }
    }

    private class buttonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JButton buttonClicked = (JButton)(e.getSource());

            if(buttonClicked.getText().equals("")) {
                if(alternate%2 == 0) {
                    buttonClicked.setText("X");
                } else {
                    buttonClicked.setText("O");
                }

                if( checkForWin("X") ) {
                    JOptionPane.showMessageDialog(null, "X has won");
                    resetButtons();
                    alternate = 0;
                } else if( checkForWin("O") ) {
                    JOptionPane.showMessageDialog(null, "O has won");
                    resetButtons();
                    alternate = 0;
                } else if(alternate == 8) {
                    JOptionPane.showMessageDialog(null, "Tie!");
                    resetButtons();
                    alternate = 0;
                }
                alternate++;
            }
        }

        public boolean checkForWin(String letter) {
            if( checkAdjacent(0, 1) && checkAdjacent(1, 2)) {
                if(buttons[0].getText().equals(letter)) {
                    return true;
                }
            } else if( checkAdjacent(3, 4) && checkAdjacent(4, 5)) {
                if(buttons[3].getText().equals(letter)) {
                    return true;
                }
            } else if( checkAdjacent(6, 7) && checkAdjacent(7, 8)) {
                if(buttons[6].getText().equals(letter)) {
                    return true;
                }
            } else if( checkAdjacent(0, 3) && checkAdjacent(3, 6)) {
                if(buttons[0].getText().equals(letter)) {
                    return true;
                }
            } else if( checkAdjacent(1, 4) && checkAdjacent(4, 7)) {
                if(buttons[1].getText().equals(letter)) {
                    return true;
                }
            } else if( checkAdjacent(2, 5) && checkAdjacent(5, 8)) {
                if(buttons[2].getText().equals(letter)) {
                    return true;
                }
            } else if( checkAdjacent(0, 4) && checkAdjacent(4, 8)) {
                if(buttons[0].getText().equals(letter)) {
                    return true;
                }
            } else if( checkAdjacent(2, 4) && checkAdjacent(4, 6)) {
                if(buttons[2].getText().equals(letter)) {
                    return true;
                }
            }
            return false;
        }

        public boolean checkAdjacent(int a, int b) {
            if( buttons[a].getText().equals(buttons[b].getText()) && !buttons[a].getText().equals("")) {
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("Tic-Tac-Toe");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(new PlayTicTakToe());
        window.setBounds(300,200,300,300);
        window.setVisible(true);
    }
}
