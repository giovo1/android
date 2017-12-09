package miempresa.com.bo.consumirws;

/**
 * Created by HP on 11/10/2017.
 */

public class RecipeResponse {
    private String searchText;
    private String recipes;
    private int number_of_pages;

    public RecipeResponse(String searchText, String recipes, int number_of_pages) {
        this.searchText = searchText;
        this.recipes = recipes;
        this.number_of_pages = number_of_pages;
    }
    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public String getRecipes() {
        return recipes;
    }

    public void setRecipes(String recipes) {
        this.recipes = recipes;
    }

    public String getText() {
        return searchText;
    }

    public void setText(String text) {
        this.searchText = text;
    }

    public int getNumber_of_pages() {
        return number_of_pages;
    }

    public void setNumber_of_pages(int number_of_pages) {
        this.number_of_pages = number_of_pages;
    }
}
