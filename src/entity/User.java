package entity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;

public class User {

    public static void main(String[] args) {

    }

    String username;
    String password;
    String job_title;
    String email;
    String phone_number;
    String gender;

    public User(String username, String password, String job_title, String email, String phone_number, String gender) throws Exception {
        setUsername(username);
        setPassword(password);
        this.job_title = job_title;
        this.email = email;
        this.phone_number = phone_number;
        this.gender = gender;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) throws Exception {
        if (username.length() > 15 || username.length() < 4)
        {
            MyExceptions.wrongUsernameException();
        }else{this.username = username;}
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getJob_title() {
        return job_title;
    }
    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone_number() {
        return phone_number;
    }
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    public String  getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "username: " + username +
                "\n password: " + password +
                "\n job title: " + job_title +
                "\n email: " + email +
                "\n phone number: " + phone_number +
                "\n gender: " + gender
                ;
    }


    //////////////////
    //persistance
    /* save user to json */
    public void save() throws Exception{

        JSONObject json = new JSONObject();
        json.accumulate("username", this.username);
        json.accumulate("password", this.password);
        json.accumulate("job title", this.job_title);
        json.accumulate("email", this.email);
        json.accumulate("phone number", this.phone_number);
        json.accumulate("gender", this.gender);

        //FileWriter
        try {
            File f = new File("data/"+this.username+".json");
            if(f.exists()){
//				System.err.println("FILE EXIST!");
//                throw new Exception("FILE EXIST!");
                MyExceptions.fileExistException();
            }
            FileWriter fw = new FileWriter( f );
            fw.write( json.toString() );
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//		System.out.println(json.toString() );


    }

}
