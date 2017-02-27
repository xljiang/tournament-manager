package com.instinctcoder.sqlitedb;

/**
 * Created by IT001 on 23-Jun-16.
 */
public class Student {
    // Labels table name
    public static final String TABLE = "Student";

    // Labels Table Columns names
    public static final String KEY_ID = "id";
    public static final String KEY_name = "name";
    public static final String KEY_username = "username";
    public static final String KEY_phone = "phone";

    // property help us to keep data
    public int student_ID;
    public String name;
    public String username;
    public String phone;
}