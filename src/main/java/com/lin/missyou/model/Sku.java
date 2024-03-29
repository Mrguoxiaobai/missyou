package com.lin.missyou.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import com.lin.missyou.utils.GenericAndJson;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@Table(name = "sku", schema = "missyou")
@Where( clause = "delete_time is null")
public class Sku extends Base {
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
    private String specs;
    private String code;
    private Long stock;
    private Long categoryId;
    private Long rootCategoryId;
    public List<Spec> getSpecs() {
        if (this.specs == null) {
            return Collections.emptyList();
        }
        return GenericAndJson.JsonToObject(this.specs, new TypeReference<List<Spec>>(){});
    }

    public void setSpecs(List<Spec> specs) {
        if(specs.isEmpty()){
            return;
        }
        this.specs = GenericAndJson.objectToJson(specs);
    }
    public BigDecimal getActualPrice() {
        return discountPrice == null ? this.price : this.discountPrice;
    }
    @JsonIgnore
    public List<String> getSpecValueList() {
        return this.getSpecs().stream().map(Spec::getValue).collect(Collectors.toList());
    }

}
