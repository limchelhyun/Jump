package project.jump.posting;

import project.jump.dto.Jump;
import project.jump.dto.JumpBoard;
import project.jump.dto.JumpCheck;

public interface postingDAO {
	void jumpBoardInsert(JumpBoard jumpboard);
	void jumpCheckInsert(JumpCheck jumpCheck);
}
