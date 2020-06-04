package com.dsl.tests;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.dsl.dbProxy.db.DynamoDBProxy;
import com.dsl.dbProxy.entity.Employee;
import com.google.gson.Gson;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamoDBTest {

    public DynamoDBProxy dynamoDBProxy;

    @Test
    public void validateInsertEmployee() {

        //Test data
        Number employeeId = 1;
        String name = "Javeeth";

        dynamoDBProxy = new DynamoDBProxy();
        dynamoDBProxy.insertEmployee(employeeId, name);

        Item item = dynamoDBProxy.getEmployee(employeeId, name);

        Employee employee = new Gson().fromJson(item.toJSON(), Employee.class);

        Assert.assertEquals(employee.Employee_ID, employeeId);
        Assert.assertEquals(employee.Name, name);

    }

    @Test
    public void validateAccessToProdDB() {

        //Test data
        Number employeeId = 1;
        String name = "Javeeth";

        dynamoDBProxy = new DynamoDBProxy();
        dynamoDBProxy.insertEmployee(employeeId, name);

        Item item = dynamoDBProxy.getEmployee(employeeId, name);

        Employee employee = new Gson().fromJson(item.toJSON(), Employee.class);

        Assert.assertEquals(employee.Employee_ID, employeeId);
        Assert.assertEquals(employee.Name, name);

    }
}
