package user;

import io.qameta.allure.Step;

public class UserClient {

    private static final String USER_OPERATION_PATH = "/api/v1/users";
    private static final String CHECK_EMAIL_AVAILABILITY_PATH = "/api/v1/users/is-available";

    @Step("Создаем пользователя")
    public void createUser (User user) {

    }

    @Step("Получаем список всех пользователей")
    public void getAllUsers() {

    }

    @Step("Получаем информацию об одном пользователе")
    public void getSingleUser() {

    }

    @Step("Обновляем информацию о пользователе")
    public void updateUser (User user){

    }

    @Step("Проверяем зарегистрирован ли емейл в системе")
    public void emailAvailablitiy() {

    }


}
