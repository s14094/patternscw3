package s14094.patterns.cw003;

/**
 * @author Paweł Łakomiec
 **/
public class ExportingProcess_O1 extends ExportingProcess {

    long processId;

    public ExportingProcess_O1(long processNo) {
        super(processNo);
        this.processId = processNo;
    }

    @Override
    public ExportingProcess clone() {
        return new ExportingProcess_O1(processId);
    }
}
