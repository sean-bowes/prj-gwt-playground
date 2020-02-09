package com.koisoftware.monet.client.common.criteria;

import com.koisoftware.monet.client.common.data.IValue;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

@XStreamAlias("CriteriaClause")
public class CriteriaClause implements Serializable {
    public static final String TAG = "clause";
    private CompareOperator operator = CompareOperator.eq;
    private String propertyName;
    private IValue value;
    private IValue endValue;

    public CompareOperator getOperator() {
        return operator;
    }

    public void setOperator(CompareOperator operator) {
        this.operator = operator;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public IValue getValue() {
        return value;
    }

    public IValue getEndValue() {
        return endValue;
    }


    public void setValue(IValue value) {
        this.value = value;
    }

    public void setEndValue(IValue endValue) {
        this.endValue = endValue;
    }

    @Override
    public String toString() {
        return propertyName + " " + operator + " " + value.getValue();
    }

}
