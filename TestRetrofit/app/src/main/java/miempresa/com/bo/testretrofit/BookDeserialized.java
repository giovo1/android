package miempresa.com.bo.testretrofit;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by robertocarloscallisaya on 10/10/17.
 */

public class BookDeserialized implements JsonDeserializer<BookResponse> {
    private String isbn;
    public BookDeserialized(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public BookResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        System.out.println(new Gson().toJson(json.getAsJsonObject()));
        JsonObject jsonObject = json.getAsJsonObject().get("ISBN:"+this.isbn).getAsJsonObject();
        JsonArray listaAutor = jsonObject.get(ConstantsRestApi.BOOK_AUTHOR).getAsJsonArray() ;
        BookResponse resp = new BookResponse(this.isbn,jsonObject.get(ConstantsRestApi.BOOK_TITLE).getAsString() , listaAutor.get(0).getAsJsonObject().get("name").getAsString() ,jsonObject.get(ConstantsRestApi.BOOK_DATE).getAsString(), jsonObject.get(ConstantsRestApi.BOOK_PAGES).getAsInt());
        return resp;
    }
}
