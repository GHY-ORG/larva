package cn.ghy.larva.controller;

import cn.ghy.larva.domain.File;
import cn.ghy.larva.domain.Response;
import cn.ghy.larva.service.FileService;
import cn.ghy.larva.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/admin/")
public class IFileController {
    private final FileService fileService;
    private FileUtil fileUtil = new FileUtil();

    @Autowired
    public IFileController(FileService fileService) {
        this.fileService = fileService;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Response upload(HttpServletRequest request) throws IOException {
        String destination = request.getParameter("destination");
        String description = request.getParameter("description");
        ArrayList<File> files = fileUtil.upload(request, destination, description);
        for (File file : files) {
            fileService.insert(file);

        }
        return new Response();
    }
}
