package com.restaurant.requestwrapper;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartRequestWrapper {

    private long userId;
    private long foodId;
    private long quantity;
}
