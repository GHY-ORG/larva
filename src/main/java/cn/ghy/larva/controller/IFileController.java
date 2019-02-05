package cn.ghy.larva.controller;

import cn.ghy.larva.domain.File;
import cn.ghy.larva.service.IFileService;
import cn.ghy.larva.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/admin/")
public class IFileController {
    private final IFileService IFileService;
    private FileUtil fileUtil = new FileUtil();

    @Autowired
    public IFileController(IFileService IFileService) {
        this.IFileService = IFileService;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<?> upload(HttpServletRequest request) {
        String to = request.getParameter("to");
        String desc = request.getParameter("desc");
        try {
            ArrayList<File> files = fileUtil.upload(request, to, desc);
            for (File file : files) {
                file.setUserId((long) 1);
                IFileService.insert(file);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
