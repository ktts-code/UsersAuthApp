package entity;

import main.Application;

public class MyExceptions {

    public  static  void fileExistException() throws Exception {
        throw new Exception("FILE EXIST!");
    }

    public  static  void wrongUsernameException() throws Exception {
        Application.messages.setText("Password should be less than 15 and more than 4 characters in length.");
    }

}
