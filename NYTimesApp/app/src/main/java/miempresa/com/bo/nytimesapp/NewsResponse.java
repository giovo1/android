package miempresa.com.bo.nytimesapp;

import java.util.List;

/**
 * Created by HP on 16/10/2017.
 */

public class NewsResponse {

    private String searchQuery;
    private String searchDate;
    private String searchStatus;
    List<NewsItem> itemList;

    public NewsResponse(String searchQuery, String searchDate, String searchStatus, List<NewsItem> itemList){
        this.searchQuery = searchQuery;
        this.searchDate = searchDate;
        this.searchStatus = searchStatus;
        this.itemList = itemList;
    }

    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    public String getSearchDate() {
        return searchDate;
    }

    public void setSearchDate(String searchDate) {
        this.searchDate = searchDate;
    }

    public List<NewsItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<NewsItem> itemList) {
        this.itemList = itemList;
    }

    public String getSearchStatus() {
        return searchStatus;
    }

    public void setSearchStatus(String searchStatus) {
        this.searchStatus = searchStatus;
    }
}
