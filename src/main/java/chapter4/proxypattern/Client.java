package chapter4.proxypattern;

import java.security.SecureRandom;
import java.util.Random;

public class Client {

    Random rng = new SecureRandom();
    void someWeirdBusiness(Service service)
    {
        int result=0;
        for (int i = 0; i < 10; i++) {
            if (rng.nextInt()%3==0)
                service.funcA();
            int bc = rng.nextInt(10);

            for (int j = 0; j < bc; j++) {
                result = service.funcB()+ service.funcC();
                if (rng.nextBoolean())
                    break;
            }
            if (bc%2==1)
                result += 2*service.funcC();

        }
        System.out.println("The job is accomplished with result:"+ result);
    }

    public static void main(String[] args) {
        ServiceProvider sp = new DemoServiceProvider(true);
        Client client = new Client();
        Service service = sp.createService();
        client.someWeirdBusiness(service);
        service.printReport();

    }

}
