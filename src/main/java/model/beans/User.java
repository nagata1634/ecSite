package model.beans;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getUserImagePath() {
        return userImagePath;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    private int id;
    private String name;
    private String password;
    private String userImagePath;
    private boolean isAdmin;

    private User(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.password = builder.password;
        this.userImagePath = builder.userImagePath;
        this.isAdmin = builder.isAdmin;
    }

    public static class Builder {
        private int id;
        private String name;
        private String password;
        private String userImagePath;
        private boolean isAdmin;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder userImagePath(String userImagePath) {
            this.userImagePath = userImagePath;
            return this;
        }

        public Builder isAdmin(boolean isAdmin) {
            this.isAdmin = isAdmin;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public String toString() {
        StringBuilder build = new StringBuilder();
        build.append("User名 : ");
        build.append(name);
        return build.toString();
    }

    public boolean equal(Object o) {
        if (o == this) return true;
        if (o == null) return false;
        if (!(o instanceof Product)) return false;
        Product r = (Product)o;
        if (r.getId() == this.id && this.name.trim().equals(r.getName().trim())) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(this.id,this.name);
    }
}
