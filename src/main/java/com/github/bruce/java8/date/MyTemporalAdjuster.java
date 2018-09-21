package com.github.bruce.java8.date;

/**
 * 设计一个NextWorkingDay类，该类实现了TemporalAdjuster接口，能够计算明天
 * 的日期，同时过滤掉周六和周日这些节假日。格式如下所示：
 * date = date.with(new NextWorkingDay());
 * 如果当天的星期介于周一至周五之间，日期向后移动一天；如果当天是周六或者周日，则
 * 返回下一个周一。
 */
public class MyTemporalAdjuster {

}
