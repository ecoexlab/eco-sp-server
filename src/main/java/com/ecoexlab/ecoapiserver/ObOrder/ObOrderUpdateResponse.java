package com.ecoexlab.ecoapiserver.ObOrder;

import com.ecoexlab.ecoapiserver.ApiResponse.ApiResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ObOrderUpdateResponse extends ApiResponse<ObOrder> {

    private String vone_order_no;

    private String cl_order_no;

    private String bl_no;

    private String bl_img_url;

    @Builder
    public ObOrderUpdateResponse(final ObOrder obOrder, final List<String> errors){
        this.setRet_code(200);
        this.setVone_order_no(obOrder.getVone_order_no());
        this.setCl_order_no(obOrder.getCl_order_no());
        this.setBl_no("UPDATE_BL_IMG_URL");
        this.setBl_img_url("UPDATE_BL_IMG_URL");
        this.setErrors(errors);
    }
}
