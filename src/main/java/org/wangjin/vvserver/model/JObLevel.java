package org.wangjin.vvserver.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class JObLevel implements Serializable {
    private Integer id;

    private String name;

    private String titleLevel;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JObLevel jobLevel = (JObLevel) o;
        return Objects.equals(name, jobLevel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public JObLevel() {

    }

    public JObLevel(String name) {
        this.name = name;
    }

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date createDate;

    private Boolean enabled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String gettitleLevel() {
        return titleLevel;
    }

    public void settitleLevel(String titleLevel) {
        this.titleLevel = titleLevel == null ? null : titleLevel.trim();
    }

    public Date getcreateDate() {
        return createDate;
    }

    public void setcreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
