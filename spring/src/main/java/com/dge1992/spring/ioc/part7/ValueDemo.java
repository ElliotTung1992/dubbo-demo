package com.dge1992.spring.ioc.part7;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 字面值
 */
public class ValueDemo {

    private String value;
    private RefDemo refDemo;
    private BeanDemo beanDemo;
    private List<String> names;
    private Set<Integer> ages;
    private Map<String, Object> maps;
    private String isNull;

    public ValueDemo() {
    }

    public ValueDemo(String value, RefDemo refDemo, BeanDemo beanDemo, List<String> names, Set<Integer> ages, Map<String, Object> maps, String isNull) {
        this.value = value;
        this.refDemo = refDemo;
        this.beanDemo = beanDemo;
        this.names = names;
        this.ages = ages;
        this.maps = maps;
        this.isNull = isNull;
    }

    public RefDemo getRefDemo() {
        return refDemo;
    }

    public void setRefDemo(RefDemo refDemo) {
        this.refDemo = refDemo;
    }

    public BeanDemo getBeanDemo() {
        return beanDemo;
    }

    public void setBeanDemo(BeanDemo beanDemo) {
        this.beanDemo = beanDemo;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public Set<Integer> getAges() {
        return ages;
    }

    public void setAges(Set<Integer> ages) {
        this.ages = ages;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public String getIsNull() {
        return isNull;
    }

    public void setIsNull(String isNull) {
        this.isNull = isNull;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ValueDemo{" +
                "value='" + value + '\'' +
                ", refDemo=" + refDemo +
                ", beanDemo=" + beanDemo +
                ", names=" + names +
                ", ages=" + ages +
                ", maps=" + maps +
                ", isNull='" + isNull + '\'' +
                '}';
    }
}
