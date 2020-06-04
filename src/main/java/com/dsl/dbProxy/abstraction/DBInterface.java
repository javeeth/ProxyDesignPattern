package com.dsl.dbProxy.abstraction;

import com.amazonaws.services.dynamodbv2.document.Item;

public interface DBInterface {
    void insertEmployee(Number employeeId, String name);
    Item getEmployee(Number employeeId, String name);
}