package com.anabel.Joblisting.repository;

import com.anabel.Joblisting.model.JobPost;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobPostRepository extends MongoRepository<JobPost, String>
{
}
