package com.oyo.spring4.plugins;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;
import org.mybatis.generator.internal.util.StringUtility;

import java.math.BigDecimal;
import java.util.*;

/**
 * mybatis的Java类型转换插件
 *
 * @author liurui
 * @date 2019/10/9 15:13
 */
public class JavaTypeResolverUtpChannelImpl extends JavaTypeResolverDefaultImpl {

    protected List<String> warnings;
    protected Properties properties = new Properties();
    protected Context context;
    protected boolean forceBigDecimals;
    protected Map<Integer, JavaTypeResolverDefaultImpl.JdbcTypeInformation> typeMap = new HashMap();

    public JavaTypeResolverUtpChannelImpl() {
        this.typeMap.put(2003, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("ARRAY", new FullyQualifiedJavaType(Object.class.getName())));
        this.typeMap.put(-5, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("BIGINT", new FullyQualifiedJavaType(Long.class.getName())));
        this.typeMap.put(-2, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("BINARY", new FullyQualifiedJavaType("byte[]")));
        this.typeMap.put(-7, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("BIT", new FullyQualifiedJavaType(Boolean.class.getName())));
        this.typeMap.put(2004, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("BLOB", new FullyQualifiedJavaType(String.class.getTypeName())));
        this.typeMap.put(16, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("BOOLEAN", new FullyQualifiedJavaType(Boolean.class.getName())));
        this.typeMap.put(1, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("CHAR", new FullyQualifiedJavaType(String.class.getName())));
        this.typeMap.put(2005, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("CLOB", new FullyQualifiedJavaType(String.class.getName())));
        this.typeMap.put(70, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("DATALINK", new FullyQualifiedJavaType(Object.class.getName())));
        this.typeMap.put(91, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("DATE", new FullyQualifiedJavaType(Date.class.getName())));
        this.typeMap.put(3, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("DECIMAL", new FullyQualifiedJavaType(BigDecimal.class.getName())));
        this.typeMap.put(2001, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("DISTINCT", new FullyQualifiedJavaType(Object.class.getName())));
        this.typeMap.put(8, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("DOUBLE", new FullyQualifiedJavaType(Double.class.getName())));
        this.typeMap.put(6, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("FLOAT", new FullyQualifiedJavaType(Double.class.getName())));
        this.typeMap.put(4, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("INTEGER", new FullyQualifiedJavaType(Integer.class.getName())));
        this.typeMap.put(2000, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("JAVA_OBJECT", new FullyQualifiedJavaType(Object.class.getName())));
        this.typeMap.put(-16, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("LONGNVARCHAR", new FullyQualifiedJavaType(String.class.getName())));
        this.typeMap.put(-4, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("LONGVARBINARY", new FullyQualifiedJavaType(String.class.getName())));
        this.typeMap.put(-1, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("LONGVARCHAR", new FullyQualifiedJavaType(String.class.getName())));
        this.typeMap.put(-15, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("NCHAR", new FullyQualifiedJavaType(String.class.getName())));
        this.typeMap.put(2011, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("NCLOB", new FullyQualifiedJavaType(String.class.getName())));
        this.typeMap.put(-9, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("NVARCHAR", new FullyQualifiedJavaType(String.class.getName())));
        this.typeMap.put(0, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("NULL", new FullyQualifiedJavaType(Object.class.getName())));
        this.typeMap.put(2, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("NUMERIC", new FullyQualifiedJavaType(BigDecimal.class.getName())));
        this.typeMap.put(1111, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("OTHER", new FullyQualifiedJavaType(Object.class.getName())));
        this.typeMap.put(7, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("REAL", new FullyQualifiedJavaType(Float.class.getName())));
        this.typeMap.put(2006, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("REF", new FullyQualifiedJavaType(Object.class.getName())));
        this.typeMap.put(5, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("SMALLINT", new FullyQualifiedJavaType(Integer.class.getName())));
        this.typeMap.put(2002, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("STRUCT", new FullyQualifiedJavaType(Object.class.getName())));
        this.typeMap.put(92, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("TIME", new FullyQualifiedJavaType(Date.class.getName())));
        this.typeMap.put(93, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("TIMESTAMP", new FullyQualifiedJavaType(Date.class.getName())));
        this.typeMap.put(-6, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("TINYINT", new FullyQualifiedJavaType(Integer.class.getName())));
        this.typeMap.put(-3, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("VARBINARY", new FullyQualifiedJavaType("byte[]")));
        this.typeMap.put(12, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("VARCHAR", new FullyQualifiedJavaType(String.class.getName())));
    }

    public void addConfigurationProperties(Properties properties) {
        this.properties.putAll(properties);
        this.forceBigDecimals = StringUtility.isTrue(properties.getProperty("forceBigDecimals"));
    }

    public FullyQualifiedJavaType calculateJavaType(IntrospectedColumn introspectedColumn) {
        FullyQualifiedJavaType answer = null;
        JavaTypeResolverDefaultImpl.JdbcTypeInformation jdbcTypeInformation = (JavaTypeResolverDefaultImpl.JdbcTypeInformation) this.typeMap.get(introspectedColumn.getJdbcType());
        if (jdbcTypeInformation != null) {
            answer = jdbcTypeInformation.getFullyQualifiedJavaType();
            answer = this.overrideDefaultType(introspectedColumn, answer);
        }

        return answer;
    }

    protected FullyQualifiedJavaType overrideDefaultType(IntrospectedColumn column, FullyQualifiedJavaType defaultType) {
        FullyQualifiedJavaType answer = defaultType;
        switch (column.getJdbcType()) {
            case -7:
                answer = this.calculateBitReplacement(column, defaultType);
                break;
            case 2:
            case 3:
                answer = this.calculateBigDecimalReplacement(column, defaultType);
        }

        return answer;
    }

    protected FullyQualifiedJavaType calculateBitReplacement(IntrospectedColumn column, FullyQualifiedJavaType defaultType) {
        FullyQualifiedJavaType answer;
        if (column.getLength() > 1) {
            answer = new FullyQualifiedJavaType("byte[]");
        } else {
            answer = defaultType;
        }

        return answer;
    }

    protected FullyQualifiedJavaType calculateBigDecimalReplacement(IntrospectedColumn column, FullyQualifiedJavaType defaultType) {
        FullyQualifiedJavaType answer;
        if (column.getScale() <= 0 && column.getLength() <= 18 && !this.forceBigDecimals) {
            if (column.getLength() > 9) {
                answer = new FullyQualifiedJavaType(Double.class.getName());
            } else if (column.getLength() > 4) {
                answer = new FullyQualifiedJavaType(Integer.class.getName());
            } else {
                answer = new FullyQualifiedJavaType(Short.class.getName());
            }
        } else {
            answer = defaultType;
        }

        return answer;
    }

    public String calculateJdbcTypeName(IntrospectedColumn introspectedColumn) {
        String answer = null;
        JavaTypeResolverDefaultImpl.JdbcTypeInformation jdbcTypeInformation = (JavaTypeResolverDefaultImpl.JdbcTypeInformation) this.typeMap.get(introspectedColumn.getJdbcType());
        if (jdbcTypeInformation != null) {
            answer = jdbcTypeInformation.getJdbcTypeName();
        }

        return answer;
    }

    public void setWarnings(List<String> warnings) {
        this.warnings = warnings;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public static class JdbcTypeInformation {
        private String jdbcTypeName;
        private FullyQualifiedJavaType fullyQualifiedJavaType;

        public JdbcTypeInformation(String jdbcTypeName, FullyQualifiedJavaType fullyQualifiedJavaType) {
            this.jdbcTypeName = jdbcTypeName;
            this.fullyQualifiedJavaType = fullyQualifiedJavaType;
        }

        public String getJdbcTypeName() {
            return this.jdbcTypeName;
        }

        public FullyQualifiedJavaType getFullyQualifiedJavaType() {
            return this.fullyQualifiedJavaType;
        }
    }
}

