package ie.atu;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Min(value=1, message = "Member must has a valid ID of 1 or greater")
    private int memberID;
    @NotBlank(message = "You must enter  valid name")
    private String name;
    @Email(message = "Must enter a valid email address")
    private String emailAddress;
    @Min(value = 16,message = "Members must be over 16")
    private int age;
}
