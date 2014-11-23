package project.jump.list;

import java.util.ArrayList;
import java.util.List;

import project.jump.dto.JumpBoard;

public interface listDAO {
	ArrayList<JumpBoard> findAll();
}
