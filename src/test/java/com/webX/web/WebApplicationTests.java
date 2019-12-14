package com.webX.web;

import com.webX.web.helper.PhoneBookHelper;
import com.webX.web.service.model.base.BaseResponse;
import com.webX.web.service.operation.PhoneBookOperations;
import com.webX.web.service.operation.callType.PhoneBookCallType;
import java.util.ArrayList;
import static org.assertj.core.api.Java6Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PhoneBookTests {

    private PhoneBookOperations phoneBookOperations;
    private PhoneBookHelper phoneBookHelper = Mockito.mock(PhoneBookHelper.class);;

    @BeforeEach
    void initPhoneBookService() {
        phoneBookOperations = new PhoneBookOperations(phoneBookHelper);
    }

    @Test
    void addPersonHasStatusSuccess() throws Exception {
        String name = "testName";
        BaseResponse response = phoneBookOperations.doOperation(PhoneBookCallType.AddPerson, name);
        assertThat(response.getStatus()).isEqualTo("success");
    }

    @Test
    void addPersonWhenThrownExceptionHasStatusError() throws Exception {
        String name = "testName";
        doThrow(Exception.class).when(phoneBookHelper).addPerson(any(String.class));
        BaseResponse response = phoneBookOperations.doOperation(PhoneBookCallType.AddNumber, name);
        assertThat(response.getStatus()).isEqualTo("error");
    }

    @Test
    void addNumberHasStatusSuccess() throws Exception {
        String number = "000000";
        Integer personId = 0;
        BaseResponse response = phoneBookOperations.doOperation(PhoneBookCallType.AddNumber, personId, number);
        assertThat(response.getStatus()).isEqualTo("success");
    }

    @Test
    void addNumberWhenThrownExceptionHasStatusError() throws Exception {
        String number = "000000";
        Integer personId = 0;
        doThrow(Exception.class).when(phoneBookHelper).addNumber(any(Integer.class), any(String.class));
        BaseResponse response = phoneBookOperations.doOperation(PhoneBookCallType.AddNumber, personId, number);
        assertThat(response.getStatus()).isEqualTo("error");
    }

    @Test
    void getNumbersHasStatusSuccess() throws Exception {
        when(phoneBookHelper.getNumbers()).thenReturn(new ArrayList<>());
        BaseResponse response = phoneBookOperations.doOperation(PhoneBookCallType.GetNumbers);
        assertThat(response.getStatus()).isEqualTo("success");
    }

    @Test
    void getNumbersWhenThrownExceptionHasStatusError() throws Exception {
        when(phoneBookHelper.getNumbers()).thenThrow(new Exception());
        BaseResponse response = phoneBookOperations.doOperation(PhoneBookCallType.GetNumbers);
        assertThat(response.getStatus()).isEqualTo("error");
    }

    @Test
    void getPeopleHasStatusSuccess() throws Exception {
        when(phoneBookHelper.getPeople()).thenReturn(new ArrayList<>());
        BaseResponse response = phoneBookOperations.doOperation(PhoneBookCallType.GetPeople);
        assertThat(response.getStatus()).isEqualTo("success");
    }

    @Test
    void getPeopleWhenThrownExceptionHasStatusError() throws Exception {
        when(phoneBookHelper.getPeople()).thenThrow(new Exception());
        BaseResponse response = phoneBookOperations.doOperation(PhoneBookCallType.GetPeople);
        assertThat(response.getStatus()).isEqualTo("error");
    }

}
