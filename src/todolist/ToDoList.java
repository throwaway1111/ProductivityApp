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
        mon.setLayout(new GridLayout(6,1));
        JCheckBox monFirstText = new JCheckBox(theList.get(0).toString());
        monFirstText.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                theList.get(0).setCompleted();
            }
        });
        JLabel monFirstField = new JLabel(theList.get(0).getDescription());
        JCheckBox monSecondText = new JCheckBox(theList.get(1).toString());
        JLabel monSecondField = new JLabel(theList.get(1).getDescription());
        JCheckBox monThirdText = new JCheckBox(theList.get(2).toString());
        JLabel monThirdField = new JLabel(theList.get(2).getDescription());
        mon.add(monFirstText);
        mon.add(monFirstField);
        mon.add(monSecondText);
        mon.add(monSecondField);
        mon.add(monThirdText);
        mon.add(monThirdField);
        
        JPanel tues = new JPanel();
        tues.setLayout(new BorderLayout());
        tues.setPreferredSize(new Dimension(150,600));
        JPanel wed = new JPanel();
        wed.setLayout(new BorderLayout());
        wed.setPreferredSize(new Dimension(150,600));
        JPanel thurs = new JPanel();
        thurs.setLayout(new BorderLayout());
        thurs.setPreferredSize(new Dimension(150,600));
        JPanel fri = new JPanel();
        fri.setLayout(new BorderLayout());
        fri.setPreferredSize(new Dimension(150,600));
        JPanel sat = new JPanel();
        sat.setLayout(new BorderLayout());
        sat.setPreferredSize(new Dimension(150,600));
        JPanel sun = new JPanel();
        sun.setLayout(new BorderLayout());
        sun.setPreferredSize(new Dimension(150,600));
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
