// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Auth {
    public static final String REGEX = "^[a-zA-Z0-9_]*$";
    public static void main(String[] args) {
        try {
            checkAuth ("Admin_123", "123_Admin", "321_Admin");
            System.out.println("Успешный вход");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Ошибка входа");
        }
    }
    private static void checkAuth(String login, String pass, String confirmPass) throws WrongLoginException,WrongPasswordException {
        if (!login.matches(REGEX) || login.length()>20) {
            throw new WrongLoginException();
        }
        if (!pass.matches(REGEX) || pass.length()>20 || !pass.equals(confirmPass)) {
            throw new WrongPasswordException();
        }
    }
}
