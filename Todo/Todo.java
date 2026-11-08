package Todo;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.Font;

import java.util.ArrayList;

public class Todo{
    public static void main(String[] args){
        ArrayList<String> todoItems = new ArrayList<>();

        JFrame frame = new JFrame("Todo App");
        frame.setSize(450, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel inputPanel = new JPanel();

        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));

        JLabel text = new JLabel("Enter Task: ");
        text.setFont(new Font("times new roman", Font.BOLD, 20));
;
        JTextField input = new JTextField();
        input.setPreferredSize(new Dimension(200, 30));

        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> {
            add(todoItems, input.getText());
            display(todoItems, displayPanel);
            input.setText("");
        });


        display(todoItems, displayPanel);
        

        inputPanel.add(text);
        inputPanel.add(input);
        inputPanel.add(addButton);


        mainPanel.add(inputPanel);
        mainPanel.add(displayPanel);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    static void add(ArrayList<String> list, String task){
        //for(int i = 0; i < list.size(); i++){
            //if(list.get(i) == null){
                list.add(task);
                //System.out.println(list.get(i));
                //break;
            //}
        //}
    }

    static void display(ArrayList<String> list, JPanel disPanel){
        disPanel.removeAll();
        for(int i=0; i < list.size(); i++){
            if(list.get(i) != null){
                int index = i;
                JPanel panel = new JPanel();
                JLabel label = new JLabel(list.get(i));
                label.setFont(new Font("sans serif", Font.ITALIC, 17));
                JButton delButton = new JButton("Delete");
                delButton.addActionListener(e -> {
                    delete(list, index);
                    display(list, disPanel);
                });

                panel.add(label);
                panel.add(delButton);
                disPanel.add(panel);
            }
        }
        disPanel.revalidate();
        disPanel.repaint();
    }

    static void delete(ArrayList<String> list,int index){
        list.remove(index);
    }
}