package com.star.criminalintent;

import org.json.JSONException;
import org.json.JSONObject;

public class Suspect {

    private static final String JSON_DISPLAY_NAME = "displayName";
    private static final String JSON_NUMBER = "number";

    private String mDisplayName;
    private String mNumber;

    public Suspect(String displayName, String number) {
        mDisplayName = displayName;
        mNumber = number;
    }

    public Suspect(JSONObject json) throws JSONException {
        mDisplayName = json.getString(JSON_DISPLAY_NAME);
        mNumber = json.getString(JSON_NUMBER);
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject json = new JSONObject();
        json.put(JSON_DISPLAY_NAME, mDisplayName);
        json.put(JSON_NUMBER, mNumber);
        return json;
    }

    public String getDisplayName() {
        return mDisplayName;
    }

    public void setDisplayName(String displayName) {
        mDisplayName = displayName;
    }

    public String getNumber() {
        return mNumber;
    }

    public void setNumber(String number) {
        mNumber = number;
    }
}
