package com.github.ajg_iz;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println(isWeekday(DayOfWeek.MONDAY));
        System.out.println(isWeekday(DayOfWeek.SUNDAY));

    }

    public static String isWeekday(DayOfWeek dayOfWeek) {
        if (dayOfWeek.isWeekend()) {
            return "Weekend";
        } else  {
            return dayOfWeek.name();
        }
    }
}