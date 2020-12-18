import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Panel extends JPanel {
    private JButton[] numbers = new JButton[11];
    private Font font = new Font("SanSerif", Font.BOLD,20);
    private JTextField field = new JTextField();
    private JButton backspase = new JButton("<<"),
            equ = new JButton("="),
            plus = new JButton("+"),
            minus = new JButton("-"),
            multi = new JButton("*"),
            div = new JButton("/");
    


    public Panel() {
        setLayout(null);
        numbers[0] = new JButton("0");
        numbers[0].setBounds(70, 250, 50,50);
        numbers[0].setFont(font);
        add(numbers[0]);
        numbers[10] = new JButton(".");
        numbers[10].setBounds(10, 250, 50,50);
        numbers[10].setFont(font);
        add(numbers[10]);

        setFocusable(true);
        grabFocus();

        backspase.setBounds(190, 10, 60,50);
        backspase.setFont(font);
        add(backspase);

        equ.setBounds(130, 250, 50,50);
        equ.setFont(font);
        add(equ);

        plus.setBounds(190, 70, 60,50);
        plus.setFont(font);
        add(plus);

        minus.setBounds(190, 130, 60,50);
        minus.setFont(font);
        add(minus);

        multi.setBounds(190, 190, 60,50);
        multi.setFont(font);
        add(multi);

        div.setBounds(190, 250, 60,50);
        div.setFont(font);
        add(div);

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                numbers[x + 1 + y * 3] = new JButton((x + 1 + y * 3) + "");
                numbers[x + 1 + y * 3].setBounds(x * (50 + 10) + 10, y * (50 + 10) + 70, 50,50);
                numbers[x + 1 + y * 3].setFont(font);
                add(numbers[x + 1 + y * 3]);

            }
        }

        field.setBounds(10, 10, 170, 50);
        field.setFont(font);
//        field.set
        field.setEditable(false);
        add("North", field);

        ActionListener listener = (ActionEvent e) -> {
            JButton b = (JButton) e.getSource();
            field.setText(field.getText() + b.getText());
        };

        for (JButton b : numbers) {
            b.addActionListener(listener);
        }

        addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                char symbol = e.getKeyChar();
                if (!Character.isDigit(symbol))
                    return;
                field.setText(field.getText() + symbol);

            };
        });

    }
}
