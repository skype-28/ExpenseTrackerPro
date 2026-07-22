package com.skp.expensetrackerpro.service;

import com.skp.expensetrackerpro.dto.DashboardDto;
import com.skp.expensetrackerpro.entity.User;

public interface DashboardService {
    
    DashboardDto getDashboard(User user);
}
