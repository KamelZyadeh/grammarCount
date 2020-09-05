package com.zyadeh.kamel.statics;

public class ConstantHolder {

    public static final String STRING_INSERT = "INSERT INTO text (txt) VALUES (?)";
    public static final String LAST_INSERT = "SELECT currval(pg_get_serial_sequence('%s','id'))";
}
