package miempresa.com.bo.nytimesapp;

/**
 * Created by HP on 16/10/2017.
 */

public class NewsItem {
    private String id;
    private String headline;
    private String snippet;
    private String source;
    private String pub_date;
    private String web_url;
    private String word_count;
    private String url_image_xlarge;
    private String url_image_wide;
    private String url_image_thumbnail;

    public NewsItem (String id, String headline, String snippet, String source, String pub_date, String web_url, String word_count, String url_image_xlarge, String url_image_wide, String url_image_thumbnail){
        this.id = id;
        this.headline = headline;
        this.snippet = snippet;
        this.source = source;
        this.pub_date = pub_date;
        this.web_url = web_url;
        this.word_count = word_count;
        this.url_image_xlarge = url_image_xlarge;
        this.url_image_wide = url_image_wide;
        this.url_image_thumbnail = url_image_thumbnail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPub_date() {
        return pub_date;
    }

    public void setPub_date(String pub_date) {
        this.pub_date = pub_date;
    }

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public String getWord_count() {
        return word_count;
    }

    public void setWord_count(String word_count) {
        this.word_count = word_count;
    }

    public String getUrl_image_xlarge() {
        return url_image_xlarge;
    }

    public void setUrl_image_xlarge(String url_image_xlarge) {
        this.url_image_xlarge = url_image_xlarge;
    }

    public String getUrl_image_wide() {
        return url_image_wide;
    }

    public void setUrl_image_wide(String url_image_wide) {
        this.url_image_wide = url_image_wide;
    }

    public String getUrl_image_thumbnail() {
        return url_image_thumbnail;
    }

    public void setUrl_image_thumbnail(String url_image_thumbnail) {
        this.url_image_thumbnail = url_image_thumbnail;
    }

}
