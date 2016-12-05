package geco;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Hades on 12/5/16.
 */
public class LoginServiceTest {
    private static final String ANEM = "ANEM";
    private static final String ABIL = "ABIL";
    private LoginService ls;

    @Before
    public void setUp() throws Exception {
        String[] start = new String[1];
        start[0]=ANEM;
        ls = new LoginService(start);
    }

    @Test
    public void loginExists() throws Exception {
        boolean res = ls.loginExists(ANEM);
        assertTrue(res);
        res = ls.loginExists(ABIL);
        assertFalse(res);
    }

    @Test
    public void addLogin() throws Exception {
        ls.addLogin("AAA");
        ls.addLogin("AAA");
        List<String> allLogins = ls.findAllLogins();
        assertEquals(3, allLogins.size());
    }

    @Test
    public void findAllLoginsStartingWith() throws Exception {
        List<String> allLogins = ls.findAllLoginsStartingWith("A");
        assertEquals(1, allLogins.size());
        ls.addLogin("AAA");
        allLogins = ls.findAllLoginsStartingWith("A");
        assertEquals(2, allLogins.size());
        allLogins = ls.findAllLoginsStartingWith("B");
        assertEquals(0, allLogins.size());
    }

    @Test
    public void findAllLogins() throws Exception {
        List<String> allLogins = ls.findAllLogins();
        assertEquals(1, allLogins.size());
        ls.addLogin("AAA");
        allLogins = ls.findAllLogins();
        assertEquals(2, allLogins.size());
    }

}