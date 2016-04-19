package com.kaishengit.test;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class SQLUtil {

    public static String buildSQL(Map<String,Object> param) {
        String sql = "select * from t_product";

        StringBuilder where = new StringBuilder("");
        if(param.get("type") != null) {
            where.append("type = ? ");
        }
        if(param.get("pinpai") != null) {
            where.append("and pinpai = ? ");
        }
        if(param.get("yongtu") != null) {
            where.append("and yongtu = ? ");
        }
        if(param.get("jiekou") != null) {
            where.append("and jiekou = ? ");
        }
        if(param.get("size") != null) {
            where.append("and size = ? ");
        }

        if(StringUtils.isEmpty(where)) {
            return sql;
        } else {
            sql += " where ";
            String whereSql = where.toString();
            if(whereSql.startsWith("and")) {
                whereSql = whereSql.substring(whereSql.indexOf("and")+3);
            } else if(whereSql.startsWith("or")) {
                whereSql = whereSql.substring(whereSql.indexOf("or")+2);
            }

            sql += whereSql;
        }
        return sql;
    }

}
