public interface SMSGateway {

    void send(SMS sms) throws SMSGatewayException;
}
