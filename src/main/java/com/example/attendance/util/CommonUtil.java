package com.example.attendance.util;

import java.math.BigDecimal;

/**
 * 系统的公共方法
 *
 * @author
 */
public class CommonUtil {

    /**
     * 比较输入的字符串1和字符串2是否相等
     *
     * @param str1 ：字符串1
     * @param str2 ：字符串2
     * @return 相等：true，不相等：false
     */
    public static boolean equals(String str1, String str2) {
        if (str1 == str2) {
            return true;
        }
        // null 和 空串在系统中认为相等
        str1 = (str1 == null ? "" : str1.trim());
        str2 = (str2 == null ? "" : str2.trim());
        return str1.equals(str2);
    }

    /**
     * 比较输入的数值1和数值2是否相等
     *
     * @param num1
     * @param num2
     * @return 相等：true，不相等：false
     */
    public static boolean equals(BigDecimal num1, BigDecimal num2) {
        // null和0.00认为相等
        num1 = (num1 == null ? BigDecimal.ZERO : num1);
        num2 = (num2 == null ? BigDecimal.ZERO : num2);
        return num1.compareTo(num2) == 0;
    }
}
