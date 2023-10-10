package org.example.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.example.pojo.Post;
import org.example.utilities.GetDetails;
import org.example.utilities.ReqSpecBuilders;
import org.example.utilities.ResSpecBuilders;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PatchPosts {
  @Test
  @Description("Update only a Post's title")
  @Feature("Patch Post")
  public void updatePostTitle() {
//    Change only title
    Post patchPostTitle = ReqSpecBuilders.patchPostReq("{\n"
            + "  \"title\":\"New Title\"\n"
            + "}",1)
        .when().patch("posts/{id}")
        .then().spec(ResSpecBuilders.resOk()).extract().response().as(Post.class);
    //Assert title has changed
    Assert.assertEquals(patchPostTitle.getTitle(), "New Title");
//    Assert other fields remain as before
    Assert.assertEquals(patchPostTitle.getBody(), "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto");
    Assert.assertEquals(patchPostTitle.getUserId(), GetDetails.getUserIdFromPostId(1));
    Assert.assertEquals(patchPostTitle.getId(), 1);
  }
  @Test
  @Description("Update only a Post's body")
  @Feature("Patch Post")
  public void updatePostBody() {
//    Change only title
    Post patchPostBody = ReqSpecBuilders.patchPostReq("{\n"
            + "  \"body\":\"My New Body\"\n"
            + "}",2)
        .when().patch("posts/{id}")
        .then().spec(ResSpecBuilders.resOk()).extract().response().as(Post.class);
    //Assert body has changed
    Assert.assertEquals(patchPostBody.getBody(), "My New Body");
//    Assert other fields remain as before
    Assert.assertEquals(patchPostBody.getTitle(), "qui est esse");
    Assert.assertEquals(patchPostBody.getUserId(), GetDetails.getUserIdFromPostId(2));
    Assert.assertEquals(patchPostBody.getId(), 2);
  }
  @Test
  @Description("Update only a Post's UserId")
  @Feature("Patch Post")
  public void updatePostUserId() {
//    Change only title
    Post patchPostBody = ReqSpecBuilders.patchPostReq("{\n"
            + "  \"userId\":\"2000\"\n"
            + "}",3)
        .when().patch("posts/{id}")
        .then().spec(ResSpecBuilders.resOk()).extract().response().as(Post.class);
    //Assert userId has changed
    Assert.assertEquals(patchPostBody.getUserId(), 2000);
//    Assert other fields remain as before
    Assert.assertEquals(patchPostBody.getTitle(), "ea molestias quasi exercitationem repellat qui ipsa sit aut");
    Assert.assertEquals(patchPostBody.getBody(), "et iusto sed quo iure\nvoluptatem occaecati omnis eligendi aut ad\nvoluptatem doloribus vel accusantium quis pariatur\nmolestiae porro eius odio et labore et velit aut");
    Assert.assertEquals(patchPostBody.getId(), 3);
  }
  @Test
  @Description("Update only a Post's Id")
  @Feature("Patch Post")
  public void updatePostId() {
//    Change only title
    Post patchPostBody = ReqSpecBuilders.patchPostReq("{\n"
            + "  \"id\":\"77\"\n"
            + "}",4)
        .when().patch("posts/{id}")
        .then().spec(ResSpecBuilders.resOk()).extract().response().as(Post.class);
    //Assert userId has changed
    Assert.assertEquals(patchPostBody.getId(), 77);
//    Assert other fields remain as before
    Assert.assertEquals(patchPostBody.getTitle(), "eum et est occaecati");
    Assert.assertEquals(patchPostBody.getBody(), "ullam et saepe reiciendis voluptatem adipisci\nsit amet autem assumenda provident rerum culpa\nquis hic commodi nesciunt rem tenetur doloremque ipsam iure\nquis sunt voluptatem rerum illo velit");
    Assert.assertEquals(patchPostBody.getUserId(), GetDetails.getUserIdFromPostId(4));
  }
}
