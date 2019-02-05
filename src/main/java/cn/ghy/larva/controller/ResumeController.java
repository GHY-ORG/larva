package cn.ghy.larva.controller;

import cn.ghy.larva.domain.Response;
import cn.ghy.larva.domain.Resume;
import cn.ghy.larva.util.FileUtil;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Calendar;

@RestController
public class ResumeController {
    private FileUtil fileUtil = new FileUtil();

    @RequestMapping(value = "/resume", method = RequestMethod.POST)
    public Response insert(@Valid @RequestBody Resume resume, BindingResult result)
            throws IOException {
        if (result.hasErrors()) {
            return new Response(400);
        } else {
            String basePath = fileUtil.baseLocalURL + "/resume/";
            //fileUtil.createDirectory(basePath);
            String path = basePath + getResumeFileName();
            resume.write2Excel(path);
            return new Response(201);
        }
    }

    private String getResumeFileName() {
        String fileName;
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        if (month <= 6) {
            fileName = year + "_spring" + ".xlsx";
        } else {
            fileName = year + "_fall" + ".xlsx";
        }
        return fileName;
    }
}
