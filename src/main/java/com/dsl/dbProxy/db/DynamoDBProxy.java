package com.dsl.dbProxy.db;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.dsl.dbProxy.abstraction.DBUtil;
import com.dsl.dbProxy.property.SystemProperties;

public class DynamoDBProxy implements DBUtil {

    private DBUtil dynamoDBUtil;
    private static final String restrictEnvironment = "PROD";


    @Override
    public void insertEmployee(Number employeeId, String name) {
        if(SystemProperties.ENV != restrictEnvironment &&  hasAccess()) {
            if(dynamoDBUtil == null)
                dynamoDBUtil = new DynamoDBUtil();
            dynamoDBUtil.insertEmployee(employeeId, name);
        }
    }

    @Override
    public Item getEmployee(Number employeeId, String name) {
        return dynamoDBUtil.getEmployee(employeeId, name);
    }

    private boolean hasAccess(){
        return true;
    }
}
