import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


class Ex11Test {
    private final SMSGateway smsGateway = mock(SMSGateway.class);
    private final ArgumentCaptor<SMS> volunteerArgumentCaptor = ArgumentCaptor.forClass(SMS.class);
    private final Ex11 ex11 = new Ex11(smsGateway);

    private final String testPhoneNumber = "+48500500500";
    private final String testTextMessage = "Ale ma kota";

    @Test
    void shouldCallSendOnce() {
        // given & when
        ex11.wyslijSms(testPhoneNumber, testTextMessage);
        // then
        verify(smsGateway, times(1)).send(any(SMS.class));
        verifyNoMoreInteractions(smsGateway);
    }

    @Test
    void shouldThrowSMSGatewayException() {
        // given
        doThrow(SMSGatewayException.class).when(smsGateway).send(any(SMS.class));
        Exception exception = null;
        // when
        try {
            ex11.wyslijSms(testPhoneNumber, testTextMessage);
        } catch (SMSGatewayException e) {
            exception = e;
        }
        // then
        assertThat(exception).isNotNull();
    }

    @Test
    void shouldSendGivenTextToGivenNumber() {
        // given & when
        ex11.wyslijSms(testPhoneNumber, testTextMessage);
        // then
        Mockito.verify(smsGateway).send(volunteerArgumentCaptor.capture());
        SMS smsCaptured = volunteerArgumentCaptor.getValue();
        assertThat(smsCaptured.getPhoneNumber()).isEqualTo(testPhoneNumber);
        assertThat(smsCaptured.getText()).isEqualTo(testTextMessage);
    }
}
