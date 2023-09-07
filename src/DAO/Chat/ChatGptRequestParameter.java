package DAO.Chat;

import java.util.ArrayList;
import java.util.List;


public class ChatGptRequestParameter {

    String model = "gpt-3.5-turbo";

    List<ChatGptMessage> messages = new ArrayList<>();

    public ChatGptRequestParameter(String model, List<ChatGptMessage> messages) {
        this.model = model;
        this.messages = messages;
    }

    public ChatGptRequestParameter() {
    }

    public void addMessages(ChatGptMessage message) {
        this.messages.add(message);
    }

    public String getModel() {
        return this.model;
    }

    public List<ChatGptMessage> getMessages() {
        return this.messages;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setMessages(List<ChatGptMessage> messages) {
        this.messages = messages;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ChatGptRequestParameter)) return false;
        final ChatGptRequestParameter other = (ChatGptRequestParameter) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$model = this.getModel();
        final Object other$model = other.getModel();
        if (this$model == null ? other$model != null : !this$model.equals(other$model)) return false;
        final Object this$messages = this.getMessages();
        final Object other$messages = other.getMessages();
        if (this$messages == null ? other$messages != null : !this$messages.equals(other$messages)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ChatGptRequestParameter;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $model = this.getModel();
        result = result * PRIME + ($model == null ? 43 : $model.hashCode());
        final Object $messages = this.getMessages();
        result = result * PRIME + ($messages == null ? 43 : $messages.hashCode());
        return result;
    }

    public String toString() {
        return "ChatGptRequestParameter(model=" + this.getModel() + ", messages=" + this.getMessages() + ")";
    }
}
