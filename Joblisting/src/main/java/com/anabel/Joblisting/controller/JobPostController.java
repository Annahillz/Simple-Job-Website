package com.anabel.Joblisting.controller;

import com.anabel.Joblisting.repository.CustomizeSearchRepositoryMethod;
import com.anabel.Joblisting.repository.JobPostRepository;
import com.anabel.Joblisting.model.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobPostController {


    @Autowired
    JobPostRepository repo;

    @Autowired
    CustomizeSearchRepositoryMethod SearchRepo;

    @ApiIgnore
    @RequestMapping(value ="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/allPosts")
    @CrossOrigin
    public List<JobPost> getAllPosts()
    {
        return repo.findAll();
    }

    //posts/java simply replaces text with java or any word user enters
    @GetMapping("/posts/{text}")
    @CrossOrigin
    public List<JobPost> search(@PathVariable String text)
    {
        return SearchRepo.FindByText(text);
    }

    @PostMapping("/post")
    @CrossOrigin
    public JobPost addPost(@RequestBody JobPost post)
    {
        return repo.save(post);
    }
}
