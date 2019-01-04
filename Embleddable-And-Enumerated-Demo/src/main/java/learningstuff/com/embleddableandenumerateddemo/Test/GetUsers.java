package learningstuff.com.embleddableandenumerateddemo.Test;

import learningstuff.com.embleddableandenumerateddemo.Model.Gender;
import learningstuff.com.embleddableandenumerateddemo.Model.Name;
import learningstuff.com.embleddableandenumerateddemo.Model.User;

import java.util.ArrayList;
import java.util.List;

public class GetUsers {
    private static List<User> users = new ArrayList<>();

    static {
        for (int j = 0; j < 10; j++) {
            Name name = new Name(getName(), getName());
            users.add(new User(name, (int) (Math.random() * 2) == 1 ? Gender.MALE : Gender.FEMALE));
        }
    }

    public static String getName()
    {
        StringBuilder builder = new StringBuilder();

        int len = (int) (Math.random() * 5 + 2);

        builder.append((char) (Math.random() * 26 + 'A'));

        for (int i = 0; i < len; i++) {
            builder.append((char) (Math.random() * 26 + 'a'));
        }

        return builder.toString();
    }

    public List<User> getUsers()
    {
        return users;
    }
}
