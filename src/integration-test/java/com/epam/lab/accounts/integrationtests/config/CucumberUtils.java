package com.epam.lab.accounts.integrationtests.config;

import io.cucumber.datatable.DataTable;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import static java.util.Arrays.asList;

public class CucumberUtils {


    public static <T> T toObject(final DataTable dataTable, Class<T> clazz) {

        final T obj = createNewInstance(clazz);

        final Map<String, String> data = dataTable.asMap(String.class, String.class);

        for (final Field field : getFieldNames(clazz)) {

            if (data.containsKey(field.getName())) {
                final String dataTableFieldValue = data.get(field.getName());
                final Object fieldValue;
                if (Enum.class.isAssignableFrom(field.getType()))
                {
                    fieldValue = Enum.valueOf((Class)field.getType(), dataTableFieldValue);
                }
                else
                {
                    fieldValue = dataTableFieldValue;
                }
                ReflectionTestUtils.setField(obj, field.getName(), fieldValue);
            }
        }

        return obj;
    }

    private static <T> T createNewInstance(Class<T> clazz) {
        T t = null;
        try {
             t = ReflectionUtils.accessibleConstructor(clazz).newInstance();
        } catch (NoSuchMethodException |
                IllegalAccessException |
                InstantiationException |
                InvocationTargetException e) {
            e.printStackTrace();
        }
        return t;
    }

    public static List<Field> getFieldNames(Class<?> clazz) {

        return asList(clazz.getDeclaredFields());
    }
}
