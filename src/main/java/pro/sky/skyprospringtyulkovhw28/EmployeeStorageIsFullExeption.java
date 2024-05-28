package pro.sky.skyprospringtyulkovhw28;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EmployeeStorageIsFullExeption extends RuntimeException{
    public EmployeeStorageIsFullExeption() {
        super("Хранилище сотрудников заполнено");
    }
}
