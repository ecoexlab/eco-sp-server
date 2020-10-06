package com.ecoexlab.ecoapiserver.ObOrder.ObOrderResponse;

import com.ecoexlab.ecoapiserver.ApiResponse.ApiResponse;
import com.ecoexlab.ecoapiserver.ObOrder.ObOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ObOrderCreateResponse extends ApiResponse<ObOrder> {

    private String vone_order_no;

    private String bl_no;

    private String cl_order_no;

    private int cwgt;

    private String bl_img_url;


    @Builder
    public ObOrderCreateResponse(final ObOrder obOrder, final List<String> errors){
        this.setVone_order_no(obOrder.getVone_order_no());
        this.setBl_no("BL_NO");
        this.setCl_order_no(obOrder.getCl_order_no());
        this.setCwgt(getCwgt(obOrder.getVgt(), obOrder.getWgt()));
        this.setBl_img_url("BL_IMG_URL");

        this.setRet_code(200);
        this.setErrors(errors);
    }




    public int getCwgt(int vgt, int wgt){
        return vgt > wgt ? vgt : wgt;
    }
}
