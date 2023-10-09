package org.example.tests;

import io.qameta.allure.Description;
import org.example.pojo.Post;
import org.example.utilities.GetDetails;
import org.example.utilities.ReqSpecBuilders;
import org.example.utilities.ResSpecBuilders;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetPostsById {
    @Test
    @Description("Get first Post in the list")
        public void getPost1() {
      //Get Talk with Id=1
      Post getFirstPost = ReqSpecBuilders.getPostReq(1)
          .when().get("/posts/{id}")
          .then().spec(ResSpecBuilders.resOk()).extract().response().as(Post.class);
//    Make Assertions on response fields
      Assert.assertEquals(getFirstPost.getUserId(), GetDetails.getUserIdFromPostId(1));
      Assert.assertEquals(getFirstPost.getId(), 1);
      Assert.assertEquals(getFirstPost.getTitle(),
          "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
      Assert.assertEquals(getFirstPost.getBody(),
          "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto");
    }
  @Test
  @Description("Get last Post in the list")
  public void getPost100() {
    //Get Talk with Id=100
    Post getLastPost = ReqSpecBuilders.getPostReq(100)
        .when().get("/posts/{id}")
        .then().spec(ResSpecBuilders.resOk()).extract().response().as(Post.class);
//    Make Assertions on response fields
    Assert.assertEquals(getLastPost.getUserId(), GetDetails.getUserIdFromPostId(100));
    Assert.assertEquals(getLastPost.getId(), 100);
    Assert.assertEquals(getLastPost.getTitle(), "at nam consequatur ea labore ea harum");
    Assert.assertEquals(getLastPost.getBody(),
        "cupiditate quo est a modi nesciunt soluta\nipsa voluptas error itaque dicta in\nautem qui minus magnam et distinctio eum\naccusamus ratione error aut");
  }
    @Test
    @Description("Get Post with Id that is larger than the last in the list")
    public void getPost101 () {
      String getInvalidPost = ReqSpecBuilders.getPostReq(101)
          .when().get("/posts/{id}")
          .then().spec(ResSpecBuilders.resNotFound()).extract().response().asString();
    }
  @Test
  @Description("Get Post with Id that is less than the first in the list")
  public void getPost0() {
    //Get Talk with Id=0
    String getZeroPost = ReqSpecBuilders.getPostReq(0)
        .when().get("/posts/{id}")
        .then().spec(ResSpecBuilders.resNotFound()).extract().response().asString();
  }
}

