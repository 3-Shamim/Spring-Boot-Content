package learningstuff.com.embleddableandenumerateddemo.Test;

import learningstuff.com.embleddableandenumerateddemo.Model.User;


public class mainClass {



    public static void main(String[] args) {

        /*for (Gender gender: Gender.values()) {
            System.out.println(gender.ordinal());
        }*/

    /*    int i = 0;

        for (Gender gender: Gender.values()) {
            if (gender.ordinal() == i)
            {
                System.out.println(gender);
            }
        }*/

    GetUsers getUsers = new GetUsers();

        for (User user : getUsers.getUsers()) {
            if (user.getId() == 0)
            {
                System.out.println(user.getName().getFirstName());
                System.out.println(user.getName().getLastName());
                System.out.println(user.getGender());
            }
        }


    }


}
