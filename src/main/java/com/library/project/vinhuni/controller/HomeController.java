package com.library.project.vinhuni.controller;

import com.library.project.vinhuni.entity.Sach;
import com.library.project.vinhuni.repository.SachIRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private final SachIRepository sachRepository;

    public HomeController(SachIRepository sachRepository) {
        this.sachRepository = sachRepository;
    }

    @GetMapping("/")
    public String home(Model model,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "12") int size,
                       @RequestParam(required = false) String sort) {

        Sort s = switch (sort == null ? "" : sort) {
            case "nameAsc" -> Sort.by(Sort.Direction.ASC, "tenSach");
            case "nameDesc" -> Sort.by(Sort.Direction.DESC, "tenSach");
            case "yearDesc" -> Sort.by(Sort.Direction.DESC, "namXuatBan");
            case "newest" -> Sort.by(Sort.Direction.DESC, "ngayNhap");
            default -> Sort.by(Sort.Direction.DESC, "maSach");
        };

        Pageable pageable = PageRequest.of(Math.max(page, 0), size, s);
        Page<Sach> p = sachRepository.findByHienTrue(pageable);

        model.addAttribute("books", p.getContent());
        model.addAttribute("page", p.getNumber());
        model.addAttribute("pageTotal", p.getTotalPages());
        model.addAttribute("totalBooks", p.getTotalElements());
        model.addAttribute("sort", sort);

        return "content/home";
    }
}
