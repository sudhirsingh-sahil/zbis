package com.zopper.bsi.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zopper.bsi.enums.FormDataType;
import com.zopper.bsi.models.BaseModel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by sudhir on 19/5/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BrandFormFeildsRequest{

    @NotEmpty
    String displyLabel;
    @NotEmpty
    String paramKey;

    @NotNull
    FormDataType datatype;
    @NotNull
    Boolean required;

    @NotNull
    Long brandId;

    String brandCategory;

    String options;
    String defaultValue;

    public String getDisplyLabel() {
        return displyLabel;
    }

    public void setDisplyLabel(String displyLabel) {
        this.displyLabel = displyLabel;
    }

    public String getParamKey() {
        return paramKey;
    }

    public void setParamKey(String paramKey) {
        this.paramKey = paramKey;
    }

    public FormDataType getDatatype() {
        return datatype;
    }

    public void setDatatype(FormDataType datatype) {
        this.datatype = datatype;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getBrandCategory() {
        return brandCategory;
    }

    public void setBrandCategory(String brandCategory) {
        this.brandCategory = brandCategory;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("displyLabel", displyLabel)
                .append("paramKey", paramKey)
                .append("datatype", datatype)
                .append("required", required)
                .append("brandId", brandId)
                .append("brandCategory", brandCategory)
                .append("options", options)
                .append("defaultValue", defaultValue)
                .toString();
    }
}
