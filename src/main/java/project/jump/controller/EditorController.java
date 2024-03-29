package project.jump.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import project.jump.dto.Editor;

@Controller
public class EditorController {

	@RequestMapping(value="/file_uploader")
	public String file_uploader(HttpServletRequest request,HttpServletResponse response, Editor editor){
		System.out.println("test /file_uploader");
		String return1 = request.getParameter("callback");
		String return2 ="?callback_func" + request.getParameter("callback_func");
		String return3 ="";
		String name = "";
		try{
			if(editor.getFiledate() != null && editor.getFiledate().getOriginalFilename() != null && !editor.getFiledate().getOriginalFilename().equals("")){
				//기존 상단 코드를 막고 하단코드를 이용
				name=editor.getFiledate().getOriginalFilename().substring(editor.getFiledate().getOriginalFilename().lastIndexOf(File.separator)+1);
				String filename_ext = name.substring(name.lastIndexOf(".")+1);
				filename_ext = filename_ext.toLowerCase();
				String[] allow_file = {"jpg","png","bmp","gif"};
				int cnt = 0;
				for(int i=0; i<allow_file.length; i++){
					if(filename_ext.equals(allow_file[i])){
						cnt++;
					}
				}
				
					if(cnt == 0){
						return3 = "&errstr="+name;
					}else{
						//파일 기본경로
						String dftFilePath=request.getSession().getServletContext().getRealPath("/");
						//파일 기본경로_상세경로
						String filePath=dftFilePath+"resources"+File.separator+"editor"+File.separator+"upload"+File.separator;
						File file = new File(filePath);
					
						if(!file.exists()){
							file.mkdirs();
						}	
						
						String realFileNm="";
						SimpleDateFormat formatter = new SimpleDateFormat("yyyMMddHHmmss");
						String today = formatter.format(new java.util.Date());
						realFileNm = today+UUID.randomUUID().toString()+name.substring(name.lastIndexOf("."));
						String rlFileNm = filePath + realFileNm;
						////////////////////서버에 파일 쓰기 ///////////////
						editor.getFiledate().transferTo(new File(rlFileNm));
						////////////////////서버에 파일쓰기 종료/////////////
						return3 += "&bNewLine=true";
						return3 += "&sFileName="+name;
						return3 += "&sFileURL=/resources/editor/upload"+realFileNm;
					}
			}else{return3 += "&errstr=error";}
		}catch(Exception e){e.printStackTrace();}
		return "refirect:"+return1+return2+return3;
	}
	
	@RequestMapping(value="/file_uploader_html5")
	public void file_uploader_html5(HttpServletRequest request,HttpServletResponse response){
		System.out.println("test /file_uploader_html5");
		try{
			//파일정보
			String sFileInfo="";
			//파일명을 받는다-일반 원본파일명
			String filename = request.getHeader("file-name");
			//파일 확장자
			String filename_ext = filename.substring(filename.lastIndexOf(".")+1);
			//확장자를소문자로변경
			filename_ext = filename_ext.toLowerCase();
			
			//이미지 검증 배열변수
			String[] allow_file={"jpg","png","gif"};
			
			//돌리면서 확장자가 이미지인지 확인
			int cnt=0;
			for(int i=0; i<allow_file.length; i++){
				if(filename_ext.equals(allow_file[i])){
					cnt++;
				}
			}
			
			//이미지가 아님
			if(cnt == 0){
				PrintWriter print = response.getWriter();
				print.print("NOTALLOW_"+filename);
				print.flush();
				print.close();
			}else{
				//이미지이므로 신규파일로 디렉토리 설정 및 업로드
				//파일 기본경로
				String dftFilePath = request.getSession().getServletContext().getRealPath("/");
				String test = this.getClass().getResource("").getPath();
				System.out.println("test="+test);/////////////////////////////////////////////////////////////////////////////////////////
			
				System.out.println("dftFilePath="+dftFilePath);///////////////////////////////////////////////////////////////////////////
				//파일 기본경로_ 상세경로
				String filePath = dftFilePath + "resources" + File.separator + "editor" + File.separator + "multiupload" + File.separator;
				System.out.println("filePat="+filePath);//////////////////////////////////////////////////////////////////////////////////
				File file = new File("");
				if(!file.exists()){
					file.mkdirs();
				}
				String realFileNm = "";
				SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
				String today = formatter.format(new java.util.Date());
				realFileNm = today+UUID.randomUUID().toString()+filename.substring(filename.lastIndexOf("."));
				String rlFileNm = filePath + realFileNm;
				////////////////////////서버에 파일쓰기 ////////////
				InputStream is = request.getInputStream();
				OutputStream os = new FileOutputStream(rlFileNm);
				int numRead;
				byte b[] = new byte[Integer.parseInt(request.getHeader("file-size"))];
				while((numRead = is.read(b,0,b.length))!= -1){
					os.write(b,0,numRead);
				}
				if(is != null){
					is.close();
				}
				os.flush();
				os.close();
				///////////////////서버에 파일쓰기 끝 /////////////////
				
				//정보 출력
				sFileInfo += "&bNewLine=true";
				//img 태그의 title 속성을 원본파일명으로 적용시켜주기 위함
				sFileInfo += "&sFilename="+filename;
				sFileInfo += "&sFileURL="+ "/resources/editor/multiupload/"+realFileNm;
				System.out.println("sFileInfo="+sFileInfo);////////////////////////////////////////////////////////////////////////////////////////////////
				PrintWriter print = response.getWriter();
				print.print(sFileInfo);
				print.flush();
				print.close();
			}
		}catch(Exception e){e.printStackTrace();}
	}
}
