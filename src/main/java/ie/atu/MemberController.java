package ie.atu;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {
    List<Member> memberList =new ArrayList<>();

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

