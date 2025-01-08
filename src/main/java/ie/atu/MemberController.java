package ie.atu;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {
    List<Member> memberList =new ArrayList<>();

    public MemberController() {
        memberList.add(new Member(1, "John Doe", "john.doe@example.com", 30, "Active", 12));
        memberList.add(new Member(2, "Jane Smith", "jane.smith@example.com", 25, "Active", 6));
        memberList.add(new Member(3, "Alex Johnson", "alex.johnson@example.com", 35, "Expired", 0));
        memberList.add(new Member(4, "Emily Davis", "emily.davis@example.com", 28, "Active", 24));
        memberList.add(new Member(5, "Michael Brown", "michael.brown@example.com", 40, "Expired", 0));
        memberList.add(new Member(6, "Sarah White", "sarah.white@example.com", 22, "Active", 3));
    }

    @GetMapping("/getAllMember")
    public List<Member> getMember(){
        return memberList;
    }

    @GetMapping("/getMember/{memberID}")
    public Member getMemberById(@PathVariable int memberID) {
        return memberList.stream()
                .filter(member -> member.getMemberID() == memberID)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Member not found with ID: " + memberID));
    }

    @PostMapping("/addMember")
    public List<Member> addMember(@Valid @RequestBody Member member){
        memberList.add(member);
        return memberList;
    }

    @PutMapping("/updateMember/{memberID}")
    public Member updateMember(@PathVariable int memberID, @Valid @RequestBody Member updatedMember) {
        for (int i = 0; i < memberList.size(); i++) {
            Member existingMember = memberList.get(i);
            if (existingMember.getMemberID() == memberID) {
                // Update member
                memberList.set(i, updatedMember);
                return updatedMember;
            }
        }
        throw new RuntimeException("Member not found with ID: " + memberID);
    }

    @DeleteMapping("/deleteMember/{memberID}")
    public List<Member> deleteMember(@PathVariable int memberID) {
        memberList.removeIf(member -> member.getMemberID() == memberID);
        return memberList;
    }
}

/*  TESTING TALEND API ENTRIES
    http://localhost:8080/member/getAllMember
    http://localhost:8080/member/getMember/2
    http://localhost:8080/member/addMember
    {
  "memberID": 42,
  "name": "Eval",
  "emailAddress": "evmail@dhddh.com",
  "age": 66,
  "membershipStatus": "Expired",
  "membershipDuration": 0
 }

   http://localhost:8080/member/updateMember/1
   http://localhost:8080/member/deleteMember/1
 */