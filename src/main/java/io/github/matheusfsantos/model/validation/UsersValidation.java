package io.github.matheusfsantos.model.validation;

import io.github.matheusfsantos.model.domain.Users;
import io.github.matheusfsantos.model.exception.specialization.InvalidFields;
import io.github.matheusfsantos.model.utils.Regex;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class UsersValidation {

    public static void validation(Users user) throws InvalidFields {
        Regex regex = new Regex();
        List<String> messages = new ArrayList<>();

        CEPValidation(messages, user.getCEP());
        noteValidation(messages, user.getPI());
        noteValidation(messages, user.getADO());
        numberValidation(messages, user.getNumber());
        nameValidation(messages, regex, user.getName());

        if(!messages.isEmpty())
            throw new InvalidFields(HttpStatus.UNPROCESSABLE_ENTITY, messages, "The method to create a user was called, but some fields are invalid!");
    }

    private static void nameValidation(List<String> messages, Regex regex, String name) {
        if(name == null || name.length() < 5)
            messages.add("The name field must be at least 8 characters long");
        else {
            Matcher matcher = regex.REGEX_NAME.matcher(name);
            if(matcher.find())
                messages.add("The name field is invalid!");
        }
    }

    private static void CEPValidation(List<String> messages, String CEP) {
        if(CEP == null || CEP.length() != 8)
            messages.add("The CEP field must be 8 characters long");
    }

    private static void numberValidation(List<String> messages, String number) {
        if(number == null || number.isEmpty())
            messages.add("The CEP field must be 8 characters long");
    }

    private static void noteValidation(List<String> messages, Double note) {
        if(note == null || note.isNaN() || note < 0 || note > 10)
            messages.add("The ADO note is invalid!");
    }

}
