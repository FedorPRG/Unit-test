package seminars.fourth.webService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class httpServiceTest {
    @Test
    void messageServiceTest() {
        HttpClient httpClient = mock(HttpClient.class);
        WebService webService = new WebService(httpClient);
        when(httpClient.getHTTPRequest(anyString())).thenReturn("Site");

        webService.getHTTP("test");

        verify(httpClient, times(1)).getHTTPRequest(anyString());

    }
}