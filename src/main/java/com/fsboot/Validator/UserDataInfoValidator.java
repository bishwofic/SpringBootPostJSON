package com.fsboot.Validator;

import java.util.ArrayList;

import com.fsboot.utils.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class UserDataInfoValidator implements UserConstants {
    public static ArrayList<String> validateSaveUserInfo(String jsonDataforSaveUserInfo) {
        ArrayList<String> validationMessage = new ArrayList<>();
        try {
            JsonObject convertedObject = new Gson().fromJson(jsonDataforSaveUserInfo, JsonObject.class);
            if (!convertedObject.has(_USER_NAME)) {
                validationMessage.add(_USER_NAME_MISSING);
            if (!convertedObject.has(_USER_ADDRESS)) {
                validationMessage.add(_USER_ADDRESS_MISSING);
                }
            } else {
                String name = convertedObject.get(_USER_NAME).getAsString();
                String address = convertedObject.get(_USER_ADDRESS).getAsString();
                if (name.isEmpty() || name.length() > 255) {
                    validationMessage.add(_USER_NAME_VALIDATION);
                }
                if (address.isEmpty() || address.length() > 255) {
                    validationMessage.add(_USER_ADDRESS_VALIDATION);
                }
            }
        } catch (Exception ex) {
            validationMessage.add(_FIELD_MISSING + ex.toString());
        }
        return validationMessage;

    }

    public static ArrayList<String> validateUpdateUserInfo(String jsonDataforUpdateUserInfo) {
        ArrayList<String> validationMessage = new ArrayList<>();
        try {
            JsonObject convertedObject = new Gson().fromJson(jsonDataforUpdateUserInfo, JsonObject.class);
            if (!convertedObject.has(_ID)) {
                validationMessage.add(_ID_FIELD_MISSING);
            }
            if (!convertedObject.has(_USER_NAME)) {
                validationMessage.add(_USER_NAME_MISSING);
            }
            if (!convertedObject.has(_USER_ADDRESS)) {
                validationMessage.add(_USER_ADDRESS_MISSING);
            }
            else {
                String name = convertedObject.get(_USER_NAME).getAsString();
                String address = convertedObject.get(_USER_ADDRESS).getAsString();
                if (name.isEmpty() || name.length() > 255) {
                    validationMessage.add(_USER_NAME_VALIDATION);
                }
                if (address.isEmpty() || address.length() > 255) {
                    validationMessage.add(_USER_ADDRESS_VALIDATION);
                }
            }
        } catch (Exception ex) {
            validationMessage.add(_FIELD_MISSING + ex.toString());
        }
        return validationMessage;
    }
}
