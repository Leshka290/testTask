package ru.mytask.testtask.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class FrameworkModel {

    @Id
    @GeneratedValue
    private long pk;
    private String name;
    private String language;

    public long getPk() {
        return pk;
    }

    public void setPk(long pk) {
        this.pk = pk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FrameworkModel that = (FrameworkModel) o;
        return pk == that.pk && Objects.equals(name, that.name) && Objects.equals(language, that.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, name, language);
    }
}
