package s14094.patterns.cw003;

import java.util.concurrent.TimeUnit;

/**
 * @author Paweł Łakomiec
 **/
public class ExportingProcess_On extends ExportingProcess {

    long processId;

    public ExportingProcess_On(long processNo) {
        super(processNo);
        this.processId = processNo;
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ExportingProcess clone() {
        return new ExportingProcess_On(processId);
    }

}
