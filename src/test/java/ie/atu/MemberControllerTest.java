package ie.atu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MemberControllerTest {

    private MemberController memberController;

    @BeforeEach
    void setUp() {
        memberController = new MemberController();
    }

    @Test
    void testGetAllMembers() {
        List<Member> members = memberController.getMember();

        assertNotNull(members);
        assertEquals(6, members.size()); // Initial list has 6 members
    }

    @Test
    void testGetMemberById_ValidID() {
        Member member = memberController.getMemberById(1);

        assertNotNull(member);
        assertEquals(1, member.getMemberID());
        assertEquals("John Doe", member.getName());
    }

    @Test
    void testGetMemberById_InvalidID() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            memberController.getMemberById(999); // Nonexistent ID
        });

        assertEquals("Member not found with ID: 999", exception.getMessage());
    }

    @Test
    void testAddMember_ValidInput() {
        Member newMember = new Member(7, "Alice Green", "alice.green@example.com", 29, "Active", 12);

        List<Member> updatedMembers = memberController.addMember(newMember);

        assertEquals(7, updatedMembers.size()); // Initial 6 + 1 new member
        assertEquals("Alice Green", updatedMembers.get(6).getName()); // Verify the new member
    }

    @Test
    void testUpdateMember_ValidID() {
        Member updatedMember = new Member(1, "John Updated", "john.updated@example.com", 30, "Active", 12);

        Member result = memberController.updateMember(1, updatedMember);

        assertNotNull(result);
        assertEquals("John Updated", result.getName());
        assertEquals("john.updated@example.com", result.getEmailAddress());
    }

    @Test
    void testUpdateMember_InvalidID() {
        Member updatedMember = new Member(999, "Nonexistent", "nonexistent@example.com", 30, "Active", 12);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            memberController.updateMember(999, updatedMember);
        });

        assertEquals("Member not found with ID: 999", exception.getMessage());
    }

    @Test
    void testDeleteMember_ValidID() {
        List<Member> updatedMembers = memberController.deleteMember(1);

        assertEquals(5, updatedMembers.size()); // Initial 6 - 1
        assertTrue(updatedMembers.stream().noneMatch(member -> member.getMemberID() == 1));
    }

    @Test
    void testDeleteMember_InvalidID() {
        List<Member> updatedMembers = memberController.deleteMember(999);

        assertEquals(6, updatedMembers.size()); // No change since ID 999 doesn't exist
    }
}
