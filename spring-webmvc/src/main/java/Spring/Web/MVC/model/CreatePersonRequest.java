package Spring.Web.MVC.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePersonRequest {

    private String firstName;

    private String middlleName;

    private String lastName;

    private String email;

    private String phone;

    private CreateAddressRequest address;

    private List<String> hobbies;

    private List<CreateSocialMediaRequest> socialMedias;

}
