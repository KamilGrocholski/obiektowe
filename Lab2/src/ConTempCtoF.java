import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConTempCtoF extends JFrame{
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton wyczyscButton;
    private JButton wyjscieButton;
    private JButton konwertujButton;
    private JRadioButton mczButton;
    private JRadioButton sczButton;
    private JRadioButton dczButton;
    private JCheckBox wielkieCheck;
    private JButton resetujButton;

    private double tempC, tempF;

    public static void main(String[] args) {
        ConTempCtoF conTemp = new ConTempCtoF();
        conTemp.setVisible(true);
    }

    public ConTempCtoF() {
        super("Konwertowanie stopni C -> F");
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        setLayout(null);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object ob1 = e.getSource();
                if(ob1 == konwertujButton || ob1 == textField1) {
                    tempC = Double.parseDouble(textField1.getText());
                    tempF = 32.00 + (9.0 / 5.0) * tempC;
                    textField2.setText(String.valueOf(tempF));
                } else if(ob1 == wyczyscButton){
                    textField1.setText("");
                    textField2.setText("");
                    if(wielkieCheck.isSelected()) wielkieCheck.setSelected(false);
                    else if(mczButton.isSelected() == true) mczButton.setSelected(false);
                    else if(sczButton.isSelected() == true) sczButton.setSelected(false);
                    else if(dczButton.isSelected() == true) dczButton.setSelected(false);
                } else if(ob1 == wyjscieButton) dispose();
                else if(ob1 == wielkieCheck)
                    if (wielkieCheck.isSelected() == true) textField2.setFont(new Font("SansSerif", Font.BOLD, 18));
                    else textField2.setFont(new Font("SansSerif", Font.PLAIN, 12));
                else if(ob1 == mczButton) textField2.setFont(new Font("SansSerif", Font.PLAIN, 8));
                else if(ob1 == sczButton) textField2.setFont(new Font("SansSerif", Font.PLAIN, 12));
                else if(ob1 == dczButton) textField2.setFont(new Font("SansSerif", Font.PLAIN, 20));
        }
    };
        konwertujButton.addActionListener(listener);
        wyczyscButton.addActionListener(listener);
        wyjscieButton.addActionListener(listener);
        resetujButton.addActionListener(listener);
        mczButton.addActionListener(listener);
        sczButton.addActionListener(listener);
        dczButton.addActionListener(listener);
        wielkieCheck.addActionListener(listener);
}}




