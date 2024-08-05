package cn.techoc.learnvalidationdemo.controller;

import cn.techoc.learnvalidationdemo.dto.Book;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
@Validated
public class BookController {
    @GetMapping("/test2")
    public String test2(
            @NotBlank(message = "name 不能为空")
            @Length(min = 2, max = 10, message = "name 长度必须在 {min} - {max} 之间")
            String name,
            @NotBlank(message = "author 不能为空")
            @Length(min = 2, max = 10, message = "author 长度必须在 {min} - {max} 之间")
            String author
    ) {
        return "success";
    }

    @GetMapping("/test3")
    public String test3(@Validated Book book) {
        return "success";
    }
}
