package com.gwf.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by gaowenfeng on 2017/3/31.
 */
@Entity
public class SysLog {
    @Id
    @GeneratedValue
    private Long id;
    private Long userid;
    private Date createdate;
    private String content;
    private String operation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "SysLog{" +
                "id=" + id +
                ", userid=" + userid +
                ", createdate=" + createdate +
                ", content='" + content + '\'' +
                ", operation='" + operation + '\'' +
                '}';
    }
}
