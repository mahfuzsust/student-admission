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
class Search {
    
    DataBaseConnect d = new DataBaseConnect("root", "");
    String[] row_1;
    String sq;
    double total,gpa_value;
    double[] to;
    double[] numbers;
    int [] flag = new int[30];
    String department, university;
    
    public Search(double sum, double value_gpa) {
        this.total = sum;
        this.gpa_value = value_gpa;
        
        try {
            d.Connect();
            row_1 = new String[10000];
            
            System.out.println("a;lskdfjalkdfjalksdfjalksdfjlaksdfjalksdfjalksdfjalkdfjasdklfj");

            //for(int i = 0; i<str_university.length; i++) {
                    //System.out.println(s);
                    // s  = "37444";
                    //sq = "SELECT  FROM `car` WHERE `buy_amount` = '" + s + "'";
                    sq = "SELECT  `total` FROM  `students`";
                    //int update = d.statement.executeUpdate(sq);
                    ResultSet r = d.statement.executeQuery(sq);

                    List<String> arrl = new ArrayList<>();
                    arrl.clear();
                    while (r.next()) {
                        String q = r.getString(1);
                        if (!q.equals(null)) {
                            arrl.add(q);
                        }
                    }                    
                    row_1 = arrl.toArray(new String[arrl.size()]);
                    //System.out.println(i +" "+ str_university[i]);
                    
            //}
            
            
        }catch (Exception e) {
            System.err.println(e);
        }
        //for(int i = 0; i < row_1.length; i++) System.out.println(row_1[i]);
        view();
        
    }

    private void view() {
        
        N_K_Means n = new N_K_Means(row_1, row_1.length, 20);
        
        double dist = 999999;
        int p=0,x = 0;
        for (int i = 0; i < 20; i++) {            
            double q = Math.abs(n.cls[i] - total);
            if (q <= dist) {
                dist = q;
                p = i;
                x = (int) n.cls[i];
            }
        }
        
        numbers = new double[n.store[p].length];
        int i;
        
        for(i = 0 ; n.store[p][i] != 0.0; i++) 
        {
            numbers[i] = n.store[p][i];
        }
        
        to = new double[n.x[p]];
        
        System.out.println(p + " " + n.x[p] + " " + x);
        
        for(i = 0 ; numbers[i] != 0; i++) 
        {
            System.out.print(numbers[i] + " ");
        }
        
        System.out.println(i);
        System.out.println("++++++++++++++++++++++++safd++++++++++++++++++++");
        
        GPAsearch gpa = new GPAsearch(numbers,i);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        for(i = 0; i < gpa.row_1.length; i++)
        {
            System.out.println(gpa.row_2[i] + " " + gpa.row_1[i]);
        }
        
        
        System.out.println("GPA clustering++++++++++++++++++++++++++++++++++++++++++++");
        
        //n =new N_K_Means(gpa.row_1, gpa.row_1.length, 5);
        K_Means km = new K_Means(gpa.row_1, gpa.row_2, gpa.row_1.length, 5);
        
        dist = 999999;
        p = 0;
        x = 0;
        for (i = 0; i < 5; i++) {            
            double q = Math.abs(km.cls[i] - gpa_value);
            if (q <= dist) {
                dist = q;
                p = i;
                x = (int) km.cls[i];
            }
        }
        
        numbers = new double[km.store[p].length];
        int[] id_numbers = new int[km.store_id[p].length]; 
        
        for(i = 0 ; km.store[p][i] != 0.0; i++) 
        {
            numbers[i] = km.store[p][i];
        }
        for(i = 0 ; km.store_id[p][i] != 0.0; i++) 
        {
            id_numbers[i] = (int) km.store_id[p][i];
        }
        
        to = new double[km.x[p]];
        
        System.out.println(p + " " + km.x[p] + " " + x);
        
        for(i = 0 ; numbers[i] != 0; i++) 
        {
            System.out.println(id_numbers[i] + " " + numbers[i]);
        }
        
        System.out.println(i);
        
        System.out.print("+++++++++++++++Department+University+++++++++++++");
        
        Choose_Section ch = new Choose_Section(id_numbers,i);
        
        for(i = 0; i < ch.row_1.length; i++) {
            System.out.println(ch.row_1[i] + " " + ch.row_2[i]);
        }
        
        for(i = 0; i < flag.length; i++) {
            flag[i] = 0;
        }
        
        for(i = 0; i < ch.row_1.length; i++) {
            
            if("BUET".equals(ch.row_1[i]) && "EEE".equals(ch.row_2[i])) flag[0] = flag[0] + 1;
            if("BUET".equals(ch.row_1[i]) && "CSE".equals(ch.row_2[i])) flag[1] = flag[1] + 1;
            if("SUST".equals(ch.row_1[i]) && "CSE".equals(ch.row_2[i])) flag[2] = flag[2] + 1;
            if("BUET".equals(ch.row_1[i]) && "IPE".equals(ch.row_2[i])) flag[3] = flag[3] + 1;
            if("SUST".equals(ch.row_1[i]) && "IPE".equals(ch.row_2[i])) flag[4] = flag[4] + 1;
            if("BUET".equals(ch.row_1[i]) && "CHE".equals(ch.row_2[i])) flag[5] = flag[5] + 1;
            if("KUET".equals(ch.row_1[i]) && "EEE".equals(ch.row_2[i])) flag[6] = flag[6] + 1;
            if("CUET".equals(ch.row_1[i]) && "CSE".equals(ch.row_2[i])) flag[7] = flag[7] + 1;
            if("SUST".equals(ch.row_1[i]) && "CHE".equals(ch.row_2[i])) flag[8] = flag[8] + 1;
            if("CUET".equals(ch.row_1[i]) && "CIV".equals(ch.row_2[i])) flag[9] = flag[9] + 1;
            if("BUET".equals(ch.row_1[i]) && "CIV".equals(ch.row_2[i])) flag[10] = flag[10] + 1;
            if("KUET".equals(ch.row_1[i]) && "CSE".equals(ch.row_2[i])) flag[11] = flag[11] + 1;
            if("CUET".equals(ch.row_1[i]) && "EEE".equals(ch.row_2[i])) flag[12] = flag[12] + 1;
            if("KUET".equals(ch.row_1[i]) && "CHE".equals(ch.row_2[i])) flag[13] = flag[13] + 1;
            if("KUET".equals(ch.row_1[i]) && "CIV".equals(ch.row_2[i])) flag[14] = flag[14] + 1;
            if("SUST".equals(ch.row_1[i]) && "CIV".equals(ch.row_2[i])) flag[15] = flag[15] + 1;
            if("SUST".equals(ch.row_1[i]) && "EEE".equals(ch.row_2[i])) flag[16] = flag[16] + 1;
            if("KUET".equals(ch.row_1[i]) && "IPE".equals(ch.row_2[i])) flag[17] = flag[17] + 1;
            if("CUET".equals(ch.row_1[i]) && "URP".equals(ch.row_2[i])) flag[18] = flag[18] + 1;
        }
        
        dist = 0;
        int count = 9999;
        for(i = 0; i < flag.length; i++) {
            if(flag[i] >= dist)
            {
                dist = flag[i];
                count = i;
            }
        }
        
        if(count == 0) {
            university = "BUET";
            department = "EEE";            
        }
        if(count == 1) {
            university = "BUET";
            department = "CSE";            
        }
        if(count == 2) {
            university = "SUST";
            department = "CSE";            
        }
        if(count == 3) {
            university = "BUET";
            department = "IPE";            
        }
        if(count == 4) {
            university = "SUST";
            department = "IPE";            
        }
        if(count == 5) {
            university = "BUET";
            department = "CHE";            
        }
        if(count == 6) {
            university = "KUET";
            department = "EEE";            
        }
        if(count == 7) {
            university = "CUET";
            department = "CSE";            
        }
        if(count == 8) {
            university = "SUST";
            department = "CHE";            
        }
        if(count == 9) {
            university = "KUET";
            department = "CIV";            
        }
        if(count == 10) {
            university = "BUET";
            department = "CIV";            
        }
        if(count == 11) {
            university = "KUET";
            department = "CSE";            
        }
        if(count == 12) {
            university = "CUET";
            department = "EEE";            
        }
        if(count == 13) {
            university = "KUET";
            department = "CHE";            
        }
        if(count == 14) {
            university = "KUET";
            department = "CIV";            
        }
        if(count == 15) {
            university = "SUST";
            department = "CIV";            
        }
        if(count == 16) {
            university = "SUST";
            department = "EEE";            
        }
        if(count == 17) {
            university = "KUET";
            department = "IPE";            
        }
        if(count == 18) {
            university = "CUET";
            department = "URP";            
        }
        if(count == 19) {
            university = "";
            department = "";            
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(university + " " + department);
        
        finalview fv = new finalview(university, department);
        
        
    }
    
    
    
}
