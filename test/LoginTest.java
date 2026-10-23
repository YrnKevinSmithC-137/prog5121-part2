
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {

    // ---- username tests ----

    @Test
    public void testUsernameValid() {
        Login login = new Login("kevin", "mabunda", "kev_1", "Pass123$", "+27831234654");
        assertTrue(login.checkUserName());
    }

    @Test
    public void testUsernameInvalid() {
        Login login = new Login("kevin", "mabunda", "kevin12345", "Pass123$", "+27771234567");
        assertFalse(login.checkUserName());
    }

    @Test
    public void testUsernameEmpty() {
        Login login = new Login("kevin", "mabunda", "", "Pass123$", "+2783553567");
        assertFalse(login.checkUserName());
    }

    // ---- password tests ----

    @Test
    public void testPasswordStrong() {
        Login login = new Login("kevin", "mabunda", "kev_1", "Zwothe190$", "+27831234567");
        assertTrue(login.checkPasswordComplexity());
    }

    @Test
    public void testPasswordWeak() {
        Login login = new Login("kevin", "mabunda", "kev_1", "pass", "+27831234567");
        assertFalse(login.checkPasswordComplexity());
    }

    // ---- cell number tests ----

    @Test
    public void testCellNumberValid() {
        Login login = new Login("kevin", "mabunda", "leo_1", "Zwothe190$", "+27765432563");
        assertTrue(login.checkCellPhoneNumber());
    }

    @Test
    public void testCellNumberInvalid() {
        Login login = new Login("kevin", "mabunda", "leo_1", "Zwothe190$", "0766873663");
        assertFalse(login.checkCellPhoneNumber());
    }

    // ---- login functionality ----

    @Test
    public void testLoginSuccess() {
        Login login = new Login("kevin", "mabunda", "kev_1", "Zwothe190$", "+27769777763");
        assertTrue(login.loginUser("kev_1", "Zwothe190$"));
    }

    @Test
    public void testLoginFail() {
        Login login = new Login("kevin", "mabunda", "kev_1", "Zwothe190$", "+27762222563");
        assertFalse(login.loginUser("user", "wrong"));
    }

    // ---- register messages ----

    @Test
    public void testRegisterSuccess() {
        Login login = new Login("kevin", "mabunda", "kev_1", "Zwothe190$", "+27766666563");
        assertEquals("Registration successful! Welcome, kevin mabunda.", login.registerUser());
    }

    @Test
    public void testRegisterInvalidUsername() {
        Login login = new Login("kevin", "mabunda", "kevin12345", "Zwothe190$", "+27999978563");
        assertEquals(
            "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.",
            login.registerUser()
        );
    }

    @Test
    public void testRegisterInvalidPassword() {
        Login login = new Login("kevin", "mabunda", "kev_1", "password", "+27769978777");
        assertEquals(
            "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.",
            login.registerUser()
        );
    }

    // ---- login messages ----

    @Test
    public void testLoginMessageSuccess() {
        Login login = new Login("kevin", "mabunda", "kev_1", "Zwothe190$", "+27769978563");
        assertEquals(
            "Welcome kevin, mabunda it is great to see you again.",
            login.returnLoginStatus("kev_1", "Zwothe190$")
        );
    }

    @Test
    public void testLoginMessageFail() {
        Login login = new Login("kevin", "mabunda", "kev_1", "Zwothe190$", "+2777777777");
        assertEquals(
            "Username or password incorrect, please try again.",
            login.returnLoginStatus("wrongUser", "wrongPass")
        );
    }
    //Add comprehensive unit tests for Login functionality
}
//Add comprehensive unit tests for Login functionality"