//package org.application.start.controller;
//
////import org.application.start.operation.ApplicationBinaryRepository;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.nio.file.Path;
//
//@RestController
//@RequestMapping("/binaries")
//public class ApplicationBinaryController {
//
//    private ApplicationBinaryRepository binaryRepository;
//
//    public ApplicationBinaryController(ApplicationBinaryRepository binaryRepository) {
//        this.binaryRepository = binaryRepository;
//    }
//
//    @PostMapping
//    public void uploadBinary(@RequestParam("appId") String appId, @RequestParam("file") MultipartFile file) throws IOException {
//        binaryRepository.saveApplicationBinary(appId, String.valueOf(file));
//    }
//
//    @GetMapping("/{appId}")
//    public Path getBinaryPath(@PathVariable String appId) {
//        return binaryRepository.getApplicationBinaryPath(appId);
//    }
//}
