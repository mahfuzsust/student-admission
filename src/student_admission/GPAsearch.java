/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package student_admission;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mahfuz
 */
class GPAsearch {

    DataBaseConnect d = new DataBaseConnect("root", "");
    String sq;
    double st[];
    String[] row_1,row_2;
    int i;

    public GPAsearch(double[] numbers, int N) {

        st = new double[N];

        for (i = 0; i < N; i++) {
            this.st[i] = numbers[i];
        }
        
        List<String> arrl = new ArrayList<>();
        List<String> arr2 = new ArrayList<>();
        arrl.clear();
        arr2.clear();
                
        for (i = 0; i < N; i++) {
            d.Connect();
            try {

                sq = "SELECT `GPA`, `ID` FROM `students` WHERE `total` =  " + numbers[i] + " ";
                //sq = "SELECT `GPA`, `ID` FROM  `students` WHERE CAST( `total` AS CHAR ) <=>  '" + numbers[i] + "'";
                ResultSet r = d.statement.executeQuery(sq);

                
                while (r.next()) {
                    String q = r.getString(1);
                    //System.out.println(q);
                    if (!q.equals(null)) {
                        arrl.add(q);
                    }
                    q = r.getString(2);
                    if (!q.equals(null)) {
                        arr2.add(q);
                    }
                }
                

            } catch (Exception e) {
            }
            
            
        }
        row_1 = arrl.toArray(new String[arrl.size()]);
        row_2 = arr2.toArray(new String[arr2.size()]);
    }
}
