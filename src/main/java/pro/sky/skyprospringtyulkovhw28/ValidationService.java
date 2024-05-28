package pro.sky.skyprospringtyulkovhw28;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {
    public String validateName(String name) {
        if (!StringUtils.isAlpha(name)) {
            throw new ValidationFailedExeption();
        }
        return StringUtils.capitalize(name.toLowerCase());
    }
}
