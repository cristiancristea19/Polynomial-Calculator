package view;
import javax.swing.*;
import java.awt.*;
import controller.*;

public class View extends JFrame{
    private Controller controller;
    private JPanel panel;
    private JLabel titleLbl;
    private JLabel firstLbl;
    private JLabel secondLbl;
    private JLabel resultLblTxt;
    private JLabel restLblTxt;
    private JLabel resultLbl;
    private JLabel restLbl;
    private JTextField firstTxtFld;
    private JTextField secondTxtFld;
    private JButton addBtn;
    private JButton subBtn;
    private JButton multBtn;
    private JButton divBtn;
    private JButton derivBtn1;
    private JButton intBtn1;
    private JButton derivBtn2;
    private JButton intBtn2;
    public View()
    {
        super("Polynomial Calculator");
        controller = new Controller(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(500, 480));
        this.setLocation(500, 200);
        this.setVisible(true);
        panel = new JPanel();
        panel.setLayout(null);
        initLabels();
        initTextFields();
        initButtons();
        this.setContentPane(panel);
        this.setVisible(true);
    }

    public void initLabels()
    {
        titleLbl = new JLabel();
        titleLbl.setFont(new Font("Tahoma", Font.BOLD, 22));
        titleLbl.setBounds(130, 10, 300, 30);
        titleLbl.setText("Polynomial Calculator");
        panel.add(titleLbl);

        firstLbl = new JLabel();
        firstLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
        firstLbl.setBounds(20, 50, 200, 28);
        firstLbl.setText("First Polynomial:");
        panel.add(firstLbl);

        secondLbl = new JLabel();
        secondLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
        secondLbl.setBounds(20, 80, 200, 28);
        secondLbl.setText("Second Polynomial:");
        panel.add(secondLbl);

        resultLblTxt = new JLabel();
        resultLblTxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
        resultLblTxt.setBounds(20, 110, 200, 28);
        resultLblTxt.setText("Result:");
        resultLblTxt.setVisible(false);
        panel.add(resultLblTxt);

        restLblTxt = new JLabel();
        restLblTxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
        restLblTxt.setBounds(20, 140, 200, 28);
        restLblTxt.setText("Rest:");
        restLblTxt.setVisible(false);
        panel.add(restLblTxt);

        resultLbl = new JLabel();
        resultLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
        resultLbl.setBounds(200, 110, 270,28);
        resultLbl.setVisible(false);
        resultLbl.setForeground(Color.RED);
        panel.add(resultLbl);

        restLbl = new JLabel();
        restLbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
        restLbl.setBounds(200, 140, 270,28);
        restLbl.setForeground(Color.RED);
        restLbl.setVisible(false);
        panel.add(restLbl);
    }

    public void initTextFields()
    {
        firstTxtFld = new JTextField(45);
        firstTxtFld.setFont(new Font("Tahoma", Font.PLAIN, 15));
        firstTxtFld.setBounds(200, 50, 270,28);
        panel.add(firstTxtFld);

        secondTxtFld = new JTextField(45);
        secondTxtFld.setFont(new Font("Tahoma", Font.PLAIN, 15));
        secondTxtFld.setBounds(200, 80, 270,28);
        panel.add(secondTxtFld);
    }

    public void initButtons()
    {
        addBtn = new JButton("Add");
        addBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
        addBtn.setBounds(20, 180, 210 , 50);
        panel.add(addBtn);
        addBtn.addActionListener(controller);

        subBtn = new JButton("Substract");
        subBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
        subBtn.setBounds(260, 180, 210 , 50);
        panel.add(subBtn);
        subBtn.addActionListener(controller);

        multBtn = new JButton("Multiply");
        multBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
        multBtn.setBounds(20, 240, 210 , 50);
        panel.add(multBtn);
        multBtn.addActionListener(controller);

        divBtn = new JButton("Divide");
        divBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
        divBtn.setBounds(260, 240, 210 , 50);
        panel.add(divBtn);
        divBtn.addActionListener(controller);

        derivBtn1 = new JButton("<html><body>Derive 1<sup>st</sup> polynomial</body></html>");
        derivBtn1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        derivBtn1.setBounds(20, 300, 210 , 50);
        panel.add(derivBtn1);
        derivBtn1.addActionListener(controller);

        intBtn1 = new JButton("<html><body>Integrate 1<sup>st</sup> polynomial</body></html>");
        intBtn1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        intBtn1.setBounds(260, 300, 210 , 50);
        panel.add(intBtn1);
        intBtn1.addActionListener(controller);

        derivBtn2 = new JButton("<html><body>Derive 2<sup>nd</sup> polynomial</body></html>");
        derivBtn2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        derivBtn2.setBounds(20, 360, 210 , 50);
        panel.add(derivBtn2);
        derivBtn2.addActionListener(controller);

        intBtn2 = new JButton("<html><body>Integrate 2<sup>nd</sup>polynomial</body></html>");
        intBtn2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        intBtn2.setBounds(260, 360, 210 , 50);
        panel.add(intBtn2);
        intBtn2.addActionListener(controller);
    }

    public String getFirstPolynomial()
    {
        return firstTxtFld.getText();
    }

    public String getSecondPolynomial()
    {
        return secondTxtFld.getText();
    }

    public JButton getAddBtn()
    {
        return addBtn;
    }

    public JButton getSubBtn()
    {
        return subBtn;
    }

    public JButton getMultBtn()
    {
        return multBtn;
    }

    public JButton getDivBtn()
    {
        return divBtn;
    }

    public JButton getDerivBtn1(){
        return derivBtn1;
    }

    public JButton getIntBtn1(){
        return intBtn1;
    }

    public JButton getDerivBtn2(){
        return derivBtn2;
    }

    public JButton getIntBtn2(){
        return intBtn2;
    }

    public void warning(String text)
    {
        JOptionPane.showMessageDialog(this, text);
    }

    public void showResults(String polynomial)
    {
        resultLblTxt.setVisible(true);
        resultLbl.setVisible(true);
        resultLbl.setText(polynomial);
        restLblTxt.setVisible(false);
        restLbl.setVisible(false);
    }

    public void showResults(String polynomial1, String polynomial2)
    {
        resultLblTxt.setVisible(true);
        resultLbl.setVisible(true);
        resultLbl.setText(polynomial1);
        restLblTxt.setVisible(true);
        restLbl.setText(polynomial2);
        restLbl.setVisible(true);
    }

}
