package project.jump.detail;

import project.jump.dto.JumpBoard;

public interface DetailDAO {
      JumpBoard jumpDetail(int boardNum);
      int detailBestIdCheck(int boardNum, String jumpId);
}
