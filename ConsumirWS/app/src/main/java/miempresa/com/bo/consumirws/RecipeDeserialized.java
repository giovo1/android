package miempresa.com.bo.consumirws;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.internal.Streams;

import java.lang.reflect.Type;

import miempresa.com.bo.consumirws.ConstantsRestApi;
import miempresa.com.bo.consumirws.RecipeResponse;

public class RecipeDeserialized implements JsonDeserializer<RecipeResponse> {
    private String searchRecipe;
    public RecipeDeserialized(String searchRecipe) {
        this.searchRecipe = searchRecipe;
    }

    @Override
    public RecipeResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String recetasContatenadas = "";
        System.out.println(new Gson().toJson(json.getAsJsonObject()));
        JsonObject jsonObject = json.getAsJsonObject();
        JsonArray listaRecetas = jsonObject.get(ConstantsRestApi.HINTS).getAsJsonArray() ;
        for (int i=0; i < listaRecetas.size(); i++ ){
            JsonObject recetas = listaRecetas.get(i).getAsJsonObject().get(ConstantsRestApi.FOOD).getAsJsonObject();
            String nombreReceta = recetas.get(ConstantsRestApi.LABEL).getAsString();
            recetasContatenadas = recetasContatenadas + "("+nombreReceta+")";
        }

        RecipeResponse resp = new RecipeResponse(jsonObject.get(ConstantsRestApi.SEARCH_TEXT).getAsString(),recetasContatenadas, jsonObject.get(ConstantsRestApi.NUMBER_PAGES).getAsInt());
        return resp;
    }
}

