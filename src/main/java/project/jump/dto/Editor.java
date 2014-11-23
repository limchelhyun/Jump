package project.jump.dto;

import org.springframework.web.multipart.MultipartFile;

public class Editor {
	private MultipartFile filedate;

	public void setFiledate(MultipartFile multipartFile) {
		this.filedate = filedate;
	}
	
	public MultipartFile getFiledate() {
		return filedate;
	}
}
