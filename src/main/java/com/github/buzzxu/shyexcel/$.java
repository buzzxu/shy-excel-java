package com.github.buzzxu.shyexcel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.buzzxu.shyexcel.exceptions.ShyExcelException;
import com.github.buzzxu.shyexcel.objects.*;
import com.github.buzzxu.shyexcel.utils.Strings;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.util.List;

import static com.github.buzzxu.shyexcel.utils.AnnotationUtil.*;

/**
 * @author xux
 * @date 2023年10月13日 22:20:38
 */
public class $ {

    public static <T> void write(List<T> data, Class<T> clazz, HttpServletResponse response, DataFormat format) throws ShyExcelException {
        byte[] bytes = toBytes(data, clazz, format);
        response.setContentType(format.contentType());
        try {
            ServletOutputStream out = response.getOutputStream();
            out.write(bytes);
            out.flush();
        }catch (Exception ex){
            throw new ShyExcelException(ex);
        }

    }


    public static <T> void toFile(String file,List<T> data,Class<T> clazz,DataFormat format)throws ShyExcelException {
        byte[] bytes = toBytes(data, clazz, format);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(bytes);
        } catch (IOException e) {
            throw new ShyExcelException(e);
        }
    }

    public static <T> byte[] toBytes(List<T> data,Class<T> clazz,DataFormat format) throws ShyExcelException {
        Table table = to(data,clazz);
        return toBytes(table,format);
    }

    public static <T> String toJson(List<T> data,Class<T> clazz) throws ShyExcelException {
        Table table = to(data,clazz);
        try {
            return JSON.toString(table);
        } catch (JsonProcessingException e) {
            throw new ShyExcelException(e);
        }
    }
    public static <T> Table to(List<T> data,Class<T> clazz){
        if(data == null){
            throw new IllegalArgumentException("data is null");
        }
        if(clazz == null){
            throw new IllegalArgumentException("class is null");
        }
        Table table = new Table();
        table.setSheets(List.of(toSheet(data,clazz)));
        return table;
    }

    private static <T> Sheet toSheet(List<T> data,Class<T> clazz){
        Sheet<T> sheet = new Sheet<T>();
        if(!clazz.isAnnotationPresent(com.github.buzzxu.shyexcel.annotation.Sheet.class)){
            throw new IllegalArgumentException("not found "+clazz.getSimpleName() + " @com.github.buzzxu.shyexcel.annotation.Sheet.");
        }
        com.github.buzzxu.shyexcel.annotation.Sheet $sheet = clazz.getAnnotation(com.github.buzzxu.shyexcel.annotation.Sheet.class);
        sheet.setName($sheet.name());
        if($sheet.active()){
            sheet.setActive(true);
        }
        if($sheet.visible()){
            sheet.setVisible(true);
        }
        //headers
        sheet.setHeader(toHeader(clazz,$sheet));
        sheet.setData(data);
        return sheet;
    }

    private static Header toHeader(Class<?> clazz,com.github.buzzxu.shyexcel.annotation.Sheet sheet){
        Header header = new Header();
        com.github.buzzxu.shyexcel.annotation.Header $header = sheet.header();
        if(!Strings.isNullOrEmpty($header.title())){
            header.setTitle($header.title());
        }
        if($header.freezeCol() > 0){
            header.setFreezeCol($header.freezeCol());
        }
        if($header.height() > 0f){
            header.setHeight($header.height());
        }
        if(!Strings.isNullOrEmpty($header.fontFamily())){
            header.setFontFamily($header.fontFamily());
        }
        if($header.titleSize() > 0f){
            header.setTitleSize($header.titleSize());
        }
        if($header.headerSize() > 0f){
            header.setHeaderSize($header.headerSize());
        }
        if($header.columnSize() > 0f){
            header.setColumnSize($header.columnSize());
        }
        if( $header.autoFilter()){
            header.setAutoFilter(true);
        }
        header.setColumns(toColumns(clazz));
        return header;
    }

    private static Column[] toColumns(Class<?> clazz){
        List<Field> fields = getAnnotatedFields(clazz);
        int size = fields.size();
        if(size == 0){
            throw new IllegalArgumentException("class `%s` not found @com.github.buzzxu.shyexcel.annotation.Column".formatted(clazz.getSimpleName()));
        }
        Column[] columns = new Column[size];
        for(int i =0;i < size; i++){
            columns[i] = toColumn(fields.get(i));
        }
        return columns;
    }

    private static Column toColumn(Field field){
        Column column = new Column();
        com.github.buzzxu.shyexcel.annotation.Column $column = field.getAnnotation(com.github.buzzxu.shyexcel.annotation.Column.class);
        if(Strings.isNullOrEmpty($column.title())){
            throw new IllegalArgumentException("field `%s` title is null".formatted(field.getName()));
        }
        column.setName(field.getName());
        column.setTitle($column.title());
        column.setType($column.type());
        column.setFont(toFont($column.font()));
        if($column.width() >= 0f){
            column.setWidth($column.width());
        }
        if($column.merge()){
            column.setMerge(true);
        }
        if($column.collection()){
            column.setColumns(toColumns(findFieldType(field,0)));
            column.setMerge(null);
            column.setType(null);
        }
        return column;
    }
    private static Font toFont(com.github.buzzxu.shyexcel.annotation.Font $font){
        if(isDefaultValues($font)){
            return null;
        }
        Font font = new Font();
        if($font.bold()){
            font.setBold(true);
        }
        if($font.italic()){
            font.setItalic(true);
        }
        if(!Strings.isNullOrEmpty($font.underline())){
            font.setUnderline($font.underline());
        }
        if(!Strings.isNullOrEmpty($font.family())){
            font.setFamily($font.family());
        }
        if(!Strings.isNullOrEmpty($font.vertAlign())){
            font.setVertAlign($font.vertAlign());
        }
        if($font.size() > 0f){
            font.setSize($font.size());
        }
        if($font.strike()){
            font.setStrike(true);
        }
        if(!Strings.isNullOrEmpty($font.color())){
            font.setColor($font.color());
        }
        if($font.colorIndexed() > 0){
            font.setColorIndexed($font.colorIndexed());
        }
        if($font.colorTheme() > 0){
            font.setColorTheme($font.colorTheme());
        }
        if($font.colorTint() > 0f){
            font.setColorTint($font.colorTint());
        }
        return font;
    }


    protected void writeToResponse(String contentType,HttpServletResponse response, ByteArrayOutputStream baos) throws IOException {
        response.setContentType(contentType);
        response.setContentLength(baos.size());
        ServletOutputStream out = response.getOutputStream();
        baos.writeTo(out);
        out.flush();
    }
    private static byte[] toBytes(Table table, DataFormat format) throws ShyExcelException {
        try {
            return switch(format){
                case PROTOBUF:
                    throw new UnsupportedOperationException();
                case JSON:
                    yield JSON.toBytes(table);
                default:
                    yield MsgPack.serialize(table);
            };
        }catch (Exception ex){
            throw new ShyExcelException(ex);
        }
    }

}
