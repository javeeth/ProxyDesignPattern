package com.dsl.dbProxy.db;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;
import com.amazonaws.services.dynamodbv2.model.ReturnValue;
import com.dsl.dbProxy.abstraction.DBInterface;

public class DynamoDBUtil implements DBInterface {

    AmazonDynamoDB client;
    DynamoDB dynamoDB;
    Table table;

    public DynamoDBUtil(){
        setup();
    }

    public void setup(){
        client = AmazonDynamoDBClientBuilder.standard().build();
        dynamoDB = new DynamoDB(client);
        table = dynamoDB.getTable("Employee");
    }

    @Override
    public void insertEmployee(Number employeeId, String name) {
        Item item = new Item().withPrimaryKey("Employee_ID", employeeId, "Name", name);
        PutItemOutcome putItemOutcome = table.putItem(item);
    }

    public void deleteEmployee(Number employeeId, String name) {
        DeleteItemSpec deleteItemSpec = new DeleteItemSpec().withPrimaryKey("Employee_ID", employeeId,
                "Name",name)
                .withReturnValues(ReturnValue.ALL_OLD);

        DeleteItemOutcome outcome = table.deleteItem(deleteItemSpec);
    }

    public Item getEmployee(Number employeeId, String name) {
        Item item = table.getItem("Employee_ID", employeeId,"Name", name);
        return item;
    }
}
