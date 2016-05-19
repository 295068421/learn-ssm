package com.kaishengit.util;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;

public class SearchFilter {

    private String propertyName;
    private String equalType;
    private Object value;

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getEqualType() {
        return equalType;
    }

    public void setEqualType(String equalType) {
        this.equalType = equalType;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public static List<SearchFilter> builderSearchFilter(HttpServletRequest request) {
        Enumeration<String> enumeration = request.getParameterNames();
        List<SearchFilter> searchFilters = Lists.newArrayList();

        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement();
            String value = request.getParameter(key);
            value = Strings.toUTF8(value);

            System.out.println("Key: " + key);
            if(key.startsWith("q_") && StringUtils.isNotEmpty(value)) {
                String[] array = key.split("_");
                if(array.length != 3) {
                    throw new IllegalArgumentException("查询参数错误");
                } else {
                    String propertyName = array[1];
                    String equalType = array[2];

                    //System.out.println("PropertyName :" + propertyName + " equalType: " + equalType);
                    SearchFilter searchFilter = new SearchFilter();
                    searchFilter.setPropertyName(propertyName);
                    searchFilter.setEqualType(equalType);
                    searchFilter.setValue(value);

                    searchFilters.add(searchFilter);

                }
            }
        }

        return searchFilters;
    }
}
