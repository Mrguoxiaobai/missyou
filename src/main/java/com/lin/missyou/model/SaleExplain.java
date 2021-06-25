package com.lin.missyou.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @ClassName: SaleExplain
 * @Author: Mrguo
 * @Description:
 * @Date: 2021/6/2518:39
 * @Version: 1.0
 */
@Entity
@Table(name = "sale_explain", schema = "missyou", catalog = "")
public class SaleExplain {
    private int id;
    private Byte fixed;
    private String text;
    private Integer spuId;
    private Integer index;
    private Integer replaceId;
    private Timestamp createTime;
    private Timestamp deleteTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "fixed")
    public Byte getFixed() {
        return fixed;
    }

    public void setFixed(Byte fixed) {
        this.fixed = fixed;
    }

    @Basic
    @Column(name = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "spu_id")
    public Integer getSpuId() {
        return spuId;
    }

    public void setSpuId(Integer spuId) {
        this.spuId = spuId;
    }

    @Basic
    @Column(name = "index")
    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    @Basic
    @Column(name = "replace_id")
    public Integer getReplaceId() {
        return replaceId;
    }

    public void setReplaceId(Integer replaceId) {
        this.replaceId = replaceId;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "delete_time")
    public Timestamp getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Timestamp deleteTime) {
        this.deleteTime = deleteTime;
    }

    @Basic
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleExplain that = (SaleExplain) o;
        return id == that.id && Objects.equals(fixed, that.fixed) && Objects.equals(text, that.text) && Objects.equals(spuId, that.spuId) && Objects.equals(index, that.index) && Objects.equals(replaceId, that.replaceId) && Objects.equals(createTime, that.createTime) && Objects.equals(deleteTime, that.deleteTime) && Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fixed, text, spuId, index, replaceId, createTime, deleteTime, updateTime);
    }
}
