public class Ex11 {
    SMSGateway smsGateway;

    public Ex11(SMSGateway smsGateway) {
        this.smsGateway = smsGateway;
    }

    public void wyslijSms(String numerTel, String trescSms) {
        smsGateway.send(new SMS(numerTel, trescSms));
    }
}