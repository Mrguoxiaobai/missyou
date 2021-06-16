package com.lin.missyou.mode;

import com.fasterxml.jackson.core.type.TypeReference;
import com.lin.missyou.utils.GenericAndJson;
import com.lin.missyou.utils.ListAndJson;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.Resource;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "sku", schema = "missyou")
public class SkuEntity extends BaseEntity{
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal price;
    private BigDecimal discountPrice;
    private boolean online;
    private String img;
    private String title;
    private Long spuId;
    /*@Convert(converter= ListAndJson.class)*/
    private String specs;
    private String code;
    private int stock;
    private Long categoryId;
    private Long rootCategoryId;
    public List<Spec> getSpecs() {
        if (this.specs == null) {
            return Collections.emptyList();
        }
        return GenericAndJson.jsonToObject(this.specs, new TypeReference<List<Spec>>(){});
    }

    public void setSpecs(List<Spec> specs) {
        if(specs.isEmpty()){
            return;
        }
        this.specs = GenericAndJson.objectToJson(specs);
    }
}
