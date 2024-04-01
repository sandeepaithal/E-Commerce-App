package org.jsp.ecommerce.service;

import org.jsp.ecommerce.dao.UserOrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserOrderService {
    @Autowired
    private UserOrderDao userorderdao;
}
