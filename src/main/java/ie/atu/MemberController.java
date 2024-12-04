package ie.atu;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {
    List<Member> memberList = new ArrayList<>();

    //need a get,add,update,delete member functions

    //update to return specific member
    @GetMapping("/getMember")
    public List<Member> getMember() {
        return memberList;
    }

    @PostMapping("/addMember")
    public List<Member> addMember(@Valid @RequestBody Member member) {
        memberList.add(member);
        return memberList;
    }

    //add specific member and updating logic
    @PutMapping("/updateMember")
    public List<Member> updateMember(@Valid @RequestBody Member member) {
        return memberList;
    }

    //add specific delete member and removal logic
    @DeleteMapping("/deleteMember")
    public List<Member> deleteMember(@Valid @RequestBody Member member) {
        memberList.remove(member);
        return memberList;
    }
}
