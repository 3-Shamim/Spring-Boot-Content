package com.learningstuff.jasperreportswithspringboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * User: Md. Shamim
 * Date: ১৯/৯/১৯
 * Time: ৮:৪৮ PM
 * Mail: mdshamim723@gmail.com
 * To change this template use File | Settings | File and Code Templates.
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {

    private long id;
    private String name;
    private String address;
    private double salary;

}
