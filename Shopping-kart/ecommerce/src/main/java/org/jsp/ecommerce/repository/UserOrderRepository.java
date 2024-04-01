package org.jsp.ecommerce.repository;

import org.jsp.ecommerce.model.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserOrderRepository extends JpaRepository<UserOrder, Long> {

}
