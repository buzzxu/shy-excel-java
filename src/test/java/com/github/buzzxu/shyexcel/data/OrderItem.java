package com.github.buzzxu.shyexcel.data;

import com.github.buzzxu.shyexcel.annotation.Column;
import com.github.buzzxu.shyexcel.annotation.Header;
import com.github.buzzxu.shyexcel.annotation.Sheet;
import com.github.buzzxu.shyexcel.objects.DataType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author xux
 * @date 2023年10月16日 15:48:13
 */
@Builder
@Getter @Setter
public class OrderItem {
    @Column(title ="产品名称" ,type = DataType.STRING)
    private String productName;
    @Column(title = "单价",type = DataType.NUMERIC)
    private BigDecimal price;
    @Column(title = "数量",type = DataType.NUMERIC)
    private int number;
    @Column(title = "总金额",type = DataType.NUMERIC)
    private BigDecimal amount;
    @Column(title = "图片",type = DataType.HYPERLINK)
    private String image;
}
