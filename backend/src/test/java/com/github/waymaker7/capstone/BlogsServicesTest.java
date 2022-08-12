package com.github.waymaker7.capstone;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static com.mongodb.assertions.Assertions.fail;

public class BlogsServicesTest {



@Test
    void souldCreatePost() {
    BlogsRepository testRepos = Mockito.mock(BlogsRepository.class);

    BlogsServices testServices = new BlogsServices(testRepos);

    Blogs testBlogs = new Blogs("testAuthor", "testContent");
    //testServices.createPost(testBlogs, "userId");
    testServices.createPost(testBlogs);
    Mockito.verify(testRepos).save(testBlogs);
}

    @Test
    void shouldFindAll(){
    BlogsRepository testRepo = Mockito.mock(BlogsRepository.class);

    BlogsServices blogsService = new BlogsServices(testRepo);
    Blogs blogs1 = new Blogs("autor1", "content1");
        Blogs blogs2 = new Blogs("autor2", "content2");
    Mockito.when(testRepo.findAll()).thenReturn(List.of(blogs1,blogs2));
    blogsService.findAll();
   Mockito.verify(testRepo).findAll();
    Assertions.assertThat(blogsService.findAll()).contains(blogs1, blogs2);
    Assertions.assertThat(blogsService.findAll()).hasSize(2);

    }

    @Test
    void shouldEditPost() {

        Blogs blogs = new Blogs("a3", "c3");
        BlogsRepository testRepo = Mockito.mock(BlogsRepository.class);
        BlogsServices blogsServices = new BlogsServices(testRepo);
        blogsServices.editPost(blogs, "a3");
        Mockito.verify(testRepo).save(blogs);
        try {
            blogsServices.editPost(blogs, "a7");
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    void shouldDeletePost(){

        BlogsRepository testRepo = Mockito.mock(BlogsRepository.class);
        BlogsServices blogsServices = new BlogsServices(testRepo);

        blogsServices.deletePost("321", "akk");

        Mockito.verify(testRepo).deleteByIdAndAuthor("321", "akk");


    }

}
