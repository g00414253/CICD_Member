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
    //add auto increment of id use this to search up users and their information
    @Min(value=1, message = "Member must has a valid ID of 1 or greater")
    private int MemberID;

    @NotBlank(message = "You must enter  valid name")
    private String Name;

    @Email(message = "Must enter a valid email address")
    private String EmailAddress;

    @Min(value = 16,message = "Members must be over 16")
    private int Age;

    //Possible boolean for membership status may be handled in the membership service
    //@NotBlank
    //boolean MemberStatus;


}
