package io.github.buzzxu.shyexcel.data;

import io.github.buzzxu.shyexcel.annotation.ExcelCol;
import io.github.buzzxu.shyexcel.annotation.Header;
import io.github.buzzxu.shyexcel.annotation.Sheet;
import io.github.buzzxu.shyexcel.objects.DataType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author xux
 *  2023年10月16日 15:47:59
 */
@Getter
@Setter @Builder
@Sheet(name = "订单",header = @Header(title = "订单列表"))
public class Order {
    @ExcelCol(title = "序号",type = DataType.INDEX)
    private Integer index;
    @ExcelCol(title = "订单编号",merge = true)
    private String orderNumber;
    @ExcelCol(title = "门店编号",merge = true)
    private String shopCode;
    @ExcelCol(title = "总金额",merge = true)
    private BigDecimal amount;
    @ExcelCol(title = "收货地址",merge = true)
    private String address;
    @ExcelCol(title = "订单明细",collection = true)
    private List<OrderItem> items;
}
