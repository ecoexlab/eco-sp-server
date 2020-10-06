package com.ecoexlab.ecoapiserver.ObOrder;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ObOrderService {
    @Autowired
    private ObOrderRepository obOrderRepository;


    public ObOrder get(final String orderNo){

        ObOrder obOrder = obOrderRepository.getOne(orderNo);

        return obOrder;
    }

    public ObOrder save(ObOrder obOrder) {

        if(obOrder == null) {
            throw new NullPointerException("Order cannot be null.");
        }

        return obOrderRepository.save(obOrder);
    }

    public ObOrder update(ObOrder obOrder){
        if(obOrder == null){
            throw new NullPointerException("Order cannot be null");
        }

        Optional<ObOrder> order = obOrderRepository.findById(obOrder.getCl_order_no());

        return obOrderRepository.save(obOrder);
    }

    public List<ObOrder> getAll(){
        List<ObOrder> orders = new ArrayList<>();
        obOrderRepository.findAll().forEach(e -> orders.add(e));
        return orders;
    }

//

//
//    public void updateById(Long orderNo, ObOrder order){
//        Optional<ObOrder> e = obOrderRepository.findById(orderNo);
//
//        if(e.isPresent()){
//            // Save Something
//            obOrderRepository.save(order);
//        }
//    }
//
//    public ObOrder create(final ObOrder obOrder){
//        if(obOrder == null){
//            throw new NullPointerException("order cannot be null")
//        }
//    }
}
