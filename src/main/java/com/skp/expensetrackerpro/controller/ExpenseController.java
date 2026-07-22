package com.skp.expensetrackerpro.controller;

import com.skp.expensetrackerpro.dto.ExpenseDto;
import com.skp.expensetrackerpro.entity.ExpenseCategory;
import com.skp.expensetrackerpro.entity.User;
import com.skp.expensetrackerpro.security.CustomUserDetails;
import com.skp.expensetrackerpro.service.ExpenseService;
import jakarta.validation.Valid;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/add")
    public String addExpensePage(Model model) {

        model.addAttribute("expenseDto", new ExpenseDto());
        model.addAttribute("categories", ExpenseCategory.values());

        return "expense/add";
    }

    @PostMapping("/add")
    public String saveExpense(
            @Valid @ModelAttribute ExpenseDto expenseDto,
            BindingResult result,
            @AuthenticationPrincipal CustomUserDetails userDetails,
            Model model) {

        if (result.hasErrors()) {

            model.addAttribute("categories", ExpenseCategory.values());

            return "expense/add";
        }

        User user = userDetails.getUser();

        expenseService.saveExpense(expenseDto, user);

        return "redirect:/expenses";
    }

    @GetMapping
public String expenses(
        @AuthenticationPrincipal CustomUserDetails userDetails,
        Model model){

    model.addAttribute(
            "expenses",
            expenseService.getUserExpenses(userDetails.getUser()));

    return "expense/list";
}

}