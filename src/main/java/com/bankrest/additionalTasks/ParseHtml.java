package com.bankrest.additionalTasks;


import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.swing.interop.SwingInterOpUtils;
import lombok.SneakyThrows;

import javax.json.*;
import javax.json.stream.JsonParser;
import java.io.StringReader;
import java.util.stream.Collectors;

public class ParseHtml {
    private static ObjectMapper mapper = new ObjectMapper();

    @SneakyThrows
    public static void main(String[] args) {
        ParentNode parentNode = new ParentNode("Ivan", "Ivanov",
                new ChildNode("petr","petrov"));
        String json = mapper.writeValueAsString(parentNode);
        System.out.println(json);
        JsonPatchBuilder builder = Json.createPatchBuilder();

        JsonReader jsonReader = Json.createReader(new StringReader(json));
        JsonObject object = jsonReader.readObject();
        jsonReader.close();
        JsonPatch jsonPatch = builder
                .add("/childNode/middle","Ivanovich")
//                .replace("/parent", "firstName:Gleb")
//                .replace("/parent", "lastName:Gleboff")
                .build();
        JsonObject newJsonObject = jsonPatch.apply(object);
        System.out.println(newJsonObject.toString());

    }


}
