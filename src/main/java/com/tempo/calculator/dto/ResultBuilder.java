package com.tempo.calculator.dto;

import java.math.BigDecimal;


public class ResultBuilder {

   private ResultBuilder() {
   }


   public static Response getResponse( Object result ) {
      return Response.withResult(result.toString());
   }

   public static Response getResponse( BigDecimal result ) {
      return Response.withResult(result.toPlainString());
   }

   public static Response getResultFromError(String errorMessage) {
      return Response.withError(errorMessage);
   }
}
