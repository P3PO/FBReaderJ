package org.geometerplus.fbreader.library;

import android.support.annotation.NonNull;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by animal@martus.org on 4/4/16.
 */
public class ReadingListBook {

    private int bookId;
    private String title;
    private ArrayList<String> authors;
    private Date dateAdded;
    private static final String JSON_CODE_TITLE = "title";
    private static final String JSON_CODE_AUTHORS = "authors";
    private static final String JSON_CODE_BOOKSHARE_ID = "bookshareId";
    private static final String JSON_CODE_LAST_NAME = "lastName";
    private static final String JSON_CODE_FIRST_NAME = "firstName";
    private static final String JSON_CODE_DATEADDED = "dateAdded";

    public ReadingListBook(JSONObject jsonToFillFrom) throws Exception {
        bookId = jsonToFillFrom.getInt(JSON_CODE_BOOKSHARE_ID);
        title = jsonToFillFrom.optString(JSON_CODE_TITLE);
        dateAdded = dateFromJson(jsonToFillFrom.optString(JSON_CODE_DATEADDED));
        fillAuthorsList(jsonToFillFrom.optJSONArray(JSON_CODE_AUTHORS));
    }

    private Date dateFromJson(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        if(dateString != null) {
            try {
                date = dateFormat.parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return date;
    }

    private void fillAuthorsList(JSONArray authorsAsJson) throws Exception {
        if (authorsAsJson == null)
            return;

        authors = new ArrayList<>();
        for (int index = 0; index < authorsAsJson.length(); ++index) {
            JSONObject authorAsJsonObject = authorsAsJson.getJSONObject(index);
            String surname = authorAsJsonObject.optString(JSON_CODE_LAST_NAME);
            String firstName = authorAsJsonObject.optString(JSON_CODE_FIRST_NAME);
            final String SINGLE_SPACE = " ";
            authors.add(firstName + SINGLE_SPACE + surname);
        }
    }

    public long getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public String getAllAuthorsAsString() {
        return getAllAuthorsAsString(this.authors);
    }

    @NonNull
    public static String getAllAuthorsAsString(List<String> authors) {
        StringBuffer buffer = new StringBuffer();
        for (int index = 0; index < authors.size(); ++index) {
            if (index > 0)
                buffer.append(", ");

            buffer.append(authors.get(index));
        }

        return buffer.toString();
    }

    public JSONObject toJSONObject(){
        JSONObject ans = new JSONObject();
        try {
            ans.put(JSON_CODE_BOOKSHARE_ID, bookId);
            ans.put(JSON_CODE_TITLE, title);
            JSONArray authorsArray = new JSONArray();
            for(String author : authors){
                authorsArray.put(author);
            }
            ans.put(JSON_CODE_AUTHORS, authorsArray);

        } catch (JSONException e){
            Log.e("JSONEXCEPTION", "error creating json representation of ReadingList", e);
        }
        return ans;
    }
}
