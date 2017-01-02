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
    public ToDoList (LinkedHashMap<String, ArrayList<Task>> map) throws FileNotFoundException{
        setPreferredSize(new Dimension(1260,630)); 
        JPanel headers = new JPanel();
        headers.setPreferredSize(new Dimension(1260,30));
        headers.setLayout(new GridLayout(1,7));
        JPanel monHead = new JPanel();
        monHead.setPreferredSize(new Dimension(180,30));
        monHead.add(new Label("Monday",SwingConstants.CENTER));
        headers.add(monHead);
        JPanel tuesHead = new JPanel();
        tuesHead.setPreferredSize(new Dimension(180,30));
        tuesHead.add(new Label("Tuesday",SwingConstants.CENTER));
        headers.add(tuesHead);
        JPanel wedHead = new JPanel();
        wedHead.setPreferredSize(new Dimension(180,30));
        wedHead.add(new Label("Wednesday",SwingConstants.CENTER));
        headers.add(wedHead);
        JPanel thursHead = new JPanel();
        thursHead.setPreferredSize(new Dimension(180,30));
        thursHead.add(new Label("Thursday",SwingConstants.CENTER));
        headers.add(thursHead);
        JPanel friHead = new JPanel();
        friHead.setPreferredSize(new Dimension(180,30));
        friHead.add(new Label("Friday",SwingConstants.CENTER));
        headers.add(friHead);
        JPanel satHead = new JPanel();
        satHead.setPreferredSize(new Dimension(180,30));
        satHead.add(new Label("Saturday",SwingConstants.CENTER));
        headers.add(satHead);
        JPanel sunHead = new JPanel();
        sunHead.setPreferredSize(new Dimension(180,30));
        sunHead.add(new Label("Sunday",SwingConstants.CENTER));
        headers.add(sunHead);
        add(headers);
        JPanel mains = new JPanel();
        mains.setPreferredSize(new Dimension(1260,600));
        mains.setLayout(new GridLayout(1,7));
        
        Calendar cal = Calendar.getInstance();
        String date = cal.get(Calendar.YEAR) + "_" + cal.get(Calendar.MONTH) + "_" + cal.get(Calendar.YEAR);
        ArrayList<Task> theList = recurringTasks.get(date);
        JPanel mon = new JPanel();
        mon.setPreferredSize(new Dimension(180,600));
        JCheckBox monFirstText = new JCheckBox(theList.get(0).toString());
        monFirstText.setPreferredSize(new Dimension(178,60));
        JLabel monFirstField = new JLabel(theList.get(0).getDescription());
        monFirstField.setPreferredSize(new Dimension(180,60));
        JCheckBox monSecondText = new JCheckBox(theList.get(1).toString());
        monSecondText.setPreferredSize(new Dimension(178,60));
        JLabel monSecondField = new JLabel(theList.get(1).getDescription());
        monSecondField.setPreferredSize(new Dimension(180,60));
        JCheckBox monThirdText = new JCheckBox(theList.get(2).toString());
        monThirdText.setPreferredSize(new Dimension(178,60));
        JLabel monThirdField = new JLabel(theList.get(2).getDescription());
        monThirdField.setPreferredSize(new Dimension(180,60));
        JCheckBox monFourthText = new JCheckBox(theList.get(3).toString());
        monFourthText.setPreferredSize(new Dimension(178,60));
        JLabel monFourthField = new JLabel(theList.get(3).getDescription());
        monFourthField.setPreferredSize(new Dimension(180,60));
        JPanel monButtons = new JPanel();
        monButtons.setPreferredSize(new Dimension(180,58));
        JButton monSave = new JButton("Save");
        if (cal.get(Calendar.DAY_OF_WEEK) !=  Calendar.MONDAY){
            monSave.setEnabled(false);
        }
        monSave.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (monFirstText.isSelected() == false){
                    recurringTasks.get(date).get(0).setNotCompleted();
                }
                if (monSecondText.isSelected() == false){
                    recurringTasks.get(date).get(1).setNotCompleted();
                }
                if (monThirdText.isSelected() == false){
                    recurringTasks.get(date).get(2).setNotCompleted();
                }
                if (monFourthText.isSelected() == false){
                    recurringTasks.get(date).get(3).setNotCompleted();
                }
            
                try
                {
                    FileOutputStream fs = new FileOutputStream(new File("C:\\Users\\Katie\\Documents\\list"));
                    ObjectOutputStream os = new ObjectOutputStream(fs);
                    os.writeObject(recurringTasks);
                } catch(FileNotFoundException r){
                r.printStackTrace();
            }   catch (IOException ex) {
                    Logger.getLogger(ToDoList.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        monSave.setPreferredSize(new Dimension(180,29));
        JButton monCalculate = new JButton("Get Statistics");
        monCalculate.addActionListener(new ActionListener (){
            public void actionPerformed(ActionEvent e){
                getStatistics();
            }
        });
        if (cal.get(Calendar.DAY_OF_WEEK) !=  Calendar.MONDAY){
            monCalculate.setEnabled(false);
        }
        monCalculate.setPreferredSize(new Dimension(180,29));
        monButtons.add(monSave);
        monButtons.add(monCalculate);
        mon.add(monFirstText);
        mon.add(monFirstField);
        mon.add(monSecondText);
        mon.add(monSecondField);
        mon.add(monThirdText);
        mon.add(monThirdField);
        mon.add(monFourthText);
        mon.add(monFourthField);
        mon.add(monButtons);
        
        JPanel tues = new JPanel();
        tues.setPreferredSize(new Dimension(180,600));  
        JCheckBox tuesFirstText = new JCheckBox(theList.get(0).toString());
        tuesFirstText.setPreferredSize(new Dimension(178,60));
       
        JLabel tuesFirstField = new JLabel(theList.get(0).getDescription());
        tuesFirstField.setPreferredSize(new Dimension(180,60));
        
        tues.add(tuesFirstText);
        tues.add(tuesFirstField);
        JPanel placeHolder = new JPanel();
        placeHolder.setPreferredSize(new Dimension(180,385));
        JPanel tuesButtons = new JPanel();
        tuesButtons.setPreferredSize(new Dimension(180,60));
        JButton tuesSave = new JButton("Save");
        if (cal.get(Calendar.DAY_OF_WEEK) !=  Calendar.TUESDAY){
            tuesSave.setEnabled(false);
        }
        tuesSave.setPreferredSize(new Dimension(180,30));
        tuesSave.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (tuesFirstText.isSelected() == false){
                    recurringTasks.get(date).get(0).setNotCompleted();
                }
                
            
                try
                {
                    FileOutputStream fs = new FileOutputStream(new File("C:\\Users\\Katie\\Documents\\list"));
                    ObjectOutputStream os = new ObjectOutputStream(fs);
                    os.writeObject(recurringTasks);
                } catch(FileNotFoundException r){
                r.printStackTrace();
            }   catch (IOException ex) {
                    Logger.getLogger(ToDoList.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        JButton tuesCalculate = new JButton("Get Statistics");
        tuesCalculate.addActionListener(new ActionListener (){
            public void actionPerformed(ActionEvent e){
                getStatistics();
            }
        });
        tuesCalculate.setPreferredSize(new Dimension(180,30));
        if (cal.get(Calendar.DAY_OF_WEEK) !=  Calendar.TUESDAY){
            tuesCalculate.setEnabled(false);
        }
        tuesButtons.add(tuesSave);
        tuesButtons.add(tuesCalculate);
        tues.add(placeHolder);
        tues.add(tuesButtons);
        JPanel wed = new JPanel();
        wed.setPreferredSize(new Dimension(180,600));
        JCheckBox wedFirstText = new JCheckBox(theList.get(0).toString());
        wedFirstText.setPreferredSize(new Dimension(178,60));
        
        JLabel wedFirstField = new JLabel(theList.get(0).getDescription());
        wedFirstField.setPreferredSize(new Dimension(180,60));
        JCheckBox wedSecondText = new JCheckBox(theList.get(1).toString());
        wedSecondText.setPreferredSize(new Dimension(178,60));
        
        JLabel wedSecondField = new JLabel(theList.get(1).getDescription());
        wedSecondField.setPreferredSize(new Dimension(180,60));
        JCheckBox wedThirdText = new JCheckBox(theList.get(2).toString());
        wedThirdText.setPreferredSize(new Dimension(178,60));
        
        JLabel wedThirdField = new JLabel(theList.get(2).getDescription());
        wedThirdField.setPreferredSize(new Dimension(180,60));
        JCheckBox wedFourthText = new JCheckBox(theList.get(3).toString());
        wedFourthText.setPreferredSize(new Dimension(178,60));
        
        JLabel wedFourthField = new JLabel(theList.get(3).getDescription());
        wedFourthField.setPreferredSize(new Dimension(180,60));
        JPanel wedButtons = new JPanel();
        wedButtons.setPreferredSize(new Dimension(180,60));
        JButton wedSave = new JButton("Save");
        wedSave.setPreferredSize(new Dimension(180,30));
        wedSave.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (wedFirstText.isSelected() == false){
                    recurringTasks.get(date).get(0).setNotCompleted();
                }
                if (wedSecondText.isSelected() == false){
                    recurringTasks.get(date).get(1).setNotCompleted();
                }
                if (wedThirdText.isSelected() == false){
                    recurringTasks.get(date).get(2).setNotCompleted();
                }
                if (wedFourthText.isSelected() == false){
                    recurringTasks.get(date).get(3).setNotCompleted();
                }
            
                try
                {
                    FileOutputStream fs = new FileOutputStream(new File("C:\\Users\\Katie\\Documents\\list"));
                    ObjectOutputStream os = new ObjectOutputStream(fs);
                    os.writeObject(recurringTasks);
                } catch(FileNotFoundException r){
                r.printStackTrace();
            }   catch (IOException ex) {
                    Logger.getLogger(ToDoList.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        JButton wedCalculate = new JButton("Get Statistics");
        wedCalculate.addActionListener(new ActionListener (){
            public void actionPerformed(ActionEvent e){
                getStatistics();
            }
        });
        if (cal.get(Calendar.DAY_OF_WEEK) !=  Calendar.WEDNESDAY){
            wedCalculate.setEnabled(false);
        }
        if (cal.get(Calendar.DAY_OF_WEEK) !=  Calendar.WEDNESDAY){
            wedSave.setEnabled(false);
        }
        wedCalculate.setPreferredSize(new Dimension(180,30));
        wedButtons.add(wedSave);
        wedButtons.add(wedCalculate);
        wed.add(wedFirstText);
        wed.add(wedFirstField);
        wed.add(wedSecondText);
        wed.add(wedSecondField);
        wed.add(wedThirdText);
        wed.add(wedThirdField);
        wed.add(wedFourthText);
        wed.add(wedFourthField);
        wed.add(wedButtons);
        
        JPanel thurs = new JPanel();
        thurs.setPreferredSize(new Dimension(80,600));
        JCheckBox thursFirstText = new JCheckBox(theList.get(0).toString());
        thursFirstText.setPreferredSize(new Dimension(178,60));
        
        JLabel thursFirstField = new JLabel(theList.get(0).getDescription());
        thursFirstField.setPreferredSize(new Dimension(180,60));
        JCheckBox thursSecondText = new JCheckBox(theList.get(1).toString());
        thursSecondText.setPreferredSize(new Dimension(178,60));
        
        JLabel thursSecondField = new JLabel(theList.get(1).getDescription());
        thursSecondField.setPreferredSize(new Dimension(180,60));
        JCheckBox thursThirdText = new JCheckBox(theList.get(2).toString());
        thursThirdText.setPreferredSize(new Dimension(178,60));
        
        JLabel thursThirdField = new JLabel(theList.get(2).getDescription());
        thursThirdField.setPreferredSize(new Dimension(180,60));
        JCheckBox thursFourthText = new JCheckBox(theList.get(3).toString());
        thursFourthText.setPreferredSize(new Dimension(178,60));
        
        JLabel thursFourthField = new JLabel(theList.get(3).getDescription());
        thursFourthField.setPreferredSize(new Dimension(180,60));
        JPanel thursButtons = new JPanel();
        thursButtons.setPreferredSize(new Dimension(180,60));
        JButton thursSave = new JButton("Save");
         if (cal.get(Calendar.DAY_OF_WEEK) !=  Calendar.THURSDAY){
            thursSave.setEnabled(false);
        }
        thursSave.setPreferredSize(new Dimension(180,30));
        thursSave.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (thursFirstText.isSelected() == false){
                    recurringTasks.get(date).get(0).setNotCompleted();
                }
                if (thursSecondText.isSelected() == false){
                    recurringTasks.get(date).get(1).setNotCompleted();
                }
                if (thursThirdText.isSelected() == false){
                    recurringTasks.get(date).get(2).setNotCompleted();
                }
                if (thursFourthText.isSelected() == false){
                    recurringTasks.get(date).get(3).setNotCompleted();
                }
            
                try
                {
                    FileOutputStream fs = new FileOutputStream(new File("C:\\Users\\Katie\\Documents\\list"));
                    ObjectOutputStream os = new ObjectOutputStream(fs);
                    os.writeObject(recurringTasks);
                } catch(FileNotFoundException r){
                r.printStackTrace();
            }   catch (IOException ex) {
                    Logger.getLogger(ToDoList.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        thursButtons.add(thursSave);
        JButton thursCalculate = new JButton("Get Statistics");
        thursCalculate.addActionListener(new ActionListener (){
            public void actionPerformed(ActionEvent e){
                getStatistics();
            }
        });
        thursCalculate.setPreferredSize(new Dimension(180,30));
         if (cal.get(Calendar.DAY_OF_WEEK) !=  Calendar.THURSDAY){
            thursCalculate.setEnabled(false);
        }
        thursButtons.add(thursCalculate);
        thurs.add(thursFirstText);
        thurs.add(thursFirstField);
        thurs.add(thursSecondText);
        thurs.add(thursSecondField);
        thurs.add(thursThirdText);
        thurs.add(thursThirdField);
        thurs.add(thursFourthText);
        thurs.add(thursFourthField);
        thurs.add(thursButtons);
        
        JPanel fri = new JPanel();

        fri.setPreferredSize(new Dimension(180,600));
        JCheckBox friFirstText = new JCheckBox(theList.get(0).toString());
        friFirstText.setPreferredSize(new Dimension(178,75));
        
        JLabel friFirstField = new JLabel(theList.get(0).getDescription());
        friFirstField.setPreferredSize(new Dimension(180,70));
        JCheckBox friSecondText = new JCheckBox(theList.get(1).toString());
        friSecondText.setPreferredSize(new Dimension(178,70));
        
        JLabel friSecondField = new JLabel(theList.get(1).getDescription());
        friSecondField.setPreferredSize(new Dimension(180,70));
        JPanel friButtons = new JPanel();
        friButtons.setPreferredSize(new Dimension(180,60));
        JButton friSave = new JButton("Save");
        friSave.setPreferredSize(new Dimension(180,30));
        
        JButton friCalculate = new JButton("Get Statistics");
        friCalculate.addActionListener(new ActionListener (){
            public void actionPerformed(ActionEvent e){
                getStatistics();
            }
        });
        friCalculate.setPreferredSize(new Dimension(180,30));
        JPanel friSpace = new JPanel();
        friSpace.setPreferredSize(new Dimension(180,210));
         if (cal.get(Calendar.DAY_OF_WEEK) !=  Calendar.FRIDAY){
            friCalculate.setEnabled(false);
        }
         if (cal.get(Calendar.DAY_OF_WEEK) !=  Calendar.FRIDAY){
            friSave.setEnabled(false);
        }
        friButtons.add(friSave);
        friButtons.add(friCalculate);
        fri.add(friFirstText);
        fri.add(friFirstField);
        fri.add(friSecondText);
        fri.add(friSecondField);
        fri.add(friSpace);
        fri.add(friButtons);

        
        JPanel sat = new JPanel();
        sat.setPreferredSize(new Dimension(180,600));
        JCheckBox satFirstText = new JCheckBox(theList.get(0).toString());
        satFirstText.setPreferredSize(new Dimension(178,60));
        
        JLabel satFirstField = new JLabel(theList.get(0).getDescription());
        satFirstField.setPreferredSize(new Dimension(180,60));
        JPanel satButtons = new JPanel();
        satButtons.setPreferredSize(new Dimension(180,60));
        JButton satSave = new JButton("Save");
        satSave.setPreferredSize(new Dimension(180,30));
         if (cal.get(Calendar.DAY_OF_WEEK) !=  Calendar.SATURDAY){
            satSave.setEnabled(false);
        }
        JButton satCalculate = new JButton("Get Statistics");
        satCalculate.setPreferredSize(new Dimension(180,30));
         if (cal.get(Calendar.DAY_OF_WEEK) !=  Calendar.SATURDAY){
            satCalculate.setEnabled(false);
        }
        satCalculate.addActionListener(new ActionListener (){
            public void actionPerformed(ActionEvent e){
                getStatistics();
            }
        });
        satSave.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (satFirstText.isSelected() == false){
                    recurringTasks.get(date).get(0).setNotCompleted();
                }
                try
                {
                    FileOutputStream fs = new FileOutputStream(new File("C:\\Users\\Katie\\Documents\\list"));
                    ObjectOutputStream os = new ObjectOutputStream(fs);
                    os.writeObject(recurringTasks);
                } catch(FileNotFoundException r){
                r.printStackTrace();
            }   catch (IOException ex) {
                    Logger.getLogger(ToDoList.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        satButtons.add(satSave);
        satButtons.add(satCalculate);
        sat.add(satFirstText);
        sat.add(satFirstField);
        JPanel satSpace = new JPanel();
        satSpace.setPreferredSize(new Dimension(180,385));
        sat.add(satSpace);
        sat.add(satButtons);

        JPanel sun = new JPanel();

        sun.setPreferredSize(new Dimension(180,600));
        JCheckBox sunFirstText = new JCheckBox(theList.get(0).toString());
        sunFirstText.setPreferredSize(new Dimension(178,60));
       
        JLabel sunFirstField = new JLabel(theList.get(0).getDescription());
        sunFirstField.setPreferredSize(new Dimension(180,60));
        JCheckBox sunSecondText = new JCheckBox(theList.get(1).toString());
        sunSecondText.setPreferredSize(new Dimension(178,60));
        
        JLabel sunSecondField = new JLabel(theList.get(1).getDescription());
        sunSecondField.setPreferredSize(new Dimension(180,60));
        JCheckBox sunThirdText = new JCheckBox(theList.get(2).toString());
        sunThirdText.setPreferredSize(new Dimension(178,60));
        
        JLabel sunThirdField = new JLabel(theList.get(2).getDescription());
        sunThirdField.setPreferredSize(new Dimension(180,60));
        JCheckBox sunFourthText = new JCheckBox(theList.get(3).toString());
        sunFourthText.setPreferredSize(new Dimension(178,60));
        
        JLabel sunFourthField = new JLabel(theList.get(3).getDescription());
        sunFourthField.setPreferredSize(new Dimension(180,60));
        JPanel sunButtons = new JPanel();
        sunButtons.setPreferredSize(new Dimension(180,60));
        JButton sunSave = new JButton("Save");
        sunSave.setPreferredSize(new Dimension(180,30));
        JButton sunCalculate = new JButton("Get Statistics");
        sunCalculate.setPreferredSize(new Dimension(180,30));
        sunSave.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (sunFirstText.isSelected() == false){
                    recurringTasks.get(date).get(0).setNotCompleted();
                }
                if (sunSecondText.isSelected() == false){
                    recurringTasks.get(date).get(1).setNotCompleted();
                }
                if (sunThirdText.isSelected() == false){
                    recurringTasks.get(date).get(2).setNotCompleted();
                }
                if (sunFourthText.isSelected() == false){
                    recurringTasks.get(date).get(3).setNotCompleted();
                }
            
                try
                {
                    FileOutputStream fs = new FileOutputStream(new File("C:\\Users\\Katie\\Documents\\list"));
                    ObjectOutputStream os = new ObjectOutputStream(fs);
                    os.writeObject(recurringTasks);
                } catch(FileNotFoundException r){
                r.printStackTrace();
            }   catch (IOException ex) {
                    Logger.getLogger(ToDoList.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        if (cal.get(Calendar.DAY_OF_WEEK) !=  Calendar.SUNDAY){
            sunCalculate.setEnabled(false);
        }
        sunCalculate.addActionListener(new ActionListener (){
            public void actionPerformed(ActionEvent e){
                getStatistics();
            }
        });
        if (cal.get(Calendar.DAY_OF_WEEK) !=  Calendar.SUNDAY){
            sunSave.setEnabled(false);
        }
        sunButtons.add(sunSave);
        sunButtons.add(sunCalculate);
        sun.add(sunFirstText);
        sun.add(sunFirstField);
        sun.add(sunSecondText);
        sun.add(sunSecondField);
        sun.add(sunThirdText);
        sun.add(sunThirdField);
        sun.add(sunFourthText);
        sun.add(sunFourthField);
        sun.add(sunButtons);
        mon.setBorder(BorderFactory.createLineBorder(Color.black));
        tues.setBorder(BorderFactory.createLineBorder(Color.black));
        wed.setBorder(BorderFactory.createLineBorder(Color.black));
        thurs.setBorder(BorderFactory.createLineBorder(Color.black));
        fri.setBorder(BorderFactory.createLineBorder(Color.black));
        sat.setBorder(BorderFactory.createLineBorder(Color.black));
        sun.setBorder(BorderFactory.createLineBorder(Color.black));
        mains.add(mon);
        mains.add(tues);
        mains.add(wed);
        mains.add(thurs);
        mains.add(fri);
        mains.add(sat);
        mains.add(sun);
        add(mains);
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
                if (recurringTasks.get(date) == null){
                    recurringTasks.put(date, new ArrayList<Task>(Arrays.asList(new Task("Japanese", "Do Kanji"), new Task("Programming", "Program for 2 hours"), new Task("Calories", "Stay under 1500"), new Task("Drinking", "Don't Drink"))));
                }
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
   private void getStatistics (){
        File file = new File("C:\\Users\\Katie\\Documents\\list");
        if (file.exists()){
            try {
                FileInputStream fi = new FileInputStream(file);
                ObjectInputStream os = new ObjectInputStream(fi);
                recurringTasks = (LinkedHashMap<String, ArrayList<Task>>) os.readObject();
            }catch (Exception e){
                e.printStackTrace();
            }
       double times = 0;
       double [] count = {0,0,0,0};
       for (Map.Entry<String, ArrayList<Task>> entry : recurringTasks.entrySet()){
           for (int i = 0; i < 4; i++){
               
            if (entry.getValue().get(i).getCompleted() == true){
                count[i] += 1;
            }
            else
                count[i] += 0;
           
            }
          times++;
       }
       double japanese = (count[0] / times) * 100;
       double programming = (count[1] / times) * 100;
       double calories = (count[2] / times) * 100;
       double drinking = (count[3] / times) * 100;
       JOptionPane.showMessageDialog(this, "Japanese " + japanese + "%\n" + "Programming " + programming + "%\n" + "Calories " + calories + "%\n" + "Drinking " + drinking + "%");
   }
}
}
