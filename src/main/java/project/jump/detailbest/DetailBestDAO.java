package project.jump.detailbest;

import java.util.ArrayList;

import project.jump.dto.JumpBoard;

public interface DetailBestDAO {
	JumpBoard detailBest(int boardNum,String jumpId);
	int detailBestGetNum(int boardNum,String jumpId);
}
