package chapter4.proxypattern;

public class DemoServiceProvider implements ServiceProvider {

    boolean auditIsOn;

    public DemoServiceProvider() {
        this.auditIsOn = false;
    }


    public DemoServiceProvider(boolean auditIsOn) {
        this.auditIsOn = auditIsOn;
    }

    @Override
    public Service createService() {
        if (!auditIsOn)
            return new DemoService();
        return new AuditService(new DemoService());
    }
}
