package service;

import model.User;


public class UserCreator {

    public static final String FIRST_NAME = "testdata.user.firstname";
    public static final String LAST_NAME = "testdata.user.lastname";
    public static final String ADDRESS = "testdata.user.address";
    public static final String EMAIL = "testdata.user.email";
    public static final String PHONE_NUMBER = "testdata.user.phonenumber";

    public static User withCredentialsFromProperty(){
        return new User(FIRST_NAME, LAST_NAME, ADDRESS, EMAIL, PHONE_NUMBER);
    }
}
