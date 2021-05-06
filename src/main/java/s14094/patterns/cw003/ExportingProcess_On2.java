package s14094.patterns.cw003;

/**
 * @author Paweł Łakomiec
 **/
public class ExportingProcess_On2 extends ExportingProcess {

    long processId;

    public ExportingProcess_On2(long processNo) {
        super(processNo);
        this.processId = processNo;
    }

    @Override
    public ExportingProcess clone() {
        return new ExportingProcess_On2(processId);
    }

}
