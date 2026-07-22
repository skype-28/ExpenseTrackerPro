package com.skp.expensetrackerpro.controller;

import com.skp.expensetrackerpro.security.CustomUserDetails;
import com.skp.expensetrackerpro.service.DashboardService;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/dashboard")
    public String dashboard(

            @AuthenticationPrincipal
            CustomUserDetails userDetails,

            Model model) {

        model.addAttribute(

                "dashboard",

                dashboardService.getDashboard(

                        userDetails.getUser()

                )

        );

        return "dashboard/index";

    }

}