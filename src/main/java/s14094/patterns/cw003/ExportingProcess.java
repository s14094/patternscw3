package s14094.patterns.cw003;

/**
 * @author Paweł Łakomiec
 **/
public abstract class ExportingProcess {

    private final long processNo;

    protected ExportingProcess(long processNo) {
        this.processNo = processNo;
        System.out.println("New object: " + processNo + " ");
    }

    public long getProcessNo() {
        return processNo;
    }

    public abstract ExportingProcess clone();

}
