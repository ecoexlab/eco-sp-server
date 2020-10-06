package com.ecoexlab.ecoapiserver.ObOrder.ObOrderResponse;

import com.ecoexlab.ecoapiserver.ApiResponse.ApiResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ObOrderGetAllResponse extends ApiResponse<List<ObOrderGetResponse>> {

    @Builder
    public ObOrderGetAllResponse(final List<ObOrderGetResponse> obOrderListResps, final List<String> errors){
        this.setRet_code(200);
        this.setData(obOrderListResps);
        this.setErrors(errors);
    }
}
