import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.StrictMath.sqrt;

public class FiguryGeometryczne extends JFrame {
    private JPanel mainJPanel;
    private JRadioButton kwadratRBtn;
    private JRadioButton szescianRBtn;
    private JRadioButton prostokatRBtn;
    private JRadioButton trojkatRBtn;
    private JRadioButton trapezRBtn;
    private JRadioButton prostopadloscianRBtn;
    private JRadioButton walecRBtn;
    private JRadioButton kulaRBtn;
    private JTextField aField;
    private JTextField bField;
    private JTextField hField;
    private JTextField rField;
    private JTextField areaField;
    private JTextField cField;
    private JTextField vField;
    private JButton computeBtn;
    private JButton clrBtn;

    private double a, b, h, r, area, circumference, volume;
    private double pi = 3.141;

    public static void main(String[] args) { //glowna metoda
        FiguryGeometryczne kalk = new FiguryGeometryczne();
        kalk.setVisible(true);
    }

    public FiguryGeometryczne() {  //konstruktor
        super("Figury geometryczne - kalkulator");
        this.setContentPane(this.mainJPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        setLayout(null);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object obj = e.getSource();
                if (obj == computeBtn && kwadratRBtn.isSelected() == true) {
                    a = Double.parseDouble(aField.getText());
                    area = a * a;
                    areaField.setText(String.valueOf(area));
                } else if(obj == computeBtn && prostokatRBtn.isSelected() == true) {
                    a = Double.parseDouble(aField.getText());
                    b = Double.parseDouble(bField.getText());
                    area = a * b;
                    areaField.setText(String.valueOf(area));
                } else if(obj == computeBtn && trojkatRBtn.isSelected() == true) {
                    a = Double.parseDouble(aField.getText());
                    h = Double.parseDouble(hField.getText());
                    area = (a * h) / 2.0;
                    areaField.setText(String.valueOf(area));
                } else if(obj == computeBtn && trapezRBtn.isSelected() == true) {
                    a = Double.parseDouble(aField.getText());
                    b = Double.parseDouble(bField.getText());
                    h = Double.parseDouble(hField.getText());
                    if(b > a) {
                        area = ((a + b) * h) / 2.0;
                        circumference = a + b + (2.0 * sqrt(((b - a) * (b - a) + h * h)));
                        cField.setText(String.valueOf(circumference));
                        areaField.setText(String.valueOf(area));
                    } else if(a > b) {
                        area = ((a + b) * h) / 2.0;
                        circumference = a + b + (2.0 * sqrt(((a - b) * (a - b) + h * h)));
                        cField.setText(String.valueOf(circumference));
                        areaField.setText(String.valueOf(area));
                    } else if(a == b) {
                        area = ((a + b) * h) / 2.0;
                        circumference = 2.0 * (a + h);
                        cField.setText(String.valueOf(circumference));
                        areaField.setText(String.valueOf(area));
                    }
                } else if(obj == computeBtn && szescianRBtn.isSelected() == true) {
                    a = Double.parseDouble(aField.getText());
                    area = a * a * 6.0;
                    volume = a * a * a;
                    areaField.setText(String.valueOf(area));
                    vField.setText(String.valueOf(volume));
                } else if(obj == computeBtn && prostopadloscianRBtn.isSelected() == true) {
                    a = Double.parseDouble(aField.getText());
                    b = Double.parseDouble(bField.getText());
                    h = Double.parseDouble(hField.getText());
                    area = 2.0 * (a * b + b * h + a * h);
                    volume = a * b * h;
                    areaField.setText(String.valueOf(area));
                    vField.setText(String.valueOf(volume));
                } else if(obj == computeBtn && walecRBtn.isSelected() == true) {
                    r = Double.parseDouble(rField.getText());
                    h = Double.parseDouble(hField.getText());
                    area = 2.0 * pi * r * (r + pi * h);
                    volume = pi * r * r * h;
                    areaField.setText(String.valueOf(area));
                    vField.setText(String.valueOf(volume));
                } else if(obj == computeBtn && kulaRBtn.isSelected() == true) {
                    r = Double.parseDouble(rField.getText());
                    area = 4.0 * pi * r * r;
                    volume =  (4.0 * pi * r * r * r) / 3.0;
                    areaField.setText(String.valueOf(area));
                    vField.setText(String.valueOf(volume));
                } else if(obj == clrBtn) {
                    aField.setText("");
                    bField.setText("");
                    hField.setText("");
                    rField.setText("");
                    areaField.setText("");
                    cField.setText("");
                    vField.setText("");
                    kwadratRBtn.setSelected(false);
                    prostokatRBtn.setSelected(false);
                    trojkatRBtn.setSelected(false);
                    trapezRBtn.setSelected(false);
                    szescianRBtn.setSelected(false);
                    prostopadloscianRBtn.setSelected(false);
                    walecRBtn.setSelected(false);
                    kulaRBtn.setSelected(false);
                }
            }
        };

        computeBtn.addActionListener(listener);
        kwadratRBtn.addActionListener(listener);
        prostokatRBtn.addActionListener(listener);
        trojkatRBtn.addActionListener(listener);
        trapezRBtn.addActionListener(listener);
        szescianRBtn.addActionListener(listener);
        prostopadloscianRBtn.addActionListener(listener);
        walecRBtn.addActionListener(listener);
        kulaRBtn.addActionListener(listener);
        clrBtn.addActionListener(listener);
    }
}
