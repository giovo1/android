package miempresa.com.bo.nytimesapp;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by HP on 16/10/2017.
 */

public class NewsDeserialized implements JsonDeserializer<NewsResponse> {
    private String query;
    public NewsDeserialized(String query) {
        this.query = query;
    }

    @Override
    public NewsResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String id;
        String headline;
        String snippet;
        String source;
        String pub_date;
        String web_url;
        String word_count;
        String url_image_xlarge;
        String url_image_wide;
        String url_image_thumbnail;
        JsonObject news;
        List<NewsItem> newsItems;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZ");
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        //System.out.println(new Gson().toJson(json.getAsJsonObject()));
        JsonObject jsonObject_full = json.getAsJsonObject();
        JsonObject jsonObject = jsonObject_full.get(ConstantsRestApi.NEWS_RESPONSE).getAsJsonObject();
        JsonArray newsArray = jsonObject.get(ConstantsRestApi.NEWS_DOCS).getAsJsonArray();
        JsonArray multimediaList;

        newsItems = new ArrayList();
        JsonObject image;

        for (int i=0; i < newsArray.size(); i++ ){
            url_image_xlarge = "";
            url_image_wide = "";
            url_image_thumbnail = "";

            news = newsArray.get(i).getAsJsonObject();
            id = news.get(ConstantsRestApi.NEWS_ID).getAsString();

            headline = news.get(ConstantsRestApi.NEWS_HEADLINE).getAsJsonObject().get(ConstantsRestApi.NEWS_HEADLINE_MAIN).getAsString();
            snippet = news.get(ConstantsRestApi.NEWS_SNIPPET).getAsString();
            source = news.get(ConstantsRestApi.NEWS_SOURCE).getAsString();
            web_url = news.get(ConstantsRestApi.NEWS_URL).getAsString();

            if (news.has(ConstantsRestApi.NEWS_WORDS)){
                word_count = news.get(ConstantsRestApi.NEWS_WORDS).getAsString();
            }else {
                word_count = "";
            }

            try {
                Date date = formatter.parse(news.get(ConstantsRestApi.NEWS_DATE).getAsString());
                pub_date = df.format(date);
            } catch (Exception e) {
                pub_date = "";
            }

            multimediaList =  news.get(ConstantsRestApi.NEWS_MULTIMEDIA).getAsJsonArray();

            for (int j=0; j < multimediaList.size(); j++ ){
                image = multimediaList.get(j).getAsJsonObject();
                if (image.get(ConstantsRestApi.NEWS_MULTIMEDIA_TYPE).getAsString().equals("image") && image.get(ConstantsRestApi.NEWS_MULTIMEDIA_SUBTYPE).getAsString().equals("xlarge") ){
                    url_image_xlarge = image.get(ConstantsRestApi.NEWS_MULTIMEDIA_LEGACY).getAsJsonObject().get(ConstantsRestApi.NEWS_MULTIMEDIA_XLARGE).getAsString();
                }
                if (image.get(ConstantsRestApi.NEWS_MULTIMEDIA_TYPE).getAsString().equals("image") && image.get(ConstantsRestApi.NEWS_MULTIMEDIA_SUBTYPE).getAsString().equals("wide") ){
                    url_image_wide = image.get(ConstantsRestApi.NEWS_MULTIMEDIA_LEGACY).getAsJsonObject().get(ConstantsRestApi.NEWS_MULTIMEDIA_WIDE).getAsString();
                }
                if (image.get(ConstantsRestApi.NEWS_MULTIMEDIA_TYPE).getAsString().equals("image") && image.get(ConstantsRestApi.NEWS_MULTIMEDIA_SUBTYPE).getAsString().equals("thumbnail")){
                    url_image_thumbnail = image.get(ConstantsRestApi.NEWS_MULTIMEDIA_LEGACY).getAsJsonObject().get(ConstantsRestApi.NEWS_MULTIMEDIA_THUMBNAIL).getAsString();
                }
            }

            NewsItem newsItem = new NewsItem(id, headline, snippet, source, pub_date, web_url, word_count, url_image_xlarge, url_image_wide, url_image_thumbnail);
            newsItems.add(newsItem);
        }

        Calendar c = Calendar.getInstance();
        String currentDate = df.format(c.getTime());

        NewsResponse resp = new NewsResponse(query, currentDate, jsonObject_full.get(ConstantsRestApi.NEWS_STATUS).getAsString(),newsItems);
        return resp;
    }
}