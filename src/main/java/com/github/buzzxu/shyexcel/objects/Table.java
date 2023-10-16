package com.github.buzzxu.shyexcel.objects;

import lombok.*;

import java.util.List;

/**
 * @author xux
 * @date 2023年10月16日 11:06:18
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Table {
    private List<Sheet> sheets;
}
