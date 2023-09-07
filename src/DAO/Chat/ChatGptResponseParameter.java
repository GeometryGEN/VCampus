package DAO.Chat;

import java.util.List;


public class ChatGptResponseParameter {

    String id;
    String object;
    String created;
    String model;
    Usage usage;
    List<Choices> choices;

    public ChatGptResponseParameter(String id, String object, String created, String model, Usage usage, List<Choices> choices) {
        this.id = id;
        this.object = object;
        this.created = created;
        this.model = model;
        this.usage = usage;
        this.choices = choices;
    }

    public ChatGptResponseParameter() {
    }

    public String getId() {
        return this.id;
    }

    public String getObject() {
        return this.object;
    }

    public String getCreated() {
        return this.created;
    }

    public String getModel() {
        return this.model;
    }

    public Usage getUsage() {
        return this.usage;
    }

    public List<Choices> getChoices() {
        return this.choices;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    public void setChoices(List<Choices> choices) {
        this.choices = choices;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ChatGptResponseParameter)) return false;
        final ChatGptResponseParameter other = (ChatGptResponseParameter) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$object = this.getObject();
        final Object other$object = other.getObject();
        if (this$object == null ? other$object != null : !this$object.equals(other$object)) return false;
        final Object this$created = this.getCreated();
        final Object other$created = other.getCreated();
        if (this$created == null ? other$created != null : !this$created.equals(other$created)) return false;
        final Object this$model = this.getModel();
        final Object other$model = other.getModel();
        if (this$model == null ? other$model != null : !this$model.equals(other$model)) return false;
        final Object this$usage = this.getUsage();
        final Object other$usage = other.getUsage();
        if (this$usage == null ? other$usage != null : !this$usage.equals(other$usage)) return false;
        final Object this$choices = this.getChoices();
        final Object other$choices = other.getChoices();
        if (this$choices == null ? other$choices != null : !this$choices.equals(other$choices)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ChatGptResponseParameter;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $object = this.getObject();
        result = result * PRIME + ($object == null ? 43 : $object.hashCode());
        final Object $created = this.getCreated();
        result = result * PRIME + ($created == null ? 43 : $created.hashCode());
        final Object $model = this.getModel();
        result = result * PRIME + ($model == null ? 43 : $model.hashCode());
        final Object $usage = this.getUsage();
        result = result * PRIME + ($usage == null ? 43 : $usage.hashCode());
        final Object $choices = this.getChoices();
        result = result * PRIME + ($choices == null ? 43 : $choices.hashCode());
        return result;
    }

    public String toString() {
        return "ChatGptResponseParameter(id=" + this.getId() + ", object=" + this.getObject() + ", created=" + this.getCreated() + ", model=" + this.getModel() + ", usage=" + this.getUsage() + ", choices=" + this.getChoices() + ")";
    }
}
