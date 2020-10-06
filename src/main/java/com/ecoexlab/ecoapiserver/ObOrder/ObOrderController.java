package com.ecoexlab.ecoapiserver.ObOrder;

import com.ecoexlab.ecoapiserver.ObOrder.ObOrderResponse.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("ob_order")
public class ObOrderController {

    @Autowired
    private ObOrderService obOrderService;


    @RequestMapping(method = RequestMethod.GET, value="/{orderNo}")
    public @ResponseBody
    ObOrderGetResponse get(@PathVariable(value="orderNo") String orderNo){
        List<String> errors = new ArrayList<>();

        ObOrder obOrder = obOrderService.get(orderNo);
        return ObOrderAdapter.toGetOrderResponse(obOrder, errors);
    }

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody
    ObOrderGetAllResponse getAll(){
        List<String> errors = new ArrayList<>();
        List<ObOrder> obOrders = obOrderService.getAll();
        List<ObOrderGetResponse> obOrderResponses = new ArrayList<>();
        obOrders.stream().forEach(obOrder -> {
            obOrderResponses.add(ObOrderAdapter.toGetOrderResponse(obOrder, errors));
        });

        return ObOrderAdapter.toGetAllOrderResponse(obOrderResponses, errors);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ObOrderCreateResponse create(@RequestBody final ObOrderRequest obOrderRequest){
        List<String> errors = new ArrayList<>();

        ObOrder obOrder = ObOrderAdapter.toObOrder(obOrderRequest);

        try {
            obOrder = obOrderService.save(obOrder);
        } catch (final Exception e){
            errors.add(e.getMessage());
            e.printStackTrace();
        }

        return ObOrderAdapter.toCreateOrderResponse(obOrder, errors);
    }


    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, value="/update")
    public @ResponseBody
    ObOrderUpdateResponse update(@RequestBody final ObOrderRequest obOrderRequest){
        List<String> errors = new ArrayList<>();

        ObOrder obOrder = ObOrderAdapter.toObOrder(obOrderRequest);

        try {
            obOrder = obOrderService.update(obOrder);
        } catch (final Exception e){
            errors.add(e.getMessage());
            e.printStackTrace();
        }

        return ObOrderAdapter.toUpdateOrderResponse(obOrder, errors);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, value="/cancel/{orderNo}")
    public @ResponseBody
    ObOrderCancelResponse cancel(@PathVariable(value="orderNo") String orderNo){
        List <String> errors = new ArrayList<>();

        ObOrder obOrder = obOrderService.get(orderNo);

        // 주문취소 요
        obOrder.setOrder_stat("30");

        try{
            obOrder = obOrderService.update(obOrder);
        } catch (final Exception e){
            errors.add(e.getMessage());
            e.printStackTrace();
        }

        return ObOrderAdapter.toCancelOrderResponse(obOrder, errors);
    }


    @RequestMapping(method= RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE, value="/change_stat")
    public @ResponseBody
    ObOrderChangeStatResponse changeStat(@RequestBody final ObOrderRequest obOrderRequest){
        List <String> errors = new ArrayList<>();

        ObOrder obOrder = obOrderService.get(obOrderRequest.getCl_order_no());
        obOrder.setOrder_stat(obOrderRequest.getOrder_stat());
        obOrder.setUpdated_dt(new Date());

        try{
            obOrder = obOrderService.update(obOrder);
        } catch(final Exception e){
            errors.add(e.getMessage());
            e.printStackTrace();
        }

        return ObOrderAdapter.toChangeStatObOrderResponse(obOrder, errors);


    }

}
