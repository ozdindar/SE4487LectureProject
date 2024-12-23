package chapter7.toctou;

public class AuthenticationData {
    long id;
    String password;

    public AuthenticationData(AuthenticationData data) {
        id = data.id;
        password = data.password;
    }
}
