package seminars.fourth.weather;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

class WeatherReporterTest {

    @Test
    void weatherTest(){
        WeatherService weatherService = mock(WeatherService.class);
        WeatherReporter weatherReporter = new WeatherReporter(weatherService);

        when(weatherService.getCurrentTemperature()).thenReturn(25);

        String report = weatherReporter.generateReport();

        verify(weatherService, times(1)).getCurrentTemperature();

        assertThat(report).isEqualTo("Текущая температура: 25 градусов.");
    }

}