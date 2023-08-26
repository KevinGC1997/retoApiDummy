package dummyApiRest.models.user.responseAllUser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAllUser {

    @JsonProperty("status")
    public String status;

    @JsonProperty("data")
    public List<DataAllUser> data;

    @JsonProperty("message")
    public String message;
}
