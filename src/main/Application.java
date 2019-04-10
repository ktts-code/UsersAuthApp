package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import entity.User;

public class Application {

    public static JTextField username_input;
    public static JTextField password_input;
    public static JTextField job_title_input;
    public static JTextField email_input;
    public static JTextField phone_number_input;
    public static JRadioButton male = new JRadioButton("Male");
    public static JRadioButton female = new JRadioButton("Female");
    public static String gender;

    public static JLabel     messages;

    public static void main(String[] args) {
        //swing library
        showRegistrationWindow();
    }

    public static void showRegistrationWindow(){

        // DOM / Visual Hierarchy - Tree

        JFrame window = new JFrame("User Application");
        window.setSize(500,400);
        window.getContentPane().setLayout( new GridLayout(10,2) );


        username_input = new JTextField();
        window.getContentPane().add( username_input );
        username_input.setToolTipText("Choose your username...");

        password_input = new JTextField();
        window.getContentPane().add( password_input );
        password_input.setToolTipText("Enter password");

        job_title_input = new JTextField();
        window.getContentPane().add( job_title_input );
        job_title_input.setToolTipText("Job title");

        email_input = new JTextField();
        window.getContentPane().add( email_input );
        email_input.setToolTipText("Enter your email");

        phone_number_input = new JTextField();
        window.getContentPane().add( phone_number_input );
        phone_number_input.setToolTipText("Enter your phone number");

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);

        window.getContentPane().add(male);
        window.getContentPane().add(female);

        if(Application.male.isSelected()){
            Application.gender = "Male";
        }else{
            Application.gender = "Female";
        }

        JButton button = new JButton("Create account!");
        window.getContentPane().add( button );

        messages = new JLabel();
        window.getContentPane().add( messages );

        window.show();

        /* Observer pattern -> events / hangling / async  */
        button.addActionListener( new ButtonHandler() );


    }

}

//////////////////// HANDLER CLASSES ////////////////////////
/* observer */
class ButtonHandler implements ActionListener{
    /* Auto start method onclick   */
    @Override
    public void actionPerformed(ActionEvent e) {


        User u = null;
        try {
            u = new User(
                    Application.username_input.getText(),
                    Application.password_input.getText(),
                    Application.job_title_input.getText(),
                    Application.email_input.getText(),
                    Application.phone_number_input.getText(),
                    Application.gender
            );
        } catch (Exception e1) {
//            e1.printStackTrace();
        }
        try {
            u.save();
            Application.messages.setForeground( new Color(0, 255, 0));
            Application.messages.setText("Registration SUCCESSFUL!");
            Application.username_input.setText("");
            Application.password_input.setText("");
            Application.job_title_input.setText("");
            Application.email_input.setText("");
            Application.phone_number_input.setText("");
            Application.male.setSelected(false);
            Application.female.setSelected(false);
        } catch (Exception e1) {
            Application.messages.setForeground( new Color(255, 0, 0));
            Application.messages.setText("This username is taken!");
//			e1.printStackTrace();
        }


    }

}


// add to user :job title, email, phone, gender
// window + properties
// gender -> checkbox
// +++ setters validation rules -> throw Exeptions -> window
// UsernameEmptyExeptions, PasswordTooShortExeptions, ....


