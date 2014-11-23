package project.jump.search;

import java.util.ArrayList;

import project.jump.dto.JumpBoard;

public interface SearchDAO {
	ArrayList<JumpBoard> findSearch(String search);
}
