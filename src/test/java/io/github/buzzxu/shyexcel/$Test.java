package io.github.buzzxu.shyexcel;

import io.github.buzzxu.shyexcel.data.Order;
import io.github.buzzxu.shyexcel.data.OrderItem;
import io.github.buzzxu.shyexcel.exceptions.ShyExcelException;
import io.github.buzzxu.shyexcel.objects.DataFormat;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author xux
 *  2023年10月16日 15:47:09
 */
public class $Test {

    private static List<Order>  orders;

    @BeforeAll
    private static void before(){

        orders = List.of(
                Order.builder()
                        .orderNumber("HBP1574450552111139")
                        .shopCode("924562")
                        .amount(new BigDecimal("138"))
                        .address("河北省廊坊市文安县兴文道与永定路交叉口")
                        .items(List.of(
                                OrderItem.builder().productName("一套福袋包").amount(new BigDecimal("138")).price(new BigDecimal("138")).number(1).image("https://mxbc-haibao-obs.obs.cn-east-2.myhuaweicloud.com/product/sku/202310/c5b7017d26be47d5b16ff0d5448995b8.jpg").build()
                                ,OrderItem.builder().productName("红色通用版").amount(new BigDecimal("16")).price(new BigDecimal("16")).number(1).image("https://mxbc-haibao-obs.obs.cn-east-2.myhuaweicloud.com/product/sku/202309/5a220f651d66411abd855aea1c515a2a.jpg").build()

                        ))
                        .build()
                ,
                Order.builder()
                        .orderNumber("HB1574454253584420")
                        .shopCode("921267")
                        .amount(new BigDecimal("20.34"))
                        .address("贵州省安顺市西王山建材市场2栋一楼5号")
                        .items(List.of(
                                OrderItem.builder().productName("西南保温桶贴").amount(new BigDecimal("11")).price(new BigDecimal("11")).number(1).image("https://mxbc-haibao-obs.obs.cn-east-2.myhuaweicloud.com/product/sku/202310/6e8e86141b93423ea4bc1abfd7085b5b.jpg").build()
                                ,OrderItem.builder().productName("仪容仪表").amount(new BigDecimal("3.1")).price(new BigDecimal("3.1")).number(1).image("https://mxbc-haibao-obs.obs.cn-east-2.myhuaweicloud.com/product/sku/202305/d2d1f3debe834a08b1815624493f9cf7.png").build()
                                ,OrderItem.builder().productName("红色通用版").amount(new BigDecimal("16")).price(new BigDecimal("16")).number(1).image("https://mxbc-haibao-obs.obs.cn-east-2.myhuaweicloud.com/product/sku/202309/5a220f651d66411abd855aea1c515a2a.jpg").build()
                        ))
                        .build()
        );
    }


    @Test
    public void toFile() throws ShyExcelException {
        $.toFile("test1.json",orders,Order.class, DataFormat.JSON);
    }
}
