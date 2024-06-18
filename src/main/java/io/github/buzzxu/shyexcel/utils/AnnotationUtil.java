package io.github.buzzxu.shyexcel.utils;

import io.github.buzzxu.shyexcel.annotation.ExcelCol;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

/**
 * @author xux
 *  2023年10月16日 12:57:05
 */
public class AnnotationUtil {

    public static List<Field> getAnnotatedFields(Class<?> clazz) {
        return Arrays.stream(clazz.getDeclaredFields())
                .filter(field -> field.getAnnotation(ExcelCol.class) != null)
                .toList();
    }

    public static  Class<?>  findFieldType(Field field,int index){
        Type genericFieldType = field.getGenericType();
        if(genericFieldType instanceof ParameterizedType){
            ParameterizedType aType = (ParameterizedType) genericFieldType;
            Type[] fieldArgTypes = aType.getActualTypeArguments();
            return (Class<?>)fieldArgTypes[index];
        }
        throw new IllegalArgumentException("not found field `%s` argument type".formatted(field.getName()));
    }
    public static boolean isDefaultValues(Annotation annotation) {
        try {
            for (Method method : annotation.annotationType().getDeclaredMethods()) {
                Object defaultValue = method.getDefaultValue();
                Object actualValue = method.invoke(annotation);

                if (defaultValue == null && actualValue != null) {
                    return false;
                }

                if (defaultValue != null && !defaultValue.equals(actualValue)) {
                    return false;
                }
            }
        } catch (Exception e) {
            // Handle exception here
        }

        return true;
    }
}
