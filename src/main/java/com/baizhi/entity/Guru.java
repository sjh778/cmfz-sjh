package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

public class Guru implements Serializable {
    private Integer id;

    private String dharmaname;

    private String headpic;

    private Date createdate;

    private Integer status;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDharmaname() {
        return dharmaname;
    }

    public void setDharmaname(String dharmaname) {
        this.dharmaname = dharmaname == null ? null : dharmaname.trim();
    }

    public String getHeadpic() {
        return headpic;
    }

    public void setHeadpic(String headpic) {
        this.headpic = headpic == null ? null : headpic.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Guru other = (Guru) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDharmaname() == null ? other.getDharmaname() == null : this.getDharmaname().equals(other.getDharmaname()))
            && (this.getHeadpic() == null ? other.getHeadpic() == null : this.getHeadpic().equals(other.getHeadpic()))
            && (this.getCreatedate() == null ? other.getCreatedate() == null : this.getCreatedate().equals(other.getCreatedate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDharmaname() == null) ? 0 : getDharmaname().hashCode());
        result = prime * result + ((getHeadpic() == null) ? 0 : getHeadpic().hashCode());
        result = prime * result + ((getCreatedate() == null) ? 0 : getCreatedate().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", dharmaname=").append(dharmaname);
        sb.append(", headpic=").append(headpic);
        sb.append(", createdate=").append(createdate);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}