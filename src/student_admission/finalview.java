/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package student_admission;

import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Mahfuz
 */
class finalview {
    
    JFrame f = new JFrame("University And Department");
    JTextField jt;
    public finalview(String university, String department) {
        f.setVisible(true);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500, 500);
        
        String S = "";
        if(university == null && department == null) S = S.concat("You Are Not Eligible For Any University");
        
        else {
            S = S.concat(university);
            S = S.concat(" ");
            S = S.concat(department);
        }
        
        jt = new JTextField(S);
        f.add(jt);
        jt.setBounds(10, 10, 200, 100);
        jt.setEditable(false);
        
    }
    
}
