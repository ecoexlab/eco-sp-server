package com.ecoexlab.ecoapiserver.ObOrder.ObOrderResponse;

import com.ecoexlab.ecoapiserver.ApiResponse.ApiResponse;
import com.ecoexlab.ecoapiserver.ObOrder.ObOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ObOrderGetResponse extends ApiResponse<ObOrder> {

    @Builder
    public ObOrderGetResponse(final ObOrder obOrder, final List<String> errors){
        this.setRet_code(200);
        this.setData(obOrder);
        this.setErrors(errors);
    }
}

