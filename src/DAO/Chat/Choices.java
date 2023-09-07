package DAO.Chat;


public class Choices {

    ChatGptMessage message;
    String finish_reason;
    Integer index;

    public Choices(ChatGptMessage message, String finish_reason, Integer index) {
        this.message = message;
        this.finish_reason = finish_reason;
        this.index = index;
    }

    public Choices() {
    }

    public ChatGptMessage getMessage() {
        return this.message;
    }

    public String getFinish_reason() {
        return this.finish_reason;
    }

    public Integer getIndex() {
        return this.index;
    }

    public void setMessage(ChatGptMessage message) {
        this.message = message;
    }

    public void setFinish_reason(String finish_reason) {
        this.finish_reason = finish_reason;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Choices)) return false;
        final Choices other = (Choices) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$message = this.getMessage();
        final Object other$message = other.getMessage();
        if (this$message == null ? other$message != null : !this$message.equals(other$message)) return false;
        final Object this$finish_reason = this.getFinish_reason();
        final Object other$finish_reason = other.getFinish_reason();
        if (this$finish_reason == null ? other$finish_reason != null : !this$finish_reason.equals(other$finish_reason))
            return false;
        final Object this$index = this.getIndex();
        final Object other$index = other.getIndex();
        if (this$index == null ? other$index != null : !this$index.equals(other$index)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Choices;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $message = this.getMessage();
        result = result * PRIME + ($message == null ? 43 : $message.hashCode());
        final Object $finish_reason = this.getFinish_reason();
        result = result * PRIME + ($finish_reason == null ? 43 : $finish_reason.hashCode());
        final Object $index = this.getIndex();
        result = result * PRIME + ($index == null ? 43 : $index.hashCode());
        return result;
    }

    public String toString() {
        return "Choices(message=" + this.getMessage() + ", finish_reason=" + this.getFinish_reason() + ", index=" + this.getIndex() + ")";
    }
}
