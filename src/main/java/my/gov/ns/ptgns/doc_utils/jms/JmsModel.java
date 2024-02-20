package my.gov.ns.ptgns.doc_utils.jms;

public class JmsModel {
    String messageId;
    String messageContent;

    public JmsModel(String messageId, String messageContent) {
        this.messageId = messageId;
        this.messageContent = messageContent;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
}
