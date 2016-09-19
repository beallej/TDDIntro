package com.thoughtworks.tddintro.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Matchers.endsWith;
import static org.mockito.Mockito.*;

public class LibraryTest {


    /*

        List books tests. Implement the first three tests for the Verify exercise

     */

    List<String> books;
    PrintStream printStream;
    DateTimeFormatter dateTimeFormatter;
    Library library;


    @Before
    public void setUp() {
        books = new ArrayList<>();
        dateTimeFormatter = mock(DateTimeFormatter.class);
        printStream = mock(PrintStream.class);
        library = new Library(books, printStream, dateTimeFormatter);

    }

    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {

        String title = "Book Title";
        books.add(title);
        library = new Library(books, printStream, dateTimeFormatter);
        library.listBooks();
        verify(printStream).println("Book Title");
        // add a verify statement here that shows that the book title was printed by to the printStream
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {

        library.listBooks();
        verifyZeroInteractions(printStream);
        // implement me
    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() throws IOException {
        String title = "Book Title";
        String secondTitle = "Second Title";
        books.add(title);
        books.add(secondTitle);
        library = new Library(books, printStream, dateTimeFormatter);
        library.listBooks();
        verify(printStream).println(contains(title));
        verify(printStream).println(contains(secondTitle));

        // implement me
    }

    /*

        Welcome message tests. Implement these tests for the when/thenReturn exercise

     */

    
    // This one is done for you
    @Test
    public void shouldWelcomeUser() {

        // We don't need to mock DateTime because it is a value object
        // We can't mock it because it is a final class
        DateTime time = new DateTime();
        library.welcome(time);
        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsAnEmptyString() {
        DateTime time = new DateTime();
        when(dateTimeFormatter.print(time)).thenReturn("");
        library.welcome(time);
        verify(printStream).println(endsWith("is "));
        // add a verify here
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsNotEmpty() {

        DateTime time = new DateTime();
        when(dateTimeFormatter.print(time)).thenReturn("2013-04-08 16:33:17");
        library.welcome(time);
        verify(printStream).println(contains("2013-04-08 16:33:17"));

        // implement me
        // then move common test variables into a setup method
    }
}
