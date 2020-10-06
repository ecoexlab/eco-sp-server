package com.ecoexlab.ecoapiserver.ObOrder.ObOrderResponse;

import com.ecoexlab.ecoapiserver.ApiResponse.ApiResponse;
import com.ecoexlab.ecoapiserver.ObOrder.ObOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ObOrderChangeStatResponse extends ApiResponse<ObOrder> {

    private String vone_order_no;
    private String cl_order_no;
    private String order_stat;

    @Builder
    public ObOrderChangeStatResponse(final ObOrder obOrder, final List<String> errors){
        this.setRet_code(200);
        this.setOrder_stat(obOrder.getOrder_stat());
        this.setVone_order_no(obOrder.getVone_order_no());
        this.setCl_order_no(obOrder.getCl_order_no());
        this.setErrors(errors);
    }
}
