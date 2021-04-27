package com.springtourofheroes.Validators;

import com.springtourofheroes.Classes.CustomHero;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.lang.reflect.Field;
import java.util.ArrayList;

@ControllerAdvice
public class CreateCustomHeroValidator {
    public static boolean validateInput(CustomHero customHero) {
        var fields = customHero.getClass().getDeclaredFields();
        var fieldNames = new ArrayList<String>();
        for (Field field : fields) {
            field.setAccessible(true);
            fieldNames.add(field.getName());
        }

        return true;
    }
}
