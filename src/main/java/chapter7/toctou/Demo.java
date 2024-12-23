package chapter7.toctou;

public class Demo {

    void authorize(AuthenticationData data)
    {
        AuthenticationData dataCopy = new AuthenticationData(data);
        if ( passwordCheck(dataCopy.id,dataCopy.password )) // Time Of Check
        {
            _authorizeForFunctionA(dataCopy.id); // Time Of Use
            _authorizeForFunctionB(dataCopy.id);
        }
    }

    private boolean passwordCheck(long id, String password) {
        System.out.println("Pass for "+ id + " is being checked..");
        return true;
    }

    private void _authorizeForFunctionB(long id) {
        System.out.println(id +" is authorized for Operation-A");
    }

    private void _authorizeForFunctionA(long id) {
        System.out.println(id +" is authorized for Operation-B");
    }


}
