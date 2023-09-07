package DAO.Chat;


public class ChatGptMessage {
        String role;
        String content;

        public ChatGptMessage(String role, String content) {
                this.role = role;
                this.content = content;
        }

        public ChatGptMessage() {
        }

        public String getRole() {
                return this.role;
        }

        public String getContent() {
                return this.content;
        }

        public void setRole(String role) {
                this.role = role;
        }

        public void setContent(String content) {
                this.content = content;
        }

        public boolean equals(final Object o) {
                if (o == this) return true;
                if (!(o instanceof ChatGptMessage)) return false;
                final ChatGptMessage other = (ChatGptMessage) o;
                if (!other.canEqual((Object) this)) return false;
                final Object this$role = this.getRole();
                final Object other$role = other.getRole();
                if (this$role == null ? other$role != null : !this$role.equals(other$role)) return false;
                final Object this$content = this.getContent();
                final Object other$content = other.getContent();
                if (this$content == null ? other$content != null : !this$content.equals(other$content)) return false;
                return true;
        }

        protected boolean canEqual(final Object other) {
                return other instanceof ChatGptMessage;
        }

        public int hashCode() {
                final int PRIME = 59;
                int result = 1;
                final Object $role = this.getRole();
                result = result * PRIME + ($role == null ? 43 : $role.hashCode());
                final Object $content = this.getContent();
                result = result * PRIME + ($content == null ? 43 : $content.hashCode());
                return result;
        }

        public String toString() {
                return "ChatGptMessage(role=" + this.getRole() + ", content=" + this.getContent() + ")";
        }
}
