package seminars.fourth.database;



import org.junit.jupiter.api.Test;
import seminars.fourth.message.MessageService;
import seminars.fourth.message.NotificationService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class DataProcessorTest {

    @Test
    void dataProcessorTest(){
        Database database = mock(Database.class);
        DataProcessor dataProcessor = new DataProcessor(database);

        when(database.query(anyString())).thenReturn(Arrays.asList("test1","test2"));

        List<String> result = dataProcessor.processData("test3");

        verify(database, times(1)).
                query("test3");

        assertThat(result).isNotEmpty().hasSize(2).
                isEqualTo(Arrays.asList("test1","test2"));

    }

}