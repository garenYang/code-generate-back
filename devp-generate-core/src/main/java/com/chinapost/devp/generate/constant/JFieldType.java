package com.chinapost.devp.generate.constant;

import com.chinapost.devp.common.validator.Check;

import java.util.HashMap;
import java.util.Map;

/**
 * 字段类型对应关系
 *
 * @author: cpit
 * @date: 2020/12/10
 */
public enum JFieldType {
    /**
     * 整型
     */
    INTEGER("Integer", MySqlType.INT, "INTEGER"),
    /**
     * 布尔型
     */
    BOOLEAN("Boolean", MySqlType.TINYINT, "BOOLEAN"),
    /**
     * 短整型
     */
    SHORT("Short", MySqlType.SMALLINT, "SMALLINT"),
    /**
     * 长整型
     */
    LONG("Long", MySqlType.BIGINT, "BIGINT"),
    /**
     * 字符串
     */
    STRING("String", MySqlType.VARCHAR, "VARCHAR"),
    /**
     * 日期
     */
    LOCALDATE("LocalDate", MySqlType.DATE, "TIMESTAMP"),
    /**
     * 日期
     */
    LOCALDATETIME("LocalDateTime", MySqlType.DATETIME, "TIMESTAMP"),
    /**
     * 日期
     */
    DATE("Date", MySqlType.DATETIME, "TIMESTAMP"),
    /**
     * 双浮点型
     */
    DOUBLE("Double", MySqlType.DOUBLE, "DOUBLE"),
    /**
     * 浮点型
     */
    FLOAT("Float", MySqlType.FLOAT, "FLOAT"),
    /**
     * 超大浮点数
     */
    BIGDECIMAL("BigDecimal", MySqlType.DECIMAL, "DECIMAL");

    private static final Map<String, JFieldType> LOOKUP = new HashMap<>();

    static {
        for (JFieldType e : JFieldType.values()) {
            LOOKUP.put(e.javaType, e);
        }
    }

    private final String javaType;
    private final String mySqlType;
    private final String jdbcType;

    JFieldType(String javaType, String mySqlType, String jdbcType) {
        this.javaType = javaType;
        this.mySqlType = mySqlType;
        this.jdbcType = jdbcType;
    }

    public static JFieldType find(String javaType) {
        return LOOKUP.get(javaType);
    }


    /**
     * 校验有效性
     */
    @Check
    public static final boolean validate(String javaType) {
        JFieldType theEnum = find(javaType);
        return theEnum != null;
    }

    public static String mapperMySqlType(String javaType) {
        JFieldType theEnum = find(javaType);
        if (theEnum != null) {
            return theEnum.mySqlType;
        }
        return null;
    }

    public static String mapperJdbcType(String javaType) {
        JFieldType theEnum = find(javaType);
        if (theEnum != null) {
            return theEnum.jdbcType;
        }
        return null;
    }

    public String getJavaType() {
        return javaType;
    }

    public String getMySqlType() {
        return mySqlType;
    }

    public String getJdbcType() {
        return jdbcType;
    }
}
