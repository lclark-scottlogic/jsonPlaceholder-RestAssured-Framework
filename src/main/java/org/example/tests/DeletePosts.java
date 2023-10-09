package org.example.tests;

import io.qameta.allure.Description;
import org.example.utilities.ReqSpecBuilders;
import org.example.utilities.ResSpecBuilders;
import org.testng.annotations.Test;

public class DeletePosts {
  @Test
  @Description("Delete a Post")
  public void deletePost(){
    ReqSpecBuilders.deletePostReq(1)
        .when().delete("/posts/{id}")
        .then().spec(ResSpecBuilders.resOk());
  }
}
