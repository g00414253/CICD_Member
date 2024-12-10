package ie.atu;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {
    List<Member> memberList =new ArrayList<>();
    @GetMapping("/getMember")
    public List<Member> getMember(){
        return memberList;
    }

    @PostMapping("/addMember")
    public List<Member> addMember(@Valid @RequestBody Member member){
        memberList.add(member);
        return memberList;
    }
}
