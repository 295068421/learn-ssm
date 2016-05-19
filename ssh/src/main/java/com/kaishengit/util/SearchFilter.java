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
                String[] array = key.split("_",4);
                if(array.length != 4) {
                    throw new IllegalArgumentException("查询参数错误");
                } else {
                    //q_s_like_title_or_daoyan
                    String propertyName = array[3];
                    String valueType = array[1];
                    String equalType = array[2];

                    Object queryValue = null;
                    if("s".equalsIgnoreCase(valueType)) {
                        queryValue = value;
                    } else if("f".equalsIgnoreCase(valueType)) {
                        queryValue = Float.valueOf(value);
                    } else if("i".equalsIgnoreCase(valueType)) {
                        queryValue = Integer.valueOf(value);
                    } else if("d".equalsIgnoreCase(valueType)) {
                        queryValue = Double.valueOf(value);
                    } else if("b".equalsIgnoreCase(valueType)) {
                        queryValue = Boolean.valueOf(value);
                    } else if("c".equalsIgnoreCase(valueType)) {
                        queryValue = Character.valueOf(value.charAt(0));
                    }


                    //System.out.println("PropertyName :" + propertyName + " equalType: " + equalType);
                    SearchFilter searchFilter = new SearchFilter();
                    searchFilter.setPropertyName(propertyName);
                    searchFilter.setEqualType(equalType);
                    searchFilter.setValue(queryValue);

                    searchFilters.add(searchFilter);

                    request.setAttribute(key,value);
                }
            }
        }

        return searchFilters;
    }
}
