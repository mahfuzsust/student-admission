/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package student_admission;

import java.util.Random;

/**
 *
 * @author Mahfuz
 */
public class Change {

    DataBaseConnect d = new DataBaseConnect("root", "");
    String sq;
    int st[] = new int[2000];
    int i;

    public Change() {


        int i = 1;
        int j,w,x,y,z,rum,p,q,u;
        String s,t;
        //String[] str = {"CIV", "CIV", "CSE","EEE","CHE","CIV","CIV","CIV","EEE","IPE"};
        //String[] ptr = {"CUET", "BUET", "KUET","CUET","KUET","KUET","SUST","KUET","SUST","KUET"};
        
        
            
            i = 1;

            while (i < 5900) {
                try {
                    d.Connect();
                    //sq = "UPDATE `students` SET `GPA` = ((floor((0.5 * RAND() + 4.50)*100))/100) WHERE `ID` = "+ i +"";
                    Random r = new Random();
                    //int year = 1998 + (r.nextInt(10));
                    //int day = 1 + (r.nextInt(28));
                    //int month = 1 + (r.nextInt(12));
                    //System.out.println(year +" "+ month +" "+ day);
                    //String[] str = {"CHE", "IPE", "CSE", "CIV","EEE"};

                    while(true) {
                        w = 60 + r.nextInt(20);
                        x = 60 + r.nextInt(20);
                        y = 60 + r.nextInt(20);
                        z = 60 + r.nextInt(20);
                        rum = w + x + y + z;
                        if(rum > 260 && rum < 284) break;
                    }

                    //String[] str = {"BUET", "SUST", "KUET", "CUET"};
                    //int p = 0 + r.nextInt(4);
                    //String s = str[p];
                    //UPDATE  `students` SET  `math` =10 WHERE  `dept` =  'URP' AND  `university` =  'CUET'
                    sq = "UPDATE `students` SET `math`="+w+",`phy`="+x+",`chem`="+y+",`eng`="+w+",`total`="+rum+" WHERE `dept` = 'URP' and `university` = 'CUET'";

                    //s = s.concat(year + "-" + month + "-" + day);
                    //System.out.println(s);
                    //year-month-day
                    //UPDATE `students` SET `day`= '2009-1-1' WHERE `ID` = 3
                    //sq = "UPDATE `students` SET `day`= '" + s + "' WHERE `ID` = "+ i +" ";
                    //sq = "UPDATE `students` SET `university`= '" + s + "' WHERE `ID` = "+ i +" ";
                    int update = d.statement.executeUpdate(sq);
                    i++;
                    System.out.println(i);
                } catch (Exception e) {
                    System.err.println(e);

                }
            }
        
            
        
        

    }
}
