package miempresa.com.bo.testretrofit;

public class ConstantsRestApi {
    public static final String VERSION = "/api/";
    public static final String URL = "https://openlibrary.org";
    public static final String URL_BASE =  URL+VERSION;
    public static final String URL_BOOK = "books?jscmd=data&format=json&bibkeys=ISBN:";

    public static final String BOOK_TITLE = "title";
    public static final String BOOK_AUTHOR = "authors";
    public static final String BOOK_DATE = "publish_date";
    public static final String BOOK_PAGES = "number_of_pages";
}

