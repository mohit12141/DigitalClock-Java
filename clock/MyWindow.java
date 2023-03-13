package clock;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class MyWindow extends JFrame{
    private JLabel heading, clockLabel;
    private Font font = new Font("",Font.BOLD,35);

    public MyWindow(){
        super.setTitle("My Clock");
        super.setSize(600,200);
        super.setLocation(300,50);
        this.createGUI();
        startClock();
        super.setVisible(true);
    }
    public void createGUI(){
        heading = new JLabel("My CLOCK");
        clockLabel = new JLabel("");
        
        heading.setFont(font);
        clockLabel.setFont(font);
        
        heading.setLocation(50,20);
        
        this.setLayout(new GridLayout(2,1));
        
        this.add(heading);
        this.add(clockLabel);
    }
    
    public void startClock(){
        Timer timer = new Timer(1000,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
//                String dateTime = new Date().toString();// standard timeing 
                String dateTime = new Date().toLocaleString(); // According to Indian time
                clockLabel.setText(dateTime);
                
            }
        });
        
        timer.start();
        
        Thread th = new Thread(){
            @Override
            public void run(){
                try{
                    while(true){
                        String dateTime = new Date().toLocaleString(); // According to Indian time
                        clockLabel.setText(dateTime);
                        Thread.sleep(1000);
                    }
                } catch(InterruptedException e){
                }
            }
        };
    }
}
