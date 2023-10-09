package org.example.tests;

import io.qameta.allure.Description;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Arrays;
import org.example.pojo.Post;
import org.example.pojo.PostList;
import org.example.utilities.ReqSpecBuilders;
import org.example.utilities.ResSpecBuilders;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetPostsByUser {
  @Test
  @Description("Getting a User's Posts")

  public void getUserOnePosts(){
    Post[] userOnePosts= ReqSpecBuilders.getPostByUserReq(1)
        .when().get("/posts")
        .then().spec(ResSpecBuilders.resOk()).extract().response().as(Post[].class);
//    Assert length of array is correct
    Assert.assertEquals(userOnePosts.length,10);
//    Check user ID is 1 for all users
    for(Post post:userOnePosts) {
      Assert.assertEquals(post.getUserId(), 1);
    }
//    Check fields are correct for a post
    Assert.assertEquals(userOnePosts[4].getId(),5);
    Assert.assertEquals(userOnePosts[4].getBody(),"repudiandae veniam quaerat sunt sed\nalias aut fugiat sit autem sed est\nvoluptatem omnis possimus esse voluptatibus quis\nest aut tenetur dolor neque");
    Assert.assertEquals(userOnePosts[4].getTitle(),"nesciunt quas odio");
  }
  @Test
  @Description("Getting an invalid User's Posts gives an empty array when id is 0")
  public void getZeroUserPosts(){
    Post[] userOnePosts= ReqSpecBuilders.getPostByUserReq(0)
        .when().get("/posts")
        .then().spec(ResSpecBuilders.resOk()).extract().response().as(Post[].class);
//    Assert array is empty
    Assert.assertEquals(userOnePosts.length,0);
  }
  @Test
  @Description("Getting an invalid User's Posts gives an empty array when id is 101")
  public void getInvalidUserPosts(){
    Post[] userOnePosts= ReqSpecBuilders.getPostByUserReq(101)
        .when().get("/posts")
        .then().spec(ResSpecBuilders.resOk()).extract().response().as(Post[].class);
//    Assert array is empty
    Assert.assertEquals(userOnePosts.length,0);
  }
}
