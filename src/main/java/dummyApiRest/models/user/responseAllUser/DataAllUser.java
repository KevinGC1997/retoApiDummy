package dummyApiRest.models.user.responseAllUser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataAllUser {

    @JsonProperty("id")
    public Integer id;

    @JsonProperty("employee_name")
    public String employee_name;

    @JsonProperty("employee_salary")
    public Integer employee_salary;

    @JsonProperty("employee_age")
    public Integer employee_age;

    @JsonProperty("profile_image")
    public String profile_image;
}
