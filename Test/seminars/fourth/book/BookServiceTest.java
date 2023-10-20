package seminars.fourth.book;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class BookServiceTest {
    @Test
    void findBookByIdTest(){
        BookRepository bookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);
//        InMemoryBookRepository inMemoryBookRepository=new InMemoryBookRepository();
        Book book = new Book("1","Test Book","Test Author");
        when(bookRepository.findById("1")).thenReturn(book);
        Book result = bookService.findBookById("1");
        assertEquals(book,result);
        verify(bookRepository,times(1)).findById("1");
    }
    @Test
    void findAllBooksTest(){
        BookRepository bookRepository = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);
        List<Book> books=new ArrayList<>();
        when(bookRepository.findAll()).thenReturn((List<Book>) books);
        List<Book> result = bookService.findAllBooks();
        assertEquals((List<Book>) books,result);
        verify(bookRepository,times(1)).findAll();
    }
    @Test
    void bookGetIdTest(){
        Book book = mock(Book.class);
        when(book.getId()).thenReturn("test");
                assertEquals(book.getId(), "test");
    }
    @Test
    void bookGetTitleTest(){
        Book book = mock(Book.class);
        when(book.getTitle()).thenReturn("test");
        assertEquals(book.getTitle(), "test");
    }
    @Test
    void bookGetAuthorTest(){
        Book book = mock(Book.class);
        when(book.getAuthor()).thenReturn("test");
        assertEquals(book.getAuthor(), "test");
    }
    @Test
    void bookSetIdTest(){
        Book book = new Book("1","test","test");
        book.setId("test");
        assertEquals(book.getId(), "test");
    }
    @Test
    void bookSetTitleTest(){
        Book book = new Book("1","Book1","test");
        book.setTitle("test");
        assertEquals(book.getTitle(), "test");
    }
    @Test
    void bookSetAuthorTest(){
        Book book = new Book("1","Book1","Author");
                book.setAuthor("test");
        assertEquals(book.getAuthor(), "test");
    }
    @Test
    void bookSetAuthorTestMock(){
        Book book = mock(Book.class);
        book.setAuthor("test");
        assertEquals(book.getAuthor(), "test");
    }
}