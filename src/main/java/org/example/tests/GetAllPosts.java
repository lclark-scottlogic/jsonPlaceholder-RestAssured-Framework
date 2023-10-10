package org.example.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.restassured.path.json.JsonPath;
import org.example.pojo.Post;
import org.example.pojo.PostList;
import org.example.utilities.GetDetails;
import org.example.utilities.ReqSpecBuilders;
import org.example.utilities.ResSpecBuilders;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetAllPosts {

  @Test
  @Description("Get All Posts")
  @Feature("Get Posts")
  public void getAllPosts() {
//    Get all Posts
    String getAllPosts = ReqSpecBuilders.getAllPostReq()
        .when().get("/posts")
        .then().spec(ResSpecBuilders.resOk()).extract().response().asString();
//    Check the array is correct via assertions
    JsonPath js=new JsonPath(getAllPosts);
    Assert.assertEquals(js.get("[0].title"),"sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
    Assert.assertEquals(js.get("[99].title"),"at nam consequatur ea labore ea harum");
//    Check the values of a few random objects in the json
    Assert.assertEquals((Integer) js.get("[78].id"),79);
    Assert.assertEquals((Integer) js.get("[78].userId"), GetDetails.getUserIdFromPostId(79));
    Assert.assertEquals(js.get("[26].body"),"eum sed dolores ipsam sint possimus debitis occaecati\ndebitis qui qui et\nut placeat enim earum aut odit facilis\nconsequatur suscipit necessitatibus rerum sed inventore temporibus consequatur");

  }
}

