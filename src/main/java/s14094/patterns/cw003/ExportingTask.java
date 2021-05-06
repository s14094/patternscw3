package s14094.patterns.cw003;

/**
 * @author Paweł Łakomiec
 **/
public class ExportingTask implements Runnable {

    private final Service service = new Service();
    private ObjectPool<ExportingProcess> pool;
    private int threadNo;
    private int complexity;

    public ExportingTask(ObjectPool<ExportingProcess> pool, int threadNo, int complexity) {
        this.pool = pool;
        this.threadNo = threadNo;
        this.complexity = complexity;
    }

    public void run() {
        ExportingProcess exportingProcess = pool.borrowObject();
        System.out.println("Thread " + threadNo + ", Process: "
                + exportingProcess.getProcessNo() + ", Complex: " + complexity + " BUSY");

        switch (complexity) {
            case 1:
                int[] numbers1 = service.generateArray(complexity);
                if (numbers1 == null || numbers1.length == 0) {
                }
                long x = (long) (numbers1[0] + numbers1[numbers1.length - 1]) * numbers1.length / 2;

                break;
            case 2:

                int[] numbers2 = service.generateArray(complexity);
                int sum = 0;
                for (int number : numbers2) {
                    sum += number;
                }
                break;
            case 3:

                int[] numbers3 = service.generateArray(complexity);
                for (int i = 0; i < numbers3.length; i++) {
                    for (int j = 0; j < numbers3.length - 1; j++) {
                        if (numbers3[j] > numbers3[j + 1]) {
                            int temp = numbers3[j + 1];
                            numbers3[j + 1] = numbers3[j];
                            numbers3[j] = temp;
                        }
                    }
                }
                break;
            default:
                break;
        }


        pool.returnObject(exportingProcess);


        System.out.println("Thread " + threadNo + ", Process: "
                + exportingProcess.getProcessNo() + ", Complex: " + complexity + " RETURNED");
    }

    public ObjectPool<ExportingProcess> getPool() {
        return pool;
    }

    public void setPool(ObjectPool<ExportingProcess> pool) {
        this.pool = pool;
    }

    public int getThreadNo() {
        return threadNo;
    }

    public void setThreadNo(int threadNo) {
        this.threadNo = threadNo;
    }

    public int getComplexity() {
        return complexity;
    }

    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }
}
