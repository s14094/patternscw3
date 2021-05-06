package s14094.patterns.cw003;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Paweł Łakomiec
 **/

@SpringBootTest(classes = Main.class)
class Tests {

    private Main main;
    private ExportingTaskBuilder exportingTaskBuilder;
    private ObjectPool<ExportingProcess> pool;

    @BeforeEach
    void setUp() throws Exception {
        main = new Main();
    }

    @Test
    @DisplayName("cw003 processId")
    void contextLoads() {

        assertEquals(new ExportingProcess_O1(1).processId, 1, "The same processId");
        assertEquals(new ExportingProcess_On(4).processId, 4, "The same processId");


    }

    @Test
    @DisplayName("cw003 builder test")
    void test1(){
        main.setUp();
        assertEquals(new ExportingTaskBuilder(pool, 1, 1).build().getComplexity(),
                new ExportingTask(pool, 1, 1).getComplexity());
    }

}

