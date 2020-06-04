package com.dsl.dbProxy.db;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.dsl.dbProxy.abstraction.DBInterface;
import com.dsl.dbProxy.exception.InvalidEnvException;
import com.dsl.dbProxy.property.SystemProperties;

public class DynamoDBProxy implements DBInterface {

    private DBInterface dbInterface;
    private static final String restrictEnvironment = "PROD";


    @Override
    public void insertEmployee(Number employeeId, String name) {
        if((!SystemProperties.ENV.equals(restrictEnvironment)) &&  hasAccess()) {
            if(dbInterface == null)
                dbInterface = new DynamoDBUtil();
            dbInterface.insertEmployee(employeeId, name);
        }
        else
            throw new InvalidEnvException(SystemProperties.ENV);
    }

    @Override
    public Item getEmployee(Number employeeId, String name) {

        if((!SystemProperties.ENV.equals(restrictEnvironment)) &&  hasAccess()) {
            if (dbInterface == null)
                dbInterface = new DynamoDBUtil();

            return dbInterface.getEmployee(employeeId, name);
        }
        return null;
    }

    private boolean hasAccess(){
        return true;
    }
}
