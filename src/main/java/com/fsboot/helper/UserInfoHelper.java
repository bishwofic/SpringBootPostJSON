package com.fsboot.helper;

import com.fsboot.entities.User;
import com.fsboot.utils.UserConstants;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class UserInfoHelper implements UserConstants {
    public static User processSaveUserInfoJsonRequestData(String jsonDataforSaveUserInfo) {
        User user = new User();
        try {
            JsonObject convertedObject = new Gson().fromJson(jsonDataforSaveUserInfo, JsonObject.class);
            String name = convertedObject.get(_USER_NAME).getAsString();
            String address = convertedObject.get(_USER_ADDRESS).getAsString();
            user.setName(name);
            user.setAddress(address);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return user;
    }

    public static User processUpdateUserInfoJsonRequestData(String jsonDataforSaveUserInfo) {
        User user = new User();
        try {
            JsonObject convertedObject = new Gson().fromJson(jsonDataforSaveUserInfo, JsonObject.class);
            Integer id = convertedObject.get(_ID).getAsInt();
            String name = convertedObject.get(_USER_NAME).getAsString();
            String address = convertedObject.get(_USER_ADDRESS).getAsString();
            user.setId(id);
            user.setName(name);
            user.setAddress(address);
        } catch (Exception ex) {
            ex.getMessage();
        }
        return user;
    }
}