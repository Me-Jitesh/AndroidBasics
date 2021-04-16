package com.androidbasics.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MyWebService {
    String BASE_URL = "https://jsonplaceholder.typicode.com/";        //  Absolute url
    String FEED = "posts";        //   Relative url

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    //    DAO (Data Access Object)
    @GET(FEED)
    Call<List<Post>> getPost();

    //    URL Manipulation with Retrofit, @Path, @Query, @QueryMap, @Url
    //    Dynamic URL
//    @GET("posts/{id}/comments")
//    Call<List<Comment>> getComments(@Path("id") int userId);

    //    URL Manipulation with Retrofit, @Path, @Query, @QueryMap, @Url
    //    Query Parameter
//    @GET("comments?postId=1")
    @GET("comments")
//    Call<List<Comment>> getComments(@Query("postId") int postId);         // Single Query

    Call<List<Comment>> getComments(@Query("postId") int postid,           // Multiple Query
                                    @Query("_sort") String sortBy,
                                    @Query("_order") String orderBy
    );

}
