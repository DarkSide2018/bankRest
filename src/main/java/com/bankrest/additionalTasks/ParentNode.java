package com.bankrest.additionalTasks;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ParentNode {
    private String firstName;
    private String lastName;
    private ChildNode childNode;

}
