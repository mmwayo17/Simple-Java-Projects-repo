package Calculator;
import jdk.jshell.JShell;
import jdk.jshell.SnippetEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.GridLayout;

public class Calculator{
    public static void main(String[] args){
        Font font = new Font("sans serif", Font.BOLD, 30);
        JFrame frame = new JFrame("Calculator");

        JTextField label = new JTextField();
        //label.setBounds(50, 25, 300, 200);
        label.setFont(font);
        label.setEditable(false);

        JPanel panel = new JPanel();

        frame.setLayout(new GridLayout(2, 1));
        frame.add(label);
        frame.add(panel);

        String[] buttons = {"C", "(", ")", "/", "7", "8", "9", "*", "4", "5", "6", "-", "1", "2", "3", "+", "%", "0", ".", "="};
        for(int i=0; i < buttons.length; i++){
            JButton button = new JButton(buttons[i]);
            button.addActionListener(e -> {
                switch (button.getText()){
                    case "=":
                        label.setText(calculate(label.getText()));
                        break;
                    case "C":
                        label.setText("");
                        break;
                    default:
                        label.setText(label.getText() + button.getText());
            }}
            );
            panel.setLayout(new GridLayout(5, 4));
            panel.add(button);
        }

        frame.setSize(400, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    static String calculate(String eqn){
        
        try(JShell jshell = JShell.create()){
            List<SnippetEvent> events = jshell.eval(eqn);
            for(SnippetEvent event: events){
                if(event.value() != null){
                    double result = Double.parseDouble(event.value());
                    return String.valueOf(result);
                }
            }

            return "0";
        }
    }
}