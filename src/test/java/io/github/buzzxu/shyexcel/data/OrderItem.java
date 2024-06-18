package io.github.buzzxu.shyexcel.data;


import io.github.buzzxu.shyexcel.annotation.ExcelCol;
import io.github.buzzxu.shyexcel.objects.DataType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author xux
 *  2023年10月16日 15:48:13
 */
@Builder
@Getter @Setter
public class OrderItem {
    @ExcelCol(title ="产品名称" ,type = DataType.STRING)
    private String productName;
    @ExcelCol(title = "单价",type = DataType.NUMERIC)
    private BigDecimal price;
    @ExcelCol(title = "数量",type = DataType.NUMERIC)
    private int number;
    @ExcelCol(title = "总金额",type = DataType.NUMERIC)
    private BigDecimal amount;
    @ExcelCol(title = "图片",type = DataType.HYPERLINK)
    private String image;
}
