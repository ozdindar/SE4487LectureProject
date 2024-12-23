package chapter4.proxypattern;

public class AuditService implements Service{
    Service targetService;

    long funcACounter =0;
    long funcBCounter =0;
    long funcCCounter =0;

    public AuditService(Service targetService) {
        this.targetService = targetService;
    }

    @Override
    public int funcA() {
        funcACounter++;
        return targetService.funcA();
    }

    @Override
    public int funcB() {
        funcBCounter++;
        return targetService.funcB();
    }

    @Override
    public int funcC() {
        funcCCounter++;
        return targetService.funcC();
    }

    @Override
    public void printReport() {
        System.out.println( " funcA:" + funcACounter +
                            "\n funcB:"+funcBCounter +
                            "\n funcC:"+ funcCCounter);
    }
}
