package com.ecoexlab.ecoapiserver.ObOrder.ObOrderResponse;

import com.ecoexlab.ecoapiserver.ApiResponse.ApiResponse;
import com.ecoexlab.ecoapiserver.ObOrder.ObOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ObOrderCancelResponse extends ApiResponse<ObOrder> {

    private String vone_order_no;

    private String cl_order_no;

    @Builder
    public ObOrderCancelResponse(final ObOrder obOrder, final List<String> errors){
        this.setRet_code(200);
        this.setVone_order_no(obOrder.getVone_order_no());
        this.setCl_order_no(obOrder.getCl_order_no());
        this.setErrors(errors);
    }
}
