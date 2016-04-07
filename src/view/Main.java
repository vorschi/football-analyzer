package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import control.ImageDrawer;

public class Main extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean run = false;

    public Main() {

        initUI();
    }

    private void initUI() {

    	ImageDrawer animation = new ImageDrawer();
        this.add(animation);
        
        JButton OKButton = new JButton("Play/Pause");
        OKButton.addActionListener(new ActionListener(){
        	 public void actionPerformed(ActionEvent evt){
        		 	if (run){
        		 		animation.stop();
        		 		run = false;
        		 	}
        		 	else{
        		 		animation.start();
        		 		run = true;
        		 	}
        		 		
        		    //Assuming that the content here will do something.
        	 }

        });
        
        animation.add(OKButton);

        //pack();
        
        setTitle("Mushrooms");
        setSize(800,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
            	Main ex = new Main();
                ex.setVisible(true);
            }
        });
    }
}