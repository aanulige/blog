package org.myblog.blog.services;

import org.myblog.blog.models.Post;
import org.myblog.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Optional<Post> getById(Long Id){
        return postRepository.findById(Id);
    }

    public List<Post> getAll(){
        return postRepository.findAll();
    }

    public Post save(Post post){
        if(post.getId() == null) {
            post.setCreatedAt(LocalDate.now());
        }
        return  postRepository.save(post);
    }
}
