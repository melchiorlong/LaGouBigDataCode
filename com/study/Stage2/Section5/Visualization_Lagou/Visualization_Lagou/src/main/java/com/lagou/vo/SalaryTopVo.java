package com.lagou.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Administrator
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaryTopVo {

    private String positionCity;
    private Double avgSalary;
}
