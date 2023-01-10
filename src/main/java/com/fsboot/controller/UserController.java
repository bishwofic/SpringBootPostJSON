package com.fsboot.controller;


import com.fsboot.Validator.UserDataInfoValidator;
import com.fsboot.dto.UserDto;
import com.fsboot.entities.ResponseModel;
import com.fsboot.entities.User;
import com.fsboot.helper.UserInfoHelper;
import com.fsboot.service.UserServiceDao;
import com.fsboot.utils.UserConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class UserController implements UserConstants {

    @Autowired
    private UserServiceDao userServiceDao;
    @Autowired
    private ResponseModel responseModel;

    @GetMapping("/search/{id}")
    public ResponseModel Search(@PathVariable("id") int id) {
        try {
            User user = userServiceDao.getSingleUserById(id);
            if (user != null) {
                responseModel.setMessage(DATA_FOUND);
                responseModel.setStatus(SUCCESS);
                responseModel.setData(user);
            } else {
                responseModel.setMessage(DATA_NOT_FOUND);
                responseModel.setStatus(FAIL);
            }
        } catch (Exception ex) {

            responseModel.setMessage(ERROR_EXCEPTION + ex.getLocalizedMessage());
            responseModel.setStatus(FAIL);
        }
        return responseModel;

    }

    @GetMapping("/index")
    public ResponseModel Index() {
        try {
            List<UserDto> allUser = userServiceDao.getAllUsers();
            if (allUser != null) {
                responseModel.setMessage(DATA_FOUND);
                responseModel.setStatus(SUCCESS);
                responseModel.setData(allUser);
            } else {
                responseModel.setMessage(DATA_NOT_FOUND);
                responseModel.setStatus(FAIL);
                responseModel.setData(null);
            }
        } catch (Exception ex) {

            responseModel.setMessage(ERROR_EXCEPTION + ex.getLocalizedMessage());
            responseModel.setStatus(FAIL);
        }
        return responseModel;

    }

    @PostMapping(value = "/save", consumes = "application/json")
    public ResponseModel Save(@RequestBody String jsonDataForSaveUserDataInfo) {
        ArrayList<String> validationResult;
        validationResult = UserDataInfoValidator.validateSaveUserInfo(jsonDataForSaveUserDataInfo);
        if (validationResult.isEmpty()) {
            try {
                User user = userServiceDao.insertUser(UserInfoHelper.processSaveUserInfoJsonRequestData(jsonDataForSaveUserDataInfo));
                if (user != null) {
                    responseModel.setStatus(SUCCESS);
                    responseModel.setMessage(USER_ADDED_SUCCESSFULLY);
                    responseModel.setData(user);
                } else {
                    responseModel.setStatus(FAIL);
                    responseModel.setMessage(ERROR_UNSUCCESS);
                    responseModel.setData(null);
                }
            } catch (Exception ex) {

                responseModel.setMessage(ERROR_EXCEPTION);
                responseModel.setStatus(FAIL);
                responseModel.setData(null);
            }

        } else {
            responseModel.setMessage(VALIDATION_ERROR);
            responseModel.setStatus(FAIL);
            responseModel.setData(validationResult);
        }
        return responseModel;
    }

    @PutMapping(value = "/update/{id}", consumes = "application/json")
    public ResponseModel Update(@RequestBody String jsonDataForUpdateUserDataInfo) {
        ArrayList<String> validationResult;
        validationResult = UserDataInfoValidator.validateUpdateUserInfo(jsonDataForUpdateUserDataInfo);
        if (validationResult.size() == 0) {
            try {
                User user = userServiceDao.updateUserById(UserInfoHelper.processUpdateUserInfoJsonRequestData(jsonDataForUpdateUserDataInfo));

                if (user != null) {
                    responseModel.setStatus(SUCCESS);
                    responseModel.setMessage(USER_DETAILS_UPDATED_SUCCESSFULLY);
                    responseModel.setData(user);
                } else {
                    responseModel.setStatus(FAIL);
                    responseModel.setMessage(ERROR_UNSUCCESS);
                    responseModel.setData(null);
                }
            } catch (Exception ex) {

                responseModel.setMessage(ERROR_EXCEPTION);
                responseModel.setStatus(FAIL);
                responseModel.setData(null);
            }

        } else {
            responseModel.setMessage(VALIDATION_ERROR);
            responseModel.setStatus(FAIL);
            responseModel.setData(validationResult);
        }
        return responseModel;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseModel Delete(@PathVariable("id") int id) {
        try {
            Optional<User> user = userServiceDao.deleteUserById(id);
            if (user != null) {
                responseModel.setData(user);
                responseModel.setMessage(USER_DETAILS_DELETED_SUCCESSFULLY);
                responseModel.setStatus(SUCCESS);
            } else {
                responseModel.setStatus(FAIL);
                responseModel.setMessage(ERROR_UNSUCCESS);
                responseModel.setData(null);
            }
        } catch (Exception ex) {

            responseModel.setMessage(ERROR_EXCEPTION);
            responseModel.setStatus(FAIL);
            responseModel.setData(null);
        }
        return responseModel;
    }
}
