/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

/**
 *
 * @author Katie
 */
import java.util.LinkedHashMap;
import java.util.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
public class ToDoList extends JPanel {
    static private LinkedHashMap<String, ArrayList<Task>> recurringTasks;
    public ToDoList (LinkedHashMap<String, ArrayList<Task>> map){
        setPreferredSize(new Dimension(1050,600)); 
        setLayout(new GridLayout(1,7));
        Calendar cal = Calendar.getInstance();
        String date = cal.get(Calendar.YEAR) + "_" + cal.get(Calendar.MONTH) + "_" + cal.get(Calendar.YEAR);
        ArrayList<Task> theList = recurringTasks.get(date);
        JPanel mon = new JPanel();
        mon.setPreferredSize(new Dimension(150,600));
        JCheckBox monFirstText = new JCheckBox(theList.get(0).toString());
        monFirstText.setPreferredSize(new Dimension(148,75));
        monFirstText.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                theList.get(0).setCompleted();
            }
        });
        JLabel monFirstField = new JLabel(theList.get(0).getDescription());
        monFirstField.setPreferredSize(new Dimension(150,70));
        JCheckBox monSecondText = new JCheckBox(theList.get(1).toString());
        monSecondText.setPreferredSize(new Dimension(148,70));
        monSecondText.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                theList.get(1).setCompleted();
            }
        });
        JLabel monSecondField = new JLabel(theList.get(1).getDescription());
        monSecondField.setPreferredSize(new Dimension(150,70));
        JCheckBox monThirdText = new JCheckBox(theList.get(2).toString());
        monThirdText.setPreferredSize(new Dimension(148,70));
        monThirdText.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                theList.get(2).setCompleted();
            }
        });
        JLabel monThirdField = new JLabel(theList.get(2).getDescription());
        monThirdField.setPreferredSize(new Dimension(150,70));
        JCheckBox monFourthText = new JCheckBox(theList.get(3).toString());
        monFourthText.setPreferredSize(new Dimension(148,70));
        monFourthText.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                theList.get(3).setCompleted();
            }
        });
        JLabel monFourthField = new JLabel(theList.get(3).getDescription());
        monFourthField.setPreferredSize(new Dimension(150,70));
        
        mon.add(monFirstText);
        mon.add(monFirstField);
        mon.add(monSecondText);
        mon.add(monSecondField);
        mon.add(monThirdText);
        mon.add(monThirdField);
        mon.add(monFourthText);
        mon.add(monFourthField);
        
        JPanel tues = new JPanel();
        tues.setPreferredSize(new Dimension(150,600));  
        JCheckBox tuesFirstText = new JCheckBox(theList.get(0).toString());
        tuesFirstText.setPreferredSize(new Dimension(148,75));
        tuesFirstText.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                theList.get(0).setCompleted();
            }
        });
        JLabel tuesFirstField = new JLabel(theList.get(0).getDescription());
        tuesFirstField.setPreferredSize(new Dimension(150,70));
        
        tues.add(tuesFirstText);
        tues.add(tuesFirstField);
        
        JPanel wed = new JPanel();
        wed.setPreferredSize(new Dimension(150,600));
        JCheckBox wedFirstText = new JCheckBox(theList.get(0).toString());
        wedFirstText.setPreferredSize(new Dimension(148,75));
        wedFirstText.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                theList.get(0).setCompleted();
            }
        });
        JLabel wedFirstField = new JLabel(theList.get(0).getDescription());
        wedFirstField.setPreferredSize(new Dimension(150,70));
        JCheckBox wedSecondText = new JCheckBox(theList.get(1).toString());
        wedSecondText.setPreferredSize(new Dimension(148,70));
        wedSecondText.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                theList.get(1).setCompleted();
            }
        });
        JLabel wedSecondField = new JLabel(theList.get(1).getDescription());
        wedSecondField.setPreferredSize(new Dimension(150,70));
        JCheckBox wedThirdText = new JCheckBox(theList.get(2).toString());
        wedThirdText.setPreferredSize(new Dimension(148,70));
        wedThirdText.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                theList.get(2).setCompleted();
            }
        });
        JLabel wedThirdField = new JLabel(theList.get(2).getDescription());
        wedThirdField.setPreferredSize(new Dimension(150,70));
        JCheckBox wedFourthText = new JCheckBox(theList.get(3).toString());
        wedFourthText.setPreferredSize(new Dimension(148,70));
        wedFourthText.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                theList.get(3).setCompleted();
            }
        });
        JLabel wedFourthField = new JLabel(theList.get(3).getDescription());
        wedFourthField.setPreferredSize(new Dimension(150,70));
        wed.add(wedFirstText);
        wed.add(wedFirstField);
        wed.add(wedSecondText);
        wed.add(wedSecondField);
        wed.add(wedThirdText);
        wed.add(wedThirdField);
        wed.add(wedFourthText);
        wed.add(wedFourthField);
        
        JPanel thurs = new JPanel();
        thurs.setPreferredSize(new Dimension(150,600));
        JCheckBox thursFirstText = new JCheckBox(theList.get(0).toString());
        thursFirstText.setPreferredSize(new Dimension(148,75));
        thursFirstText.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                theList.get(0).setCompleted();
            }
        });
        JLabel thursFirstField = new JLabel(theList.get(0).getDescription());
        thursFirstField.setPreferredSize(new Dimension(150,70));
        JCheckBox thursSecondText = new JCheckBox(theList.get(1).toString());
        thursSecondText.setPreferredSize(new Dimension(148,70));
        thursSecondText.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                theList.get(1).setCompleted();
            }
        });
        JLabel thursSecondField = new JLabel(theList.get(1).getDescription());
        thursSecondField.setPreferredSize(new Dimension(150,70));
        JCheckBox thursThirdText = new JCheckBox(theList.get(2).toString());
        thursThirdText.setPreferredSize(new Dimension(148,70));
        thursThirdText.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                theList.get(2).setCompleted();
            }
        });
        JLabel thursThirdField = new JLabel(theList.get(2).getDescription());
        thursThirdField.setPreferredSize(new Dimension(150,70));
        JCheckBox thursFourthText = new JCheckBox(theList.get(3).toString());
        thursFourthText.setPreferredSize(new Dimension(148,70));
        thursFourthText.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                theList.get(3).setCompleted();
            }
        });
        JLabel thursFourthField = new JLabel(theList.get(3).getDescription());
        thursFourthField.setPreferredSize(new Dimension(150,70));
        thurs.add(thursFirstText);
        thurs.add(thursFirstField);
        thurs.add(thursSecondText);
        thurs.add(thursSecondField);
        thurs.add(thursThirdText);
        thurs.add(thursThirdField);
        thurs.add(thursFourthText);
        thurs.add(thursFourthField);

        JPanel fri = new JPanel();

        fri.setPreferredSize(new Dimension(150,600));
        JCheckBox friFirstText = new JCheckBox(theList.get(0).toString());
        friFirstText.setPreferredSize(new Dimension(148,75));
        friFirstText.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                theList.get(0).setCompleted();
            }
        });
        JLabel friFirstField = new JLabel(theList.get(0).getDescription());
        friFirstField.setPreferredSize(new Dimension(150,70));
        JCheckBox friSecondText = new JCheckBox(theList.get(1).toString());
        friSecondText.setPreferredSize(new Dimension(148,70));
        friSecondText.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                theList.get(1).setCompleted();
            }
        });
        JLabel friSecondField = new JLabel(theList.get(1).getDescription());
        friSecondField.setPreferredSize(new Dimension(150,70));
        
        fri.add(friFirstText);
        fri.add(friFirstField);
        fri.add(friSecondText);
        fri.add(friSecondField);

        
        JPanel sat = new JPanel();
        sat.setPreferredSize(new Dimension(150,600));
        JCheckBox satFirstText = new JCheckBox(theList.get(0).toString());
        satFirstText.setPreferredSize(new Dimension(148,75));
        satFirstText.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                theList.get(0).setCompleted();
            }
        });
        JLabel satFirstField = new JLabel(theList.get(0).getDescription());
        satFirstField.setPreferredSize(new Dimension(150,70));
        
        sat.add(satFirstText);
        sat.add(satFirstField);

        JPanel sun = new JPanel();

        sun.setPreferredSize(new Dimension(150,600));
        JCheckBox sunFirstText = new JCheckBox(theList.get(0).toString());
        sunFirstText.setPreferredSize(new Dimension(148,75));
        sunFirstText.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                theList.get(0).setCompleted();
            }
        });
        JLabel sunFirstField = new JLabel(theList.get(0).getDescription());
        sunFirstField.setPreferredSize(new Dimension(150,70));
        JCheckBox sunSecondText = new JCheckBox(theList.get(1).toString());
        sunSecondText.setPreferredSize(new Dimension(148,70));
        sunSecondText.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                theList.get(1).setCompleted();
            }
        });
        JLabel sunSecondField = new JLabel(theList.get(1).getDescription());
        sunSecondField.setPreferredSize(new Dimension(150,70));
        JCheckBox sunThirdText = new JCheckBox(theList.get(2).toString());
        sunThirdText.setPreferredSize(new Dimension(148,70));
        sunThirdText.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                theList.get(2).setCompleted();
            }
        });
        JLabel sunThirdField = new JLabel(theList.get(2).getDescription());
        sunThirdField.setPreferredSize(new Dimension(150,70));
        JCheckBox sunFourthText = new JCheckBox(theList.get(3).toString());
        sunFourthText.setPreferredSize(new Dimension(148,70));
        sunFourthText.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                theList.get(3).setCompleted();
            }
        });
        JLabel sunFourthField = new JLabel(theList.get(3).getDescription());
        sunFourthField.setPreferredSize(new Dimension(150,70));
        sun.add(sunFirstText);
        sun.add(sunFirstField);
        sun.add(sunSecondText);
        sun.add(sunSecondField);
        sun.add(sunThirdText);
        sun.add(sunThirdField);
        sun.add(sunFourthText);
        sun.add(sunFourthField);
        
        mon.setBorder(BorderFactory.createLineBorder(Color.black));
        tues.setBorder(BorderFactory.createLineBorder(Color.black));
        wed.setBorder(BorderFactory.createLineBorder(Color.black));
        thurs.setBorder(BorderFactory.createLineBorder(Color.black));
        fri.setBorder(BorderFactory.createLineBorder(Color.black));
        sat.setBorder(BorderFactory.createLineBorder(Color.black));
        sun.setBorder(BorderFactory.createLineBorder(Color.black));
        add(mon);
        add(tues);
        add(wed);
        add(thurs);
        add(fri);
        add(sat);
        add(sun);
    }
       public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame();
        Calendar cal = Calendar.getInstance();
        File file = new File("C:\\Users\\Katie\\Documents\\list");
        String date = cal.get(Calendar.YEAR) + "_" + cal.get(Calendar.MONTH) + "_" + cal.get(Calendar.YEAR);
        if (file.exists()){
            try {
                FileInputStream fi = new FileInputStream(file);
                ObjectInputStream os = new ObjectInputStream(fi);
                recurringTasks = (LinkedHashMap<String, ArrayList<Task>>) os.readObject();
                recurringTasks.put(date, new ArrayList<Task>(Arrays.asList(new Task("Japanese", "Do Kanji"), new Task("Programming", "Program for 2 hours"), new Task("Calories", "Stay under 1500"), new Task("Drinking", "Don't Drink"))));
                frame.add(new ToDoList(recurringTasks));
            }
            catch(IOException e){
                e.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ToDoList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            recurringTasks = new LinkedHashMap<String, ArrayList<Task>>();
           
            recurringTasks.put(date, new ArrayList<Task>(Arrays.asList(new Task("Japanese", "Do Kanji"), new Task("Programming", "Program for 2 hours"), new Task("Calories", "Stay under 1500"), new Task("Drinking", "Don't Drink"))));
            frame.add(new ToDoList(recurringTasks));
        }
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
