package com.invillia.incubadora.controller;

import com.invillia.incubadora.exception.ActionNotPermitedException;
import com.invillia.incubadora.exception.UserNotFoundException;
import com.invillia.incubadora.model.User;
import com.invillia.incubadora.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author s2it_pandrade
 * @version : $<br/>
 * : $
 * @since 24/10/19 14:43
 */
class UserControllerTest {

    private static UserController userController;
    private static UserRepository mockedUserRepository;
    private static BindingResult mockedBindingResult;
    private static Model mockedModel;

    @BeforeAll
    public static void setUpUserControllerInstance() {
        mockedUserRepository = mock(UserRepository.class);
        mockedBindingResult = mock(BindingResult.class);
        mockedModel = mock(Model.class);
        userController = new UserController(mockedUserRepository);
    }

    @Test
    public void whenCalledshowSignUpFormThenCorrect() {
        User user = new User("John", "john@domain.com");

        assertThat(userController.showSignUpForm(user)).isEqualTo("add-user");
    }

    @Test
    public void whenCalledaddUserAndValidUserThenCorrect() {
        User user = new User("John", "john@domain.com");

        when(mockedBindingResult.hasErrors()).thenReturn(false);

        assertThat(userController.addUser(user, mockedBindingResult, mockedModel)).isEqualTo("index");
    }

    @Test
    public void whenCalledaddUserAndInValidUserThenCorrect() {
        User user = new User("John", "john@domain.com");

        when(mockedBindingResult.hasErrors()).thenReturn(true);

        assertThat(userController.addUser(user, mockedBindingResult, mockedModel)).isEqualTo("add-user");
    }

    @Test
    public void whenCalledshowUpdateFormThenActionNotPermitedException() {
        assertThrows(ActionNotPermitedException.class, () -> userController.showUpdateForm(0, mockedModel));
    }

    @Test
    public void whenCalledupdateUserAndValidUserThenCorrect() {
        User user = new User("John", "john@domain.com");

        when(mockedBindingResult.hasErrors()).thenReturn(false);

        assertThat(userController.updateUser(1L, user, mockedBindingResult, mockedModel)).isEqualTo("index");
    }

    @Test
    public void whenCalledupdateUserAndInValidUserThenCorrect() {
        User user = new User("John", "john@domain.com");

        when(mockedBindingResult.hasErrors()).thenReturn(true);

        assertThat(userController.updateUser(1L, user, mockedBindingResult, mockedModel)).isEqualTo("update-user");
    }

    @Test
    public void whenCalleddeleteUserThenUserNotFoundException() {
        assertThrows(UserNotFoundException.class, () -> userController.deleteUser(1L, mockedModel));
    }
}
