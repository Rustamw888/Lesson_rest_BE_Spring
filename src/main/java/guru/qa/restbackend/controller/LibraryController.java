package guru.qa.restbackend.controller;

import guru.qa.restbackend.domain.UserInfo;
import guru.qa.restbackend.exception.InvalidAuthornameException;
import guru.qa.restbackend.library.LibraRequest;
import guru.qa.restbackend.library.LibraResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

@RestController
public class LibraryController {

//    public List<String> authorMark = asList("Book_1", "Book_2");
//    public List<String> authorVasiliy = asList("Book_3", "Book_4", "Book_5");
//    public List<String> authorDima= asList("Book_6", "Book_7");
//    public List<String> authorRustam = asList("Book_8", "Book_9", "Book_5");
//
//    private Map<LibraRequest, LibraResponse> authors = Map.of(
//            LibraRequest.builder().authorName("Mark").build(), LibraResponse.builder().booksNames(authorMark).build(),
//            LibraRequest.builder().authorName("Vasiliy").build(), LibraResponse.builder().booksNames(authorVasiliy).build(),
//            LibraRequest.builder().authorName("Dima").build(), LibraResponse.builder().booksNames(authorDima).build(),
//            LibraRequest.builder().authorName("Rustam").build(), LibraResponse.builder().booksNames(authorRustam).build()
//    );

    private Map<String, LibraRequest> authors = Map.of(
            "Mark", LibraRequest.builder().authorName("Mark").build(),
            "Vasiliy", LibraRequest.builder().authorName("Vasiliy").build(),
            "Dima", LibraRequest.builder().authorName("Dima").build(),
            "Rustam", LibraRequest.builder().authorName("Rustam").build()
    );

    @PostMapping("author/adding")
    @ApiOperation("добавление автора")
    public LibraRequest authorAdding(@RequestBody LibraRequest author, LibraRequest books) {
        if (author.getAuthorName().equals("Rustam")) {
            return LibraRequest.builder()
                    .authorName(author.getAuthorName())
                    .bookName(books.getBookName())
                    .build();
        } else {
            throw new InvalidAuthornameException();
        }
    }

    @GetMapping("author/getBookList")
    @ApiOperation("Найти книгу по автору")
    public List<LibraRequest> getBooksInfo() {
        return authors.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}
