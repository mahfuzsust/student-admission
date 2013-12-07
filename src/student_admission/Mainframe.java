/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package student_admission;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Mahfuz
 */
class Mainframe implements ActionListener{

    JFrame frame = new JFrame("First Page");
    JLabel gpa = new JLabel("GPA: ");
    JLabel test_math = new JLabel("Math: ");
    JLabel test_physics = new JLabel("Physics: ");
    JLabel test_chemistry = new JLabel("Chemistry: ");
    JLabel test_english = new JLabel("English: ");
    
    JTextField gpa_value = new JTextField("4.70");
    JTextField test_math_value = new JTextField("130");
    JTextField test_physics_value = new JTextField("120");
    JTextField test_chemistry_value = new JTextField("125");
    JTextField test_english_value = new JTextField("127");
    
    String math , physics = "", chemistry = "", english = "";
    double a,b,c,d,sum;
    
    JButton submit =new JButton("SUBMIT");
    
    public Mainframe() {
        view();
    }
    
    private void view() {
        
        frame.setVisible(true);
        frame.setBounds(10, 10, 500, 500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(gpa);
        gpa.setBounds(20, 20, 100, 30);
        
        frame.add(gpa_value);
        gpa_value.setBounds(150, 20, 100, 30);
        
        frame.add(test_math);
        test_math.setBounds(20, 60, 100, 30);
        
        frame.add(test_math_value);
        test_math_value.setBounds(150, 60, 100, 30);
        math = test_math_value.getText();
        test_math_value.addActionListener(this);
        
        
        frame.add(test_physics);
        test_physics.setBounds(20,100, 100, 30);
        
        frame.add(test_physics_value);
        test_physics_value.setBounds(150, 100, 100, 30);
        
        
        frame.add(test_chemistry);
        test_chemistry.setBounds(20, 140, 100, 30);  
        
        frame.add(test_chemistry_value);
        test_chemistry_value.setBounds(150, 140, 100, 30);
        
        

        frame.add(test_english);
        test_english.setBounds(20, 180, 100, 30);
        
        frame.add(test_english_value);
        test_english_value.setBounds(150, 180, 100, 30);
        
        
        frame.add(submit);
        submit.setBounds(150, 300, 100, 30);
        submit.addActionListener(this);
        
        
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String value_gpa = gpa_value.getText();
        math = test_math_value.getText();
        physics = test_physics_value.getText();
        chemistry = test_chemistry_value.getText();
        english = test_english_value.getText();
        
        a = Double.parseDouble(math);
        b = Double.parseDouble(physics);
        c = Double.parseDouble(chemistry);
        d = Double.parseDouble(english);
        double gpa_value = Double.parseDouble(value_gpa);
        
        sum = a + b + c + d;
        
        if(e.getSource() == submit)
        {
            System.out.println(math + " " + physics + " " +chemistry+ " " + english);
            Search sc = new Search(sum,gpa_value);
            
        }
        if(e.getSource() == test_math_value)
        {
            math = test_math_value.getText();
        }
    }

    
    
}
