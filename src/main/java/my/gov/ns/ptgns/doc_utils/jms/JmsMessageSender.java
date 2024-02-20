package my.gov.ns.ptgns.doc_utils.jms;

import org.springframework.jms.core.JmsTemplate;

import javax.jms.Queue;
import java.util.HashMap;
import java.util.Map;

public class JmsMessageSender {
    private JmsTemplate jmsTemplate;
    private Queue queue;

    public void simpleSend() {
        jmsTemplate.send(queue, s -> s.createTextMessage("Hello JMS!"));
    }

    public void sendMessage(JmsModel jmsModel) {
        System.out.println("Jms Message Sender : " + jmsModel);
        Map<String, Object> map = new HashMap<>();
        map.put("messageId", jmsModel.getMessageId());
        map.put("messageContent", jmsModel.getMessageContent());
        jmsTemplate.convertAndSend(map);
    }
}
