package com.example.springboot.study.service.posts;

import com.example.springboot.study.domain.posts.PostsRepository;
import com.example.springboot.study.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/*
B003 study.service.posts.PostsService.java

PostsSaveRequestDto를 파라미터로 Controller로부터 수신한 Service는 DB에 저장(save())한다.
Controller와 마찬가지로 생성자를 통한 주입을 위해 @RequiredArgsContrutor를 맨 위에 사용한다.

Service 객체한테 저장하라 save()라는 명령을 수행하는
Controller 코드를 수정하러 가야한다.
    PostsApiController.java 로 가서 코드 수정
 */
@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto)
    {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
