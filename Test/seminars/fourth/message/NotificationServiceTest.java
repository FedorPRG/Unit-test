package seminars.fourth.message;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class NotificationServiceTest {
    @Test
    void messageServiceTest(){
        MessageService messageService = mock(MessageService.class);
        NotificationService notificationService = new NotificationService(messageService);
        messageService.sendMessage("text","user");
        verify(messageService, times(1)).
                sendMessage("text","user");

    }

}