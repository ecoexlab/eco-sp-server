package com.ecoexlab.ecoapiserver.ObOrder;

import com.ecoexlab.ecoapiserver.Product.Product;
import com.ecoexlab.ecoapiserver.ObOrder.ObOrderResponse.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ObOrderAdapter {

    public static ObOrderCreateResponse toCreateOrderResponse(final ObOrder obOrder, final List<String> errors){
        return ObOrderCreateResponse.builder()
                .obOrder(obOrder)
                .errors(errors)
                .build();
    }

    public static ObOrderGetResponse toGetOrderResponse(final ObOrder obOrder, final List<String> errors){
        return ObOrderGetResponse.builder()
                .obOrder(obOrder)
                .errors(errors)
                .build();
    }

    public static ObOrderGetAllResponse toGetAllOrderResponse(final List<ObOrderGetResponse> obOrderListResps, final List<String> errors){
        return ObOrderGetAllResponse.builder()
                .obOrderListResps(obOrderListResps)
                .errors(errors)
                .build();
    }

    public static ObOrderCancelResponse toCancelOrderResponse(final ObOrder obOrder, final List<String> errors){
        return ObOrderCancelResponse.builder()
                .obOrder(obOrder)
                .errors(errors)
                .build();
    }

    public static ObOrderUpdateResponse toUpdateOrderResponse(final ObOrder obOrder, final List<String> errors){
        return ObOrderUpdateResponse.builder()
                .obOrder(obOrder)
                .errors(errors)
                .build();
    }


    public static ObOrderChangeStatResponse toChangeStatObOrderResponse(final ObOrder obOrder, final List<String> errors){

        return ObOrderChangeStatResponse.builder()
                .obOrder(obOrder)
                .errors(errors)
                .build();
    }



    public static ObOrder toObOrder(final ObOrderRequest obOrderRequest){
        if(obOrderRequest == null){
            return null;
        }


        //VONE 주문번호 : Datetime format
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date time = new Date();
        String timeStr = dateFormat.format(time);
        obOrderRequest.setVone_order_no(timeStr);

        //주문상태 : 10 (주문접수)
        obOrderRequest.setOrder_stat("10");


        return ObOrder.builder()
                .vone_order_no(obOrderRequest.getVone_order_no())
                .seller_master_no(obOrderRequest.getSeller_master_no())
                .sender_name(obOrderRequest.getSender_name())
                .sender_code(obOrderRequest.getSender_code())
                .sender_tel(obOrderRequest.getSender_tel())
                .sender_addr1(obOrderRequest.getSender_addr1())
                .sender_addr2(obOrderRequest.getSender_addr2())
                .buyer_name(obOrderRequest.getBuyer_name())
                .buyer_country(obOrderRequest.getBuyer_country())
                .buyer_tel(obOrderRequest.getBuyer_tel())
                .buyer_addr1(obOrderRequest.getBuyer_addr1())
                .buyer_addr2(obOrderRequest.getBuyer_addr2())
                .zipcode(obOrderRequest.getZipcode())
                .w_size(obOrderRequest.getW_size())
                .l_size(obOrderRequest.getL_size())
                .h_size(obOrderRequest.getH_size())
                .vgt(obOrderRequest.getVgt())
                .wgt(obOrderRequest.getWgt())
                .order_stat(obOrderRequest.getOrder_stat())
                .prod_cnt(obOrderRequest.getProducts().size())
                .tot_amount(obOrderRequest.getTot_amount())
                .cl_order_no(obOrderRequest.getCl_order_no())
                .products(obOrderRequest.getProducts())
                .created_dt(new Date())
                .updated_dt(new Date())
                .build();


    }

    public int getProdCnt(List<Product> products){
        return products.size();
    }
}
