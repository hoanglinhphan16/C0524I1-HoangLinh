package com.example.registerform.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Getter
@Setter
@NoArgsConstructor
public class UserDto implements Validator {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private int age;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (target instanceof UserDto) {
            UserDto userDto = (UserDto) target;

            if (userDto.getFirstName() == null || userDto.getFirstName().length() < 5 || userDto.getFirstName().length() > 45) {
                errors.rejectValue("firstName", "lengthNameError", "Độ dài không hợp lệ");
            }

            if (userDto.getLastName() == null || userDto.getLastName().length() < 5 || userDto.getLastName().length() > 45) {
                errors.rejectValue("lastName", "lengthNameError", "Độ dài không hợp lệ");
            }

            if (userDto.getPhoneNumber() == null || !userDto.getPhoneNumber().matches("^0\\d{9}$")) {
                errors.rejectValue("phoneNumber", "formatPhoneNumberError", "Sai định dạng");
            }

            if (userDto.getAge() < 18) {
                errors.rejectValue("age", "ageError", "Không đủ tuổi");
            }

            if (userDto.getEmail() == null || !userDto.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
                errors.rejectValue("email", "formatEmailError", "Sai định dạng");
            }
        } else {
            errors.rejectValue("typeError","error", "Invalid user data type");
        }
    }
}
