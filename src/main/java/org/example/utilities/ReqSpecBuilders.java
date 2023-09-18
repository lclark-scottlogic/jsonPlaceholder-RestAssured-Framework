package org.example.utilities;

import static io.restassured.RestAssured.given;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.example.pojo.Post;

public class ReqSpecBuilders {

  public static RequestSpecification baseReq() {
    return new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com")
        .setContentType(ContentType.JSON).build();
  }
  public static RequestSpecification createPostReq(Post post){
    return given().spec(baseReq()).body(post);
  }
  public static RequestSpecification getPostReq(int id){
    return given().spec(baseReq()).pathParam("id",id);
  }
  public static RequestSpecification getAllPostReq(){
    return given().spec(baseReq());
  }
  public static RequestSpecification deletePostReq(int id){
    return given().spec(baseReq()).pathParam("id",id);
  }
  public static RequestSpecification getPostByUserReq(int id){
    return given().spec(baseReq()).queryParam("userId",id);
  }
  public static RequestSpecification patchPostReq(String Json,int id){
    return given().spec(baseReq()).body(Json).pathParam("id",id);
  }

}
