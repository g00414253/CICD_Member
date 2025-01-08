package ie.atu;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

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
    @NotBlank(message = "Membership status cannot be blank")
    @Pattern(regexp = "Active|Expired", message = "Membership status must be 'Active' or 'Expired'")
    private String membershipStatus;
    @Max(value = 24, message = "Membership duration must not exceed 24 months")
    private int membershipDuration;
}
