package com.spring.springboot;

import java.util.Objects;

public class Mi {
    private int id;
    private String mi_name;
    private String mi_password;

    public Mi() {
    }

    public Mi(int id, String mi_name, String mi_password) {
        this.id = id;
        this.mi_name = mi_name;
        this.mi_password = mi_password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMi_name() {
        return mi_name;
    }

    public void setMi_name(String mi_name) {
        this.mi_name = mi_name;
    }

    public String getMi_password() {
        return mi_password;
    }

    public void setMi_password(String mi_password) {
        this.mi_password = mi_password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mi mi = (Mi) o;
        return id == mi.id &&
                mi_name.equals(mi.mi_name) &&
                mi_password.equals(mi.mi_password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mi_name, mi_password);
    }

    @Override
    public String toString() {
        return "Mi{" +
                "id=" + id +
                ", mi_name='" + mi_name + '\'' +
                ", mi_password='" + mi_password + '\'' +
                '}';
    }
}
