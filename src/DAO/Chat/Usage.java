package DAO.Chat;


public class Usage {

    String prompt_tokens;
    String completion_tokens;
    String total_tokens;

    public Usage(String prompt_tokens, String completion_tokens, String total_tokens) {
        this.prompt_tokens = prompt_tokens;
        this.completion_tokens = completion_tokens;
        this.total_tokens = total_tokens;
    }

    public Usage() {
    }

    public String getPrompt_tokens() {
        return this.prompt_tokens;
    }

    public String getCompletion_tokens() {
        return this.completion_tokens;
    }

    public String getTotal_tokens() {
        return this.total_tokens;
    }

    public void setPrompt_tokens(String prompt_tokens) {
        this.prompt_tokens = prompt_tokens;
    }

    public void setCompletion_tokens(String completion_tokens) {
        this.completion_tokens = completion_tokens;
    }

    public void setTotal_tokens(String total_tokens) {
        this.total_tokens = total_tokens;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Usage)) return false;
        final Usage other = (Usage) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$prompt_tokens = this.getPrompt_tokens();
        final Object other$prompt_tokens = other.getPrompt_tokens();
        if (this$prompt_tokens == null ? other$prompt_tokens != null : !this$prompt_tokens.equals(other$prompt_tokens))
            return false;
        final Object this$completion_tokens = this.getCompletion_tokens();
        final Object other$completion_tokens = other.getCompletion_tokens();
        if (this$completion_tokens == null ? other$completion_tokens != null : !this$completion_tokens.equals(other$completion_tokens))
            return false;
        final Object this$total_tokens = this.getTotal_tokens();
        final Object other$total_tokens = other.getTotal_tokens();
        if (this$total_tokens == null ? other$total_tokens != null : !this$total_tokens.equals(other$total_tokens))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Usage;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $prompt_tokens = this.getPrompt_tokens();
        result = result * PRIME + ($prompt_tokens == null ? 43 : $prompt_tokens.hashCode());
        final Object $completion_tokens = this.getCompletion_tokens();
        result = result * PRIME + ($completion_tokens == null ? 43 : $completion_tokens.hashCode());
        final Object $total_tokens = this.getTotal_tokens();
        result = result * PRIME + ($total_tokens == null ? 43 : $total_tokens.hashCode());
        return result;
    }

    public String toString() {
        return "Usage(prompt_tokens=" + this.getPrompt_tokens() + ", completion_tokens=" + this.getCompletion_tokens() + ", total_tokens=" + this.getTotal_tokens() + ")";
    }
}
