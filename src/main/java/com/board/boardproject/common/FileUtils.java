package com.board.boardproject.common;


import com.board.boardproject.dto.BoardFile;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileUtils {

    public List<BoardFile> parseFileInfo(int boardCode, List<MultipartFile> files) throws Exception{
        if (files == null || files.isEmpty()) {
            return null;
        }
        List<BoardFile> fileList = new ArrayList<>();

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
        ZonedDateTime current = ZonedDateTime.now();

        // 사용자 홈 디렉토리를 기반으로 저장 경로 설정
        String userHome = System.getProperty("user.home");
        String path = userHome + "/images/" + current.format(format);

        File file = new File(path);
        if (!file.exists()) {
            System.out.println("?");
            file.mkdirs();
        }

        String newFileName, originalFileExtension, contentType;

        for(MultipartFile multipartFile : files){
            contentType = multipartFile.getContentType();
            if(ObjectUtils.isEmpty(contentType)){
                break;
            }
            else {
                if (contentType.contains("image/jpeg")) {
                    originalFileExtension = ".jpg";
                } else if (contentType.contains("image/png")) {
                    originalFileExtension = ".png";
                } else if (contentType.contains("image/gif")) {
                    originalFileExtension = ".gif";
                } else {
                    break;
                }
            }

            newFileName = Long.toString(System.nanoTime()) + originalFileExtension;
            BoardFile boardFile = new BoardFile();
            boardFile.setBoardCode(boardCode);
            boardFile.setFileSize(multipartFile.getSize());
            boardFile.setOriginalFileName(multipartFile.getOriginalFilename());
            boardFile.setStoredFilePath(path + "/" + newFileName);
            fileList.add(boardFile);

            file = new File(path + "/" + newFileName);
            multipartFile.transferTo(file);
        }
        return fileList;
    }
}
