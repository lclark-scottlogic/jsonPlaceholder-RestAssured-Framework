package org.example.utilities;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class ResSpecBuilders {
  public static ResponseSpecification resOk(){
    return new ResponseSpecBuilder()
        .expectStatusCode(200)
        .expectContentType(ContentType.JSON).build();
  }
  public static ResponseSpecification resCreated(){
    return new ResponseSpecBuilder()
        .expectStatusCode(201)
        .expectContentType(ContentType.JSON).build();
  }
  public static ResponseSpecification resNotFound(){
    return new ResponseSpecBuilder()
        .expectStatusCode(404)
        .expectContentType(ContentType.JSON).build();
  }
}
