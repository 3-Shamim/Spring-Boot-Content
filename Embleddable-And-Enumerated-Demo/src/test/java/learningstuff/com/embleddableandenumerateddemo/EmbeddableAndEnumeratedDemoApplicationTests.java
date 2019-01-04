package learningstuff.com.embleddableandenumerateddemo;

import learningstuff.com.embleddableandenumerateddemo.Model.User;
import learningstuff.com.embleddableandenumerateddemo.Repository.UserRepository;
import learningstuff.com.embleddableandenumerateddemo.Test.GetUsers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmbeddableAndEnumeratedDemoApplicationTests {

    @Autowired
    private UserRepository userRepository;

    private GetUsers getUsers = new GetUsers();

    private static boolean isInit = false;

//    @Before
//    public void init()
//    {
//        if (!isInit)
//        {
//
//            userRepository.saveAll(getUsers.getUsers());
//
//            isInit = true;
//        }
//    }

	@Test
	public void contextLoads() {

        User u = userRepository.getOne(1);

        Assert.assertNotNull(u);

	}

}
