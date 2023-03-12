package uz.pdp.springframeworkcore.controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.springframeworkcore.daos.UploadsDao;
import uz.pdp.springframeworkcore.domains.Uploads;
import uz.pdp.springframeworkcore.dto.BookCreateDTO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Controller
public class UploadController {
    private final Path rootPath = Path.of("/home/jlkesh/Desktop/files/upload/");
    private final UploadsDao uploadsDao;

    public UploadController(UploadsDao uploadsDao) {
        this.uploadsDao = uploadsDao;
    }

    /*

     */
/*
    @GetMapping("/upload")
    @ResponseBody
    public String a(
            @RequestParam(name = "param1", required = false) String o,
            @RequestParam(name = "param2", required = false) String o2) {
        return "Server received : " + o + ":" + o2;
    }
*/

/*    @GetMapping("/download/{filename:.+}")
    @ResponseBody
    public String download(@PathVariable(name = "filename") String filename) {
        return "File with name " + filename + " Successfully downloded";
    }*/

    @GetMapping("/upload")
    public String uploadPage() {
        return "upload";
    }

    @PostMapping("/upload")
    public String uploadFile(@ModelAttribute BookCreateDTO dto) throws IOException {
        System.out.println("dto = " + dto);
        for (MultipartFile file : dto.getFiles()) {
            String originalFilename = file.getOriginalFilename();
            System.out.println("File Uploaded + " + originalFilename);
            String newName = UUID.randomUUID() + "." + StringUtils.getFilenameExtension(originalFilename);
            Path path = rootPath.resolve(newName);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        }
        return "redirect:/upload";
    }

    @PostMapping("/upload2")
    public String upload2File(@RequestParam("file") MultipartFile file) throws IOException {
        Uploads uploads = Uploads.builder()
                .originalName(file.getOriginalFilename())
                .generatedName(UUID.randomUUID() + "." + StringUtils.getFilenameExtension(file.getOriginalFilename()))
                .size(file.getSize())
                .mimeType(file.getContentType())
                .build();
        uploadsDao.save(uploads);
        Files.copy(file.getInputStream(), rootPath.resolve(uploads.getGeneratedName()), StandardCopyOption.REPLACE_EXISTING);
        return "redirect:/upload";
    }

    @GetMapping("/download/{filename:.+}")
    public ResponseEntity<Resource> downloadPage(@PathVariable String filename) {
        Uploads uploads = uploadsDao.findByGenerateName(filename);
        FileSystemResource fileSystemResource = new FileSystemResource(rootPath.resolve(filename));
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(uploads.getMimeType()))
                .contentLength(uploads.getSize())
                /*.header("Content-Disposition", "attachment; filename = " + uploads.getOriginalName())*/
                .body(fileSystemResource);
    }

}
