package latihan.restful_api.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import latihan.restful_api.entity.User;
import latihan.restful_api.exceptions.ApiException;
import latihan.restful_api.model.RegisterUserRequest;
import latihan.restful_api.security.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ValidationService {
    @Autowired
    private Validator validator;

    public void validate(Object request){
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(request);
        if (constraintViolations.size() != 0 ) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }
}
